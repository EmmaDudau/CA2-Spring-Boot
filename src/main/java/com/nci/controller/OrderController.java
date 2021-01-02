package com.nci.controller;

import com.nci.exception.ResourceNotFoundException;
import com.nci.model.CustomerOrderId;
import com.nci.model.Order;
import com.nci.model.Product;
import com.nci.model.dto.InboundOrderDto;
import com.nci.model.dto.OutboundOrderDto;
import com.nci.repository.OrderRepository;
import com.nci.repository.ProductRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:8080" })
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // get all orders
    @GetMapping("/orders")
    public List<OutboundOrderDto> getAllOrders(){
        List<Order> orderList =  orderRepository.findAll();
        List<Product> productList = productRepository.findAll();

        List<OutboundOrderDto> outboundOrderDtos = new ArrayList<>();
        for (Order next : orderList){
            outboundOrderDtos.add(new OutboundOrderDto(next.getId().getOrderId(),next.getId().getCustomerId(),
                    getProductNameById(productList, next.getId().getProductId()),
                    next.getQuantityOrdered(), next.getOrderDate() ));
        }
        return outboundOrderDtos;
    }

    // create order rest api
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody InboundOrderDto inboundOrderDto) {

        String orderUniqueId = generateOrderId();

        for (String next : inboundOrderDto.getProductList() ) {
        CustomerOrderId customerOrderId = new CustomerOrderId();
        customerOrderId.setCustomerId(inboundOrderDto.getCustomerId());
        customerOrderId.setProductId(Long.valueOf(next));
        customerOrderId.setOrderId(orderUniqueId);

            Order newOrder = new Order();
            newOrder.setId(customerOrderId);
            newOrder.setQuantityOrdered(inboundOrderDto.getQuantity());
            newOrder.setOrderDate(getTodayDateAsString());
            newOrder.setOrderPaid("Y");
            orderRepository.save(newOrder);
        };

        return new ResponseEntity<>("new order created", HttpStatus.CREATED);
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



    private String getTodayDateAsString(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

    private String generateOrderId(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return  generatedString;
    }

    private String getProductNameById(List<Product> productList, Long productId){
        for(Product next : productList){
            if(next.getId() == productId){
                return next.getProductName();
            }
        }
        return null;
    }


}
