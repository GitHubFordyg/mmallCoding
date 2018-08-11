package com.mmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter  // 只生成Getter方法
@Setter  // 只生成Setter
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor  // 全参构造器
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;

}