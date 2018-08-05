package com.mmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter  // 只生成Getter方法
@Setter  // 只生成Setter
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor  // 全参构造器
public class PayInfo {

    private Integer id;

    private Integer userId;

    private Long orderNo;

    private Integer payPlatform;

    private String platformNumber;

    private String platformStatus;

    private Date createTime;

    private Date updateTime;

}