package com.nci.model.dto;

public class OutboundOrderDto {

    private String orderId;
    private Long customerId;
    private String productName;
    private int quantity;
    private String orderDate;

    public OutboundOrderDto(String orderId, Long customerId, String productName, int quantity, String orderDate) {
        this.customerId = customerId;
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
