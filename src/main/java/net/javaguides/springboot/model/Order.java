package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_paid")
    private String orderPaid;

    public Order() {
    }

    public Order(long orderId, String customerId, String orderDate, String orderPaid) {
        super();
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderPaid = orderPaid;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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
}
