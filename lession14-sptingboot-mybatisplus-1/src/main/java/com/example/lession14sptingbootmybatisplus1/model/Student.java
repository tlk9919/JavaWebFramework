package com.example.lession14sptingbootmybatisplus1.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * @classnam Student
 * @time 15:02
 * @date 2024/11/19
 */
@Data
@TableName("`student`")
public class Student {
    @TableId(type = IdType.AUTO)//@TableId 是 MyBatis-Plus 提供的注解，用于标识实体类中的某个字段作为数据库表的主键。
    private Integer id; //id 字段是 Student 类的主键。通过 @TableId(type = IdType.AUTO)，告诉 MyBatis-Plus 该字段是主键，并且数据库会自动生成它的值。

    private Integer snum;

    private  String sname;
}
