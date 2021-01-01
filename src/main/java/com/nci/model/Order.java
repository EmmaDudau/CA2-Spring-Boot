package com.nci.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private CustomerOrderId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id")
    private Product product;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_paid")
    private String orderPaid;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(String orderPaid) {
        this.orderPaid = orderPaid;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @JsonBackReference(value="customer-order")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerOrderId getId() {
        return id;
    }

    public void setId(CustomerOrderId id) {
        this.id = id;
    }
}
