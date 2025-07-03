package com.kei.pojo;

import java.math.BigDecimal;

public class Course {
    private Integer id;
    private String name;
    private String instrumentType;
    private BigDecimal price;
    private Integer lessonCount;

    // 无参构造
    public Course() {
    }

    // 全参构造
    public Course(Integer id, String name, String instrumentType, BigDecimal price, Integer lessonCount) {
        this.id = id;
        this.name = name;
        this.instrumentType = instrumentType;
        this.price = price;
        this.lessonCount = lessonCount;
    }

    // Getter和Setter方法
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

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(Integer lessonCount) {
        this.lessonCount = lessonCount;
    }

    @Override
    public String toString() {
        return "课程信息{" +
                "ID=" + id +
                ", 名称='" + name + '\'' +
                ", 乐器类型='" + instrumentType + '\'' +
                ", 价格=" + price +
                ", 课次=" + lessonCount +
                '}';
    }
}