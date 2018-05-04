package com.bfei.icrane.api.redis;

import com.bfei.icrane.common.util.PropFileManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    private static PropFileManager propFileMgr = new PropFileManager("redis.properties");
    String redisAddr = propFileMgr.getProperty("REDISADDR");
    String redisPwd = propFileMgr.getProperty("REDISPWD");
    Integer redisPort = Integer.parseInt(propFileMgr.getProperty("REDISPORT"));
    Integer redisTimeout = Integer.parseInt(propFileMgr.getProperty("REDISOUT"));
    Integer cacheTimeout = Integer.parseInt(propFileMgr.getProperty("CACHEOUT"));

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(redisAddr);
        redisConnectionFactory.setPort(redisPort);
        redisConnectionFactory.setPassword(redisPwd);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(cacheTimeout); // Sets the default expire time (in seconds)
        return cacheManager;
    }

}