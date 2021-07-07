package com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CashierAssignPaymentMode {
  
	
	@Id
	private String pay_method_code;
	private String cash_office_code;
	private String pay_method_desc;
	private Date pay_start_date; 
	private Date pay_end_date;
	private String cash_office_desc;
	private String branch_name;
	

	public String getPay_method_code() {
		return pay_method_code;
	}
	public void setPay_method_code(String pay_method_code) {
		this.pay_method_code = pay_method_code;
	}
	public String getCash_office_code() {
		return cash_office_code;
	}
	public void setCash_office_code(String cash_office_code) {
		this.cash_office_code = cash_office_code;
	}
	public String getPay_method_desc() {
		return pay_method_desc;
	}
	public void setPay_method_desc(String pay_method_desc) {
		this.pay_method_desc = pay_method_desc;
	}
	public Date getPay_start_date() {
		return pay_start_date;
	}
	public void setPay_start_date(Date pay_start_date) {
		this.pay_start_date = pay_start_date;
	}
	public Date getPay_end_date() {
		return pay_end_date;
	}
	public void setPay_end_date(Date pay_end_date) {
		this.pay_end_date = pay_end_date;
	}
	public String getCash_office_desc() {
		return cash_office_desc;
	}
	public void setCash_office_desc(String cash_office_desc) {
		this.cash_office_desc = cash_office_desc;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
		
}
