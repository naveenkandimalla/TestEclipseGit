package com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="vw_colbranch")
public class CORCollectionBranch {

	@Id
	private int s_no;
	private double receipt_no; 
	private Date receipt_date;
	private BigDecimal receipt_amount; 
	private String cash_office_code;
	private String cash_office_desc; 
	private String branch_code; 
	private String branch_name ;
	
    
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public double getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(double receipt_no) {
		this.receipt_no = receipt_no;
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
	public String getCash_office_code() {
		return cash_office_code;
	}
	public void setCash_office_code(String cash_office_code) {
		this.cash_office_code = cash_office_code;
	}
	public String getCash_office_desc() {
		return cash_office_desc;
	}
	public void setCash_office_desc(String cash_office_desc) {
		this.cash_office_desc = cash_office_desc;
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
	
	

}
