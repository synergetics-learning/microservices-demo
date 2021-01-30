package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exception.ResourceNotFoundException;
import com.restapi.model.Product;
import com.restapi.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductRepository prodRep;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return prodRep.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer pId)
			throws ResourceNotFoundException {
		Product product = prodRep.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/products")
	public String addProduct(@Validated @RequestBody Product product) {
		String msg = "";
		int p1 = 0;
		p1 = prodRep.save(product).getPid();
		if (p1 > 0)
			msg = "Product added successfully with id" + p1;
		else
			msg = "Can not add Product!";

		return msg;
	}

}
