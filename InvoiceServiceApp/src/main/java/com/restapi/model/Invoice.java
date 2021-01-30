package com.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@Column(name="invoice_id")
	@GeneratedValue(generator="my_seq1")
	@SequenceGenerator(name="my_seq1",sequenceName="MY_SEQ1", allocationSize=1,initialValue = 1101)
	private int invoice_id;
	@Column(name="o_id")
	private int o_id;
	@Column(name="total_amt")
	private float total_amt;
	@Column(name="payment_status")
	private String payment_status;
	

	public Invoice() {}
	public Invoice(int invoice_id, int o_id, float total_amt, String payment_status) {

		this.invoice_id = invoice_id;
		this.o_id = o_id;
		this.total_amt = total_amt;
		this.payment_status = payment_status;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public float getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(float total_amt) {
		this.total_amt = total_amt;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	

}
