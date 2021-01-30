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
import org.springframework.web.client.RestTemplate;

import com.restapi.exception.ResourceNotFoundException;
import com.restapi.model.Order1;
import com.restapi.model.Product;
import com.restapi.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class OrderController {

	@Autowired
	private OrderRepository orderRep;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/orders")
	public List<Order1> getAllOrders() {
		return orderRep.findAll();
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order1> getOrderById(@PathVariable(value = "id") Integer oId)
			throws ResourceNotFoundException {
		Order1 order = orderRep.findById(oId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + oId));
		return ResponseEntity.ok().body(order);
	}

	// ,@Validated @RequestBody Order1 order
	@PostMapping("/orders/{productId}")
	public String placeOrderForProduct(@PathVariable(value = "productId") Integer pId,
			@Validated @RequestBody Order1 order) {
		//String uri = "http://localhost:8080/rest/api/products/";
		String uri = "http://product-service";
		String msg = "";
		ResponseEntity<Product> response = restTemplate.getForEntity(uri + pId, Product.class);
		if (response.getStatusCodeValue()==200) {
			int o1 = 0;
			o1 = orderRep.save(order).getOrder_id();
			msg = "Order successfully generated with order id " + o1;
		} else{
			msg = "Order not generated!";
		}
		return msg;
	}

}
