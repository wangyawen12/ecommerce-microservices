package com.example.orderservice.event;

import java.math.BigDecimal;

public class OrderPlacedEvent {

    private String orderNumber;
    private String skuCode;
    private Integer quantity;
    private BigDecimal price;

    public OrderPlacedEvent() {
    }

    public OrderPlacedEvent(String orderNumber, String skuCode, Integer quantity, BigDecimal price) {
        this.orderNumber = orderNumber;
        this.skuCode = skuCode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderPlacedEvent{" +
                "orderNumber='" + orderNumber + '\'' +
                ", skuCode='" + skuCode + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}