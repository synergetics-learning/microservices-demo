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
import com.restapi.model.Invoice;
import com.restapi.model.Order1;
import com.restapi.model.Product;
import com.restapi.repository.InvoiceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRep;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {
		return invoiceRep.findAll();
	}

	@GetMapping("/invoices/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") Integer oId)
			throws ResourceNotFoundException {
		Invoice invoice = invoiceRep.findById(oId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + oId));
		return ResponseEntity.ok().body(invoice);
	}

	
	public float getTotalAmtforOrder(int oid) {
		//String uri1 = "http://localhost:8081/rest/api/orders/";
		String uri1="http://orderprocessing-service";
		ResponseEntity<Order1> response1 = restTemplate.getForEntity(uri1 + oid, Order1.class);
		Order1 order1 = response1.getBody();
		System.out.print(order1);
		
		return order1.getQty()* getProductPrice(order1);
	}


	public float getProductPrice(Order1 o1) {
		int pid = o1.getP_id();
		System.out.print("pid :" + o1.getP_id());
	//	String uri2 = "http://localhost:8080/rest/api/products/";
		String uri2 ="http://product-service";
		ResponseEntity<Product> response2 = restTemplate.getForEntity(uri2 + pid, Product.class);
		Product prod = response2.getBody();
		System.out.print(prod);
		
		return prod.getPrice();
	}

	@PostMapping("/invoices/{orderId}")
	public Invoice addInvoiceForOrder(@PathVariable(value = "orderId") Integer oid) {

		Invoice invoice = new Invoice();
		float amt = 0;
			
			
			amt = getTotalAmtforOrder(oid);
			
			if(amt>0) {
			invoice.setO_id(oid);
			invoice.setPayment_status("Paid");
			invoice.setTotal_amt(amt);

			return invoiceRep.save(invoice);
		} else
			return null;
	}

}
