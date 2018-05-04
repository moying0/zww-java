package com.bfei.icrane.core.models;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SUN on 2018/3/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vip implements Serializable {
    private static final long serialVersionUID = 3461345624134523452L;
    private long id;                    //id
    private int level;                  //等级
    private String name;                //会员名称
    private BigDecimal leastAllowed;    //最低额度
    private int exemptionPostageNumber; //包邮个数
    private int deliveryTime;           //发货时效
    private int checkTime;              //寄存时效
    private boolean flashAppeal;        //闪电申诉
    private String discount;            //充值折扣

    public String getDiscount() {
        return delZero(discount);
    }

    public static String delZero(String src) {
        if ("10".equals(src)) {
            return src;
        }
        if (src.endsWith("0")) {
            return delZero(src.substring(0, src.length() - 1));
        }
        if (src.endsWith(".")) {
            return delZero(src.substring(0, src.length() - 1));
        } else
            return src;
    }
}
