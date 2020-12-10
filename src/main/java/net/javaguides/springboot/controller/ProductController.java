package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Products;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired
	private ProductsRepository productsRepository;
	
	// get all products
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}		
	
	// create products rest api
	@PostMapping("/products")
	public Products createProducts(@RequestBody Products products) {
		return productsRepository.save(products);
	}
	
	// get products by id rest api
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable Long id) {
		Products products = productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		return ResponseEntity.ok(products);
	}
	
	// update products rest api
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProducts(@PathVariable Long id, @RequestBody Products productDetails){
		Products products = productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		
		products.setProductName(productDetails.getProductName());
		products.setProductQuantity(productDetails.getProductQuantity());
		products.setProductModified(productDetails.getProductModified());
		products.setProductCreated(productDetails.getProductCreated());
		products.setProductPrice(productDetails.getProductPrice());
		products.setProductBarcode(productDetails.getProductBarcode());

		Products updatedProducts = productsRepository.save(products);
		return ResponseEntity.ok(updatedProducts);
	}
	
	// delete products rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProducts(@PathVariable Long id){
		Products products = productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
		
		productsRepository.delete(products);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
