package com.sais.cashoffice.CashOfficeTest.cashofficeReports.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CORReceiptListing {

	@Id
	private  int    id   ;                   
	private  double    receipt_no   ;        
	private Date   receipt_date;         
	private String  received_from  ;      
	private double pay_method_id  ;      
	private BigDecimal receipt_amount  ;     
	private String pay_method_code ;     
	private String pay_method_desc ;     
	private String branch_code     ;     
	private double cash_office_id  ;     
	private String cash_office_code ;    
	private String cash_office_desc ;    
	private char posting_status ;      
	private BigDecimal posting_reference;    
	private String branch_name     ;     
	private double app_id ;              
	private String app_code ;            
	private String app_desc ;            
	private double rcpt_all_id  ;        
	private double rcpt_trn_id  ;        
	private BigDecimal rec_allocated_amount ;
	private char reallocation_status  ;
	private double app_activity_id  ;    
	private String app_activity_code ;   
	private String app_activity_desc ;   
	private Date period        ;       
	private String  policy_code  ;        
	private  String payor ;               
	private int product_code;         
	private int paypoint_id ;         
	private String paypoint_name;        
	private String loan_type ;         
	private String  deal_number;          
	private BigDecimal units_encashed ;      
	private double act_allocated_amount ;
	private double cashier_id;           
	private String cashier_code ;        
	private String cashier_name ;        
	private String reference_number;     
	private Date reference_date ;      
	private String  drawee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getReceived_from() {
		return received_from;
	}
	public void setReceived_from(String received_from) {
		this.received_from = received_from;
	}
	public double getPay_method_id() {
		return pay_method_id;
	}
	public void setPay_method_id(double pay_method_id) {
		this.pay_method_id = pay_method_id;
	}
	public BigDecimal getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(BigDecimal receipt_amount) {
		this.receipt_amount = receipt_amount;
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
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public double getCash_office_id() {
		return cash_office_id;
	}
	public void setCash_office_id(double cash_office_id) {
		this.cash_office_id = cash_office_id;
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
	public char getPosting_status() {
		return posting_status;
	}
	public void setPosting_status(char posting_status) {
		this.posting_status = posting_status;
	}
	public BigDecimal getPosting_reference() {
		return posting_reference;
	}
	public void setPosting_reference(BigDecimal posting_reference) {
		this.posting_reference = posting_reference;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
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
	public double getRcpt_all_id() {
		return rcpt_all_id;
	}
	public void setRcpt_all_id(double rcpt_all_id) {
		this.rcpt_all_id = rcpt_all_id;
	}
	public double getRcpt_trn_id() {
		return rcpt_trn_id;
	}
	public void setRcpt_trn_id(double rcpt_trn_id) {
		this.rcpt_trn_id = rcpt_trn_id;
	}
	public BigDecimal getRec_allocated_amount() {
		return rec_allocated_amount;
	}
	public void setRec_allocated_amount(BigDecimal rec_allocated_amount) {
		this.rec_allocated_amount = rec_allocated_amount;
	}
	public char getReallocation_status() {
		return reallocation_status;
	}
	public void setReallocation_status(char reallocation_status) {
		this.reallocation_status = reallocation_status;
	}
	public double getApp_activity_id() {
		return app_activity_id;
	}
	public void setApp_activity_id(double app_activity_id) {
		this.app_activity_id = app_activity_id;
	}
	public String getApp_activity_code() {
		return app_activity_code;
	}
	public void setApp_activity_code(String app_activity_code) {
		this.app_activity_code = app_activity_code;
	}
	public String getApp_activity_desc() {
		return app_activity_desc;
	}
	public void setApp_activity_desc(String app_activity_desc) {
		this.app_activity_desc = app_activity_desc;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public String getPolicy_code() {
		return policy_code;
	}
	public void setPolicy_code(String policy_code) {
		this.policy_code = policy_code;
	}
	public String getPayor() {
		return payor;
	}
	public void setPayor(String payor) {
		this.payor = payor;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getPaypoint_id() {
		return paypoint_id;
	}
	public void setPaypoint_id(int paypoint_id) {
		this.paypoint_id = paypoint_id;
	}
	public String getPaypoint_name() {
		return paypoint_name;
	}
	public void setPaypoint_name(String paypoint_name) {
		this.paypoint_name = paypoint_name;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public String getDeal_number() {
		return deal_number;
	}
	public void setDeal_number(String deal_number) {
		this.deal_number = deal_number;
	}
	public BigDecimal getUnits_encashed() {
		return units_encashed;
	}
	public void setUnits_encashed(BigDecimal units_encashed) {
		this.units_encashed = units_encashed;
	}
	public double getAct_allocated_amount() {
		return act_allocated_amount;
	}
	public void setAct_allocated_amount(double act_allocated_amount) {
		this.act_allocated_amount = act_allocated_amount;
	}
	public double getCashier_id() {
		return cashier_id;
	}
	public void setCashier_id(double cashier_id) {
		this.cashier_id = cashier_id;
	}
	public String getCashier_code() {
		return cashier_code;
	}
	public void setCashier_code(String cashier_code) {
		this.cashier_code = cashier_code;
	}
	public String getCashier_name() {
		return cashier_name;
	}
	public void setCashier_name(String cashier_name) {
		this.cashier_name = cashier_name;
	}
	public String getReference_number() {
		return reference_number;
	}
	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}
	public Date getReference_date() {
		return reference_date;
	}
	public void setReference_date(Date reference_date) {
		this.reference_date = reference_date;
	}
	public String getDrawee() {
		return drawee;
	}
	public void setDrawee(String drawee) {
		this.drawee = drawee;
	}

	

	
}
