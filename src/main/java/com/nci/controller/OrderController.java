package com.nci.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrderController {

//    @Autowired
//    private OrderRepository orderRepository;
//
//    // get all orders
//    @GetMapping("/orders")
//    public List<Order> getAllOrders(){
//        return orderRepository.findAll();
//    }
//
//    // create order rest api
//    @PostMapping("/orders")
//    public Order createOrder(@RequestBody Order order) {
//        return orderRepository.save(order);
//    }
//
//    // get order by id rest api
//    @GetMapping("/orders/{id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
//        return ResponseEntity.ok(order);
//    }
//
//    // update order rest api
//
//    @PutMapping("/orders/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails){
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
//        order.setOrderDate(orderDetails.getOrderDate());
//        order.setOrderPaid(orderDetails.getOrderPaid());
//        order.setQuantityOrdered(orderDetails.getQuantityOrdered());
//
//        Order updatedOrder = orderRepository.save(order);
//        return ResponseEntity.ok(updatedOrder);
//    }
//
//    // delete order rest api
//    @DeleteMapping("/orders/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id){
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
//
//        orderRepository.delete(order);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }


}
