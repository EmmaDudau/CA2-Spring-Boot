package net.javaguides.springboot.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

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

//    @Column(name = "order_id")
//    private long orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_paid")
    private String orderPaid;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Product> products;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Employee> employees;

    public Order() {
    }

    public Order(long orderId, String customerId, String orderDate, String orderPaid, int quantityOrdered) {
        super();
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderPaid = orderPaid;
        this.quantityOrdered = quantityOrdered;
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

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }
}
