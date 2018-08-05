package com.mmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter  // 只生成Getter方法
@Setter  // 只生成Setter
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor  // 全参构造器
public class Order {

    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer shippingId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;  // 邮费

    private Integer status;

    private Date paymentTime;

    private Date sendTime;  // 发货时间

    private Date endTime;  // 结束时间

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

}