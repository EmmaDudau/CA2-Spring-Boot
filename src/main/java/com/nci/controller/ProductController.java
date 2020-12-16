package com.nci.controller;

import com.nci.exception.ResourceNotFoundException;
import com.nci.model.Product;
import com.nci.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	// get all products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}		
	
	// create products rest api
	@PostMapping("/products")
	public Product createProducts(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// get products by id rest api
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		return ResponseEntity.ok(product);
	}
	
	// update products rest api
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProducts(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		
		product.setProductName(productDetails.getProductName());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setProductModified(productDetails.getProductModified());
		product.setProductCreated(productDetails.getProductCreated());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductBarcode(productDetails.getProductBarcode());

		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete products rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProducts(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
