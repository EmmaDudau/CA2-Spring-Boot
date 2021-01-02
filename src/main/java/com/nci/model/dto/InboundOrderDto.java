package com.nci.model.dto;

public class InboundOrderDto {

    private Long customerId;
    private String [] productList;
    private int quantity;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getProductList() {
        return productList;
    }

    public void setProductList(String[] productList) {
        this.productList = productList;
    }
}
