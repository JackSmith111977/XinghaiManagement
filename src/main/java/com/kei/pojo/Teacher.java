package com.kei.pojo;

import java.time.LocalDate;

/**
 * 邱显煜
 */

public class Teacher {
    private Integer id;
    private String name;
    private Integer classId;
    private LocalDate beginTime;
    private LocalDate endTime;
    private Double fee;

    // 全参构造


    public Teacher(Integer id, String name, Integer classId, LocalDate beginTime, LocalDate endTime, Double fee) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.fee = fee;
    }

    // 无参构造
    public Teacher() {
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    // toString方法
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", fee=" + fee +
                '}';
    }
}
