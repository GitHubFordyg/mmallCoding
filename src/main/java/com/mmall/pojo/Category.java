package com.mmall.pojo;

import lombok.*;

import java.util.Date;

@Getter // getter方法
@Setter  //setter方法
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor  // 全参构造器
@EqualsAndHashCode(of = "id")  //  根据id重新Equals和HashCode方法
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}