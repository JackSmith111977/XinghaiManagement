package com.kei.pojo;

import lombok.Getter;

import java.time.LocalDate;

public class Purchase {
    private Integer id;
    private Integer customerId;
    private LocalDate purchaseDate;
    private Integer price;
    private String sellerName;

    public Purchase(Integer id, Integer customerId, LocalDate purchaseDate, Integer price, String sellerName) {
        this.id = id;
        this.customerId = customerId;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.sellerName = sellerName;
    }

    public Purchase() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
