package com.restapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Order1")
public class Order1 {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1,initialValue = 1101)
	private int order_id;
	
	@Column
	private String cust_name;
	@Column
	private String cust_addr;
	@Column
	private LocalDateTime order_datetime;
	@Column
	private String order_status;
	@Column
	private int p_id;
	@Column
	private int qty;

	public Order1() {}
	
	
	public Order1(int order_id, String cust_name, String cust_addr, LocalDateTime order_datetime, String order_status,
			int p_id, int qty) {

		this.order_id = order_id;
		this.cust_name = cust_name;
		this.cust_addr = cust_addr;
		this.order_datetime = order_datetime;
		this.order_status = order_status;
		this.p_id = p_id;
		this.qty = qty;
	}


    
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_addr() {
		return cust_addr;
	}
	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
	}
	public LocalDateTime getOrder_datetime() {
		return order_datetime;
	}
	public void setOrder_datetime(LocalDateTime order_datetime) {
		this.order_datetime = order_datetime;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
