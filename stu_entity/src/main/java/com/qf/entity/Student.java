package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author bllt
 * @Date 2019/11/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_student")
public class Student extends BaseEntity{
    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT%2B8")
    /*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private Date birthday;
    private  int cid;
    @TableField(exist = false)
    public Classes cls;
}
