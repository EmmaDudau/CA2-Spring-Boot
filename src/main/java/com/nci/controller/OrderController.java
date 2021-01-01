package com.nci.controller;

import com.nci.exception.ResourceNotFoundException;
import com.nci.model.Order;
import com.nci.repository.OrderRepository;
import com.nci.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:8080" })
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // create order rest api
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
//        CustomerOrderId customerOrderId = new CustomerOrderId();
//        customerOrderId.setCustomerId(1L);
//        customerOrderId.setProductId(1L);
//        customerOrderId.setOrderId(String.valueOf(ThreadLocalRandom.current().nextInt()));
//
//        Order o  = new Order();
//        o.setId(customerOrderId);
//        o.setQuantityOrdered(23);
//        o.setOrderDate("12/12/2020");
//        o.setOrderPaid("Y");

        return orderRepository.save(order);
    }

    // get order by id rest api
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
        return ResponseEntity.ok(order);
    }

    // update order rest api

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));

        order.setProduct(orderDetails.getProduct());
        order.setCustomer(orderDetails.getCustomer());
        order.setQuantityOrdered(orderDetails.getQuantityOrdered());
        order.setOrderPaid(orderDetails.getOrderPaid());
        order.setOrderDate(orderDetails.getOrderDate());


        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // delete order rest api
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));

        orderRepository.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
