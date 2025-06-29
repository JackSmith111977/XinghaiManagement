package com.kei.pojo;

public class Student {
    private Integer id;
    private String name;
    private String phone;
    private Integer classId;
    private Integer courseId;

    // 全参构造
    public Student(Integer id, String name, String phone, Integer classId, Integer courseId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.classId = classId;
        this.courseId = courseId;
    }

    // 无参构造
    public Student() {
    }

    // getter和setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    // toString方法
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", classId=" + classId +
                ", courseId=" + courseId +
                '}';
    }
}
