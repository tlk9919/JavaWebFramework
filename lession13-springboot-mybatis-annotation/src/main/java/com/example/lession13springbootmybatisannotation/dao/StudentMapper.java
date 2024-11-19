package com.example.lession13springbootmybatisannotation.dao;

import com.example.lession13springbootmybatisannotation.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author admin
 * @classnam StudentDao
 * @time 17:20
 * @date 2024/11/19
 */
@Mapper
public interface StudentMapper {
    @Insert(" insert into Student (snum, sname) values (#{snum}, #{sname});")
    int saveStudent(Student student);

    /*
     * 根据id查询学生
     * */
    @Select("   select id,snum,sname from student where id = #{id}")
//    @Results({
//            @Result(id=true,column = "id",property = "id"),
//            @Result(column = "snum",property = "snum"),
//            @Result(column = "sname",property = "sname")
//    })
//    @Results 结果映射配置，当数据库表的列名与 Java 对象的属性名完全一致，MyBatis 会自动进行默认的结果映射，这时可以省略 @Results 注解。
    Student getStudentByID(int id);

    /*
     * 根据姓名查询学生
     * */
    @Select("select id,snum,sname from student where sname LIKE CONCAT('%', #{name}, '%')")
    List<Student> getStudentByName(String name);

    /*
     * 查询所有学生
     * */
    @Select("select * from student")
    List<Student> getAllStudent();

    /*
     * 根据id修改学生信息
     * */
    @Update("update Student set  snum=#{snum}, sname=#{sname}  where id=#{id};")
    int updateStudentById(Student student);

    /*
     * 根据id删除学生
     * */
    @Delete("delete from Student where id=#{id};")
    int deleteStudentById(int id);
}
