
package org.jsp.product_api.controller;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//Saving One Product
	@Operation(summary = "Saving One Product")
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	//Save Multiple Products
	@Operation(summary = "Save Multiple Products")
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	//Fetch All Products
	@Operation(summary = "Fetch All Products")
	@GetMapping("/products")
	public ResponseEntity<Object> fetchAllProducts(){
		return service.fetchAllProducts();
	}
	
	//Fetch Product By Id
	@Operation(summary = "Fetch Product By Id")
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.fetchById(id);
	}
	
	//Fetch Product By Name
	@Operation(summary = "Fetch Product By Name")
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> fetchByName(@PathVariable String name){
		return service.fetchByName(name);
	}
	
	//Fetch Products Price Greater Than
	@Operation(summary = "Fetch Products Price Greater Than")
	@GetMapping("/products/price/greater/{price}")
	public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
		return service.fetchByPriceGreater(price);
	}
	
	//Fetch Products By Stock Between
	@Operation(summary = "Fetch Products By Stock Between")
	@GetMapping("/products/stock/{min}/{max}")
	public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
		return service.fetchByStockBetween(min,max);
	}
	
	//Delete Product By Id
	@Operation(summary = "Delete Product By Id")
		@DeleteMapping("/products/{id}")
		public ResponseEntity<Object> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
		
		//Update Product - PUT
	@Operation(summary = "Update Product - PUT")
		@PutMapping("/products")
		public ResponseEntity<Object> updateRecord(@RequestBody Product product){
			return service.updateProduct(product);
		}
		
		//Update Product- PATCH
	@Operation(summary = "Update Product- PATCH")
		@PatchMapping("/products/{id}")
		public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Product product){
			return service.updateProduct(id,product);
		}
}
