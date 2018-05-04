package com.bfei.icrane.common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class})})
public class DynamicPlugin implements Interceptor {

    protected static final Logger logger = LoggerFactory.getLogger(DynamicPlugin.class);

    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*|.*charge_order\\u0020.*|.*t_member\\u0020.*|.*t_member_token\\u0020.*|.*account\\u0020.*|.*t_charge_rules\\u0020.*|.*member_charge_combo\\u0020.*|.*share_invite\\u0020.*|.*signed_sheet\\u0020.*";
    private static final String[] SQLIDS = {"getChargeHistory","getDollTopicList"};

    private static final Map<String, DynamicDataSourceGlobal> cacheMap = new ConcurrentHashMap<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if (!synchronizationActive) {
            Object[] objects = invocation.getArgs();
            MappedStatement ms = (MappedStatement) objects[0];
            DynamicDataSourceGlobal dynamicDataSourceGlobal = null;
            if ((dynamicDataSourceGlobal = cacheMap.get(ms.getId())) == null) {
                //读方法
                if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                    //!selectKey 为自增id查询主键(SELECT LAST_INSERT_ID() )方法，使用主库
                    if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                        dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                    } else {
                        //BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                        //String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                        String sqlid = ms.getId().substring(ms.getId().lastIndexOf(".") + 1, ms.getId().length());
                        //if (sqlid.matches(SQLIDS)) {
                        //    dynamicDataSourceGlobal = DynamicDataSourceGlobal.READ;
                        //} else {
                        //    dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                        //}
                        if (ArrayUtils.contains(SQLIDS, sqlid)) {
                            dynamicDataSourceGlobal = DynamicDataSourceGlobal.READ;
                        } else {
                            dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                        }
                    }
                } else {
                    dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                }
                logger.warn("设置方法[{}] use [{}] Strategy, SqlCommandType [{}]..", ms.getId(), dynamicDataSourceGlobal.name(), ms.getSqlCommandType().name());
                cacheMap.put(ms.getId(), dynamicDataSourceGlobal);
            }
            DynamicDataSourceHolder.putDataSource(dynamicDataSourceGlobal);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }
}