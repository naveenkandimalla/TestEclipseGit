package com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CORCollectionSummary {

	@Id
	private int id;
	private String	branch_code; 
	private String	branch_name;
	private BigInteger receipt_count;
	private double pay_method_id;
	private String pay_method_code;
	private String pay_method_desc;
	private double app_id;
	private String app_code;
	private String app_desc;
	private BigDecimal allocated_amount;
	private Date receipt_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public BigInteger getReceipt_count() {
		return receipt_count;
	}
	public void setReceipt_count(BigInteger receipt_count) {
		this.receipt_count = receipt_count;
	}
	public double getPay_method_id() {
		return pay_method_id;
	}
	public void setPay_method_id(double pay_method_id) {
		this.pay_method_id = pay_method_id;
	}
	public String getPay_method_code() {
		return pay_method_code;
	}
	public void setPay_method_code(String pay_method_code) {
		this.pay_method_code = pay_method_code;
	}
	public String getPay_method_desc() {
		return pay_method_desc;
	}
	public void setPay_method_desc(String pay_method_desc) {
		this.pay_method_desc = pay_method_desc;
	}
	public double getApp_id() {
		return app_id;
	}
	public void setApp_id(double app_id) {
		this.app_id = app_id;
	}
	public String getApp_code() {
		return app_code;
	}
	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}
	public String getApp_desc() {
		return app_desc;
	}
	public void setApp_desc(String app_desc) {
		this.app_desc = app_desc;
	}
	public BigDecimal getAllocated_amount() {
		return allocated_amount;
	}
	public void setAllocated_amount(BigDecimal allocated_amount) {
		this.allocated_amount = allocated_amount;
	}
	public Date getReceipt_date() {
		return receipt_date;
	}
	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}
	
	
	
	
	
	
	

}
