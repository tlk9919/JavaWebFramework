package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @classnam StudentDaoImpl
 * @time 17:23
 * @date 2024/10/29
 */
@Repository
public class StudentDaoImpl implements  StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //    private static final RowMapper<Student> STUDENT_ROW_MAPPER = new RowMapper<Student>() {
//        @Override
//        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Student student = new Student();
//            student.setId(rs.getInt("id"));
//            student.setSnum(rs.getInt("snum"));
//            student.setSname(rs.getString("sname"));
//            return student;
//        }
//    };
    @Override
    public int save(Student student) {
        String sql="insert into javaweb.student (snum,sname) values(?,?)";
        return jdbcTemplate.update(sql,student.getSnum(),student.getSname());
    }

    @Override
    public Student findById(int id) {
        String sql=" select * from javaweb.student where id=? ";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }
    //    参数传递：
//
//            new Object[]{id} 将 id 包装为一个数组，以便 JDBC 可以在执行 SQL 查询时用 id 替换占位符 ?。
//    结果映射：
//
//            new BeanPropertyRowMapper<>(Student.class) 负责将查询返回的结果行映射为 Student 对象。每一列的值将对应到 Student 类中相应的属性。
    @Override
    public List<Student> findAll() {
        String sql="select * from javaweb.student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public int update(Student student) {
        String sql="update javaweb.student set snum=?,sname=? where id=?";
        return jdbcTemplate.update(sql,student.getSnum(),student.getSname(),student.getId());
    }

    @Override
    public int deleteById(int id) {
        String sql="delete from javaweb.student where id=?";
        return jdbcTemplate.update(sql,id);
    }
}
