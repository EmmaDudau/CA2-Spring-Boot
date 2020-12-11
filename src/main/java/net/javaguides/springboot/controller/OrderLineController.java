package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.OrderLineRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    // get all orderLines
    @GetMapping("/orderLines")
    public List<OrderLine> getAllOrderLines(){
        return orderLineRepository.findAll();
    }

    // create orderLine rest api
    @PostMapping("/orderLines")
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    // get orderLine by id rest api
    @GetMapping("/orderLines/{id}")
    public ResponseEntity<OrderLine> getOrderLineById(@PathVariable Long id) {
        OrderLine orderLine = orderLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderLine not exist with id :" + id));
        return ResponseEntity.ok(orderLine);
    }

    // update orderLine rest api

    @PutMapping("/orderLines/{id}")
    public ResponseEntity<OrderLine> updateOrderLine(@PathVariable Long id, @RequestBody OrderLine orderLineDetails){
        OrderLine orderLine = orderLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderLine not exist with id :" + id));

        orderLine.setProductId(orderLineDetails.getProductId());
        orderLine.setQuantity(orderLineDetails.getQuantity());
        orderLine.setPriceEach(orderLineDetails.getPriceEach());

        OrderLine updatedOrderLine = orderLineRepository.save(orderLine);
        return ResponseEntity.ok(updatedOrderLine);
    }

    // delete orderLine rest api
    @DeleteMapping("/orderLines/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrderLine(@PathVariable Long id){
        OrderLine orderLine = orderLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderLine not exist with id :" + id));

        orderLineRepository.delete(orderLine);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}