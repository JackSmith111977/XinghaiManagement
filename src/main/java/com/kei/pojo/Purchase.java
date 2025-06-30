package com.kei.pojo;

import java.time.LocalDate;

public class Purchase {
    private Integer id;
    private Integer customerId;
    private Integer productId;
    private LocalDate purchaseDate;
    private Integer sellerId;
    //全参
    public Purchase(Integer id, Integer customerId, Integer productId, LocalDate purchaseDate, Integer sellerId) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.sellerId = sellerId;
    }
    //无参
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", purchaseDate=" + purchaseDate +
                ", sellerId=" + sellerId +
                '}';
    }
}
