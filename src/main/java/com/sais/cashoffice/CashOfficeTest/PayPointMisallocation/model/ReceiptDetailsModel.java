package com.sais.cashoffice.CashOfficeTest.PayPointMisallocation.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReceiptDetailsModel {
	
	private double receiptno;
	private char postingstatus;
	private Date period;
	private BigDecimal paypointid;
	private String paypointname;
	private BigDecimal amount;
	
	
	public double getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(double receiptno) {
		this.receiptno = receiptno;
	}
	public char getPostingstatus() {
		return postingstatus;
	}
	public void setPostingstatus(char postingstatus) {
		this.postingstatus = postingstatus;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public BigDecimal getPaypointid() {
		return paypointid;
	}
	public void setPaypointid(BigDecimal paypointid) {
		this.paypointid = paypointid;
	}
	public String getPaypointname() {
		return paypointname;
	}
	public void setPaypointname(String paypointname) {
		this.paypointname = paypointname;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	
	
	 

}
