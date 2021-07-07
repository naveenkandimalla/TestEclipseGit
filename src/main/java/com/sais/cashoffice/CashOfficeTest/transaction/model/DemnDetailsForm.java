package com.sais.cashoffice.CashOfficeTest.transaction.model;

import java.math.BigDecimal;

public class DemnDetailsForm {
	
	private BigDecimal amount;
	private String  denominationcode;
	private int id;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDenominationcode() {
		return denominationcode;
	}
	public void setDenominationcode(String denominationcode) {
		this.denominationcode = denominationcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
