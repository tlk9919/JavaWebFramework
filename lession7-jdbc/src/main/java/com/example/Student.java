package com.example;

/**
 * @author admin
 * @classnam Student
 * @time 15:14
 * @date 2024/10/21
 */
public class Student {
    //与数据库的属性一致
    private Integer id;

    private  Integer snum;

    private String sname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", snum=" + snum +
                ", sname='" + sname + '\'' +
                '}';
    }
}
