package com.sais.cashoffice.CashOfficeTest.BankStatementPosting.Model;

import java.util.Date;

public class BankStmtPostingInterfaceModel {

	private double id;
	private double bankstmtid ;
	private String transcationcode ;
	private double cashierid;
	private Date createddate;
	private String createdby;
	private char postingstatus;
	
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public double getBankstmtid() {
		return bankstmtid;
	}
	public void setBankstmtid(double bankstmtid) {
		this.bankstmtid = bankstmtid;
	}
	public String getTranscationcode() {
		return transcationcode;
	}
	public void setTranscationcode(String transcationcode) {
		this.transcationcode = transcationcode;
	}
	public double getCashierid() {
		return cashierid;
	}
	public void setCashierid(double cashierid) {
		this.cashierid = cashierid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public char getPostingstatus() {
		return postingstatus;
	}
	public void setPostingstatus(char postingstatus) {
		this.postingstatus = postingstatus;
	}
	
	
	
	
	

}
