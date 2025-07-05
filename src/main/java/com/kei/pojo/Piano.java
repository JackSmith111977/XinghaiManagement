package com.kei.pojo;

import java.math.BigDecimal;

/**
 * 崔棋铭
 */

public class Piano {
    private Integer id;
    private String name; // 琴的名称或型号
    private String type; // 种类, 如：钢琴、小提琴
    private BigDecimal price; // 价格
    private String manufacturer; // 生产厂家

    // 全参构造
    public Piano(Integer id, String name, String type, BigDecimal price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    // 无参构造
    public Piano() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // toString方法
    @Override
    public String toString() {
        return "琴信息{" +
                "ID=" + id +
                ", 名称/型号='" + name + '\'' +
                ", 种类='" + type + '\'' +
                ", 价格=" + price +
                ", 生产厂家='" + manufacturer + '\'' +
                '}';
    }
}
