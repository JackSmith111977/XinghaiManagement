package com.kei.pojo;

import java.util.Date;

/**
 * 马璞
 */

public class ClassStudent {
    private Integer id;
    private Integer classId;      // 班级ID
    private Integer studentId;     // 学生ID
    private Date joinTime;         // 加入时间

    // 无参构造
    public ClassStudent() {
    }

    // 全参构造
    public ClassStudent(Integer id, Integer classId, Integer studentId, Date joinTime) {
        this.id = id;
        this.classId = classId;
        this.studentId = studentId;
        this.joinTime = joinTime;
    }

    // Getter和Setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    // toString方法
    @Override
    public String toString() {
        return "班级学生{" +
                "ID=" + id +
                ", 班级ID=" + classId +
                ", 学生ID=" + studentId +
                ", 加入时间=" + joinTime +
                '}';
    }
}