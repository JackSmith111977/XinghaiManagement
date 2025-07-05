package com.kei.pojo;

/**
 * 马璞
 */

public class ClassInfo {
    private Integer id;
    private String className;
    private Integer teacherId;
    private Integer courseId;
    private String schedule;

    // 无参构造
    public ClassInfo() {
    }

    // 全参构造
    public ClassInfo(Integer id, String className, Integer teacherId, Integer courseId, String schedule) {
        this.id = id;
        this.className = className;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.schedule = schedule;
    }

    // Getter和Setter方法

    // toString方法
    @Override
    public String toString() {
        return "班级信息{" +
                "ID=" + id +
                ", 名称='" + className + '\'' +
                ", 教师ID=" + teacherId +
                ", 课程ID=" + courseId +
                ", 时间='" + schedule + '\'' +
                '}';
    }
}