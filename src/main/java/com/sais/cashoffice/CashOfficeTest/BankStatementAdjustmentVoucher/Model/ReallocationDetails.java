package com.sais.cashoffice.CashOfficeTest.BankStatementAdjustmentVoucher.Model;

import java.math.BigDecimal;
import java.util.Date;

public class ReallocationDetails {
	
	private double bkStmtToReallDetId;
	private double appId;
	private double appActivityId;
	private String appActivityCode;
	private String referenceNo;
	private String referenceStatus;
	private Date toreallocateperiod;
	private String payor;
	private BigDecimal amount;
	private String transactionCode;
	private char toreallocpostingStatus;
	private String toreallocpostmeaning;
	private String appCode;
	private double bkstmtreallocid;
	private double bankstmtid;
	private String cashiername;
	private Date creationdate;
	private String createdby;
	private char postingstatus;

	
	
	
	
	public double getBankstmtid() {
		return bankstmtid;
	}
	public void setBankstmtid(double bankstmtid) {
		this.bankstmtid = bankstmtid;
	}
	public String getCashiername() {
		return cashiername;
	}
	public void setCashiername(String cashiername) {
		this.cashiername = cashiername;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
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
	public double getBkstmtreallocid() {
		return bkstmtreallocid;
	}
	public void setBkstmtreallocid(double bkstmtreallocid) {
		this.bkstmtreallocid = bkstmtreallocid;
	}
	public double getBkStmtToReallDetId() {
		return bkStmtToReallDetId;
	}
	public void setBkStmtToReallDetId(double bkStmtToReallDetId) {
		this.bkStmtToReallDetId = bkStmtToReallDetId;
	}
	public double getAppId() {
		return appId;
	}
	public void setAppId(double appId) {
		this.appId = appId;
	}
	public double getAppActivityId() {
		return appActivityId;
	}
	public void setAppActivityId(double appActivityId) {
		this.appActivityId = appActivityId;
	}
	public String getAppActivityCode() {
		return appActivityCode;
	}
	public void setAppActivityCode(String appActivityCode) {
		this.appActivityCode = appActivityCode;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getReferenceStatus() {
		return referenceStatus;
	}
	public void setReferenceStatus(String referenceStatus) {
		this.referenceStatus = referenceStatus;
	}
	public Date getToreallocateperiod() {
		return toreallocateperiod;
	}
	public void setToreallocateperiod(Date toreallocateperiod) {
		this.toreallocateperiod = toreallocateperiod;
	}
	public String getPayor() {
		return payor;
	}
	public void setPayor(String payor) {
		this.payor = payor;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public char getToreallocpostingStatus() {
		return toreallocpostingStatus;
	}
	public void setToreallocpostingStatus(char toreallocpostingStatus) {
		this.toreallocpostingStatus = toreallocpostingStatus;
	}
	public String getToreallocpostmeaning() {
		return toreallocpostmeaning;
	}
	public void setToreallocpostmeaning(String toreallocpostmeaning) {
		this.toreallocpostmeaning = toreallocpostmeaning;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	
	
	

}
