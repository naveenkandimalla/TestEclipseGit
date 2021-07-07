package com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="vw_coldetail")
public class CORCollectionDetail {

	@Id
	private double cash_office_id; 
	private String	branch_code; 
	private String	branch_name;
	private Date receipt_date;
	private double receipt_no ;
	private BigDecimal receipt_amount;
	private double pay_method_id;
	private String pay_method_code;
	private String pay_method_desc;
	private double app_id;
	private String app_code;
	private String app_desc;
	private BigDecimal allocated_amount;
	
	public double getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(double receipt_no) {
		this.receipt_no = receipt_no;
	}
	public double getCash_office_id() {
		return cash_office_id;
	}
	public void setCash_office_id(double cash_office_id) {
		this.cash_office_id = cash_office_id;
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
	public Date getReceipt_date() {
		return receipt_date;
	}
	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}
	public BigDecimal getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(BigDecimal receipt_amount) {
		this.receipt_amount = receipt_amount;
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
	
}
