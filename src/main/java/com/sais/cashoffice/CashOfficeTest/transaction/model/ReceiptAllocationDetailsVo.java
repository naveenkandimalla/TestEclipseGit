package com.sais.cashoffice.CashOfficeTest.transaction.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReceiptAllocationDetailsVo {
	
	private double receiptNum;
	private double cashOfficeId;
	private double cashierId;
	private String comments;
	private Date receiptDate;
	private String cashOfficeCode;
	private String cashierCode;
	private double appId;
	private String appCode;
	private double recptAllTpolId;
	private double tpolAppActId;
	private String tpolAppActCode;
	private Date tpolAppActPeriod;
	private String policycode;
	private String policystatus;
	private BigDecimal tpolAllocatedAmount;
	private BigDecimal tpolArrears;
	private BigDecimal tpolExceptedAmount;
	private String tpolPayer;
	
	
	
	
	public BigDecimal getTpolArrears() {
		return tpolArrears;
	}
	public void setTpolArrears(BigDecimal tpolArrears) {
		this.tpolArrears = tpolArrears;
	}
	public BigDecimal getTpolExceptedAmount() {
		return tpolExceptedAmount;
	}
	public void setTpolExceptedAmount(BigDecimal tpolExceptedAmount) {
		this.tpolExceptedAmount = tpolExceptedAmount;
	}
	public String getTpolPayer() {
		return tpolPayer;
	}
	public void setTpolPayer(String tpolPayer) {
		this.tpolPayer = tpolPayer;
	}
	public double getReceiptNum() {
		return receiptNum;
	}
	public void setReceiptNum(double receiptNum) {
		this.receiptNum = receiptNum;
	}
	public double getCashOfficeId() {
		return cashOfficeId;
	}
	public void setCashOfficeId(double cashOfficeId) {
		this.cashOfficeId = cashOfficeId;
	}
	public double getCashierId() {
		return cashierId;
	}
	public void setCashierId(double cashierId) {
		this.cashierId = cashierId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getCashOfficeCode() {
		return cashOfficeCode;
	}
	public void setCashOfficeCode(String cashOfficeCode) {
		this.cashOfficeCode = cashOfficeCode;
	}
	public String getCashierCode() {
		return cashierCode;
	}
	public void setCashierCode(String cashierCode) {
		this.cashierCode = cashierCode;
	}
	public double getAppId() {
		return appId;
	}
	public void setAppId(double appId) {
		this.appId = appId;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public double getRecptAllTpolId() {
		return recptAllTpolId;
	}
	public void setRecptAllTpolId(double recptAllTpolId) {
		this.recptAllTpolId = recptAllTpolId;
	}
	public double getTpolAppActId() {
		return tpolAppActId;
	}
	public void setTpolAppActId(double tpolAppActId) {
		this.tpolAppActId = tpolAppActId;
	}
	public String getTpolAppActCode() {
		return tpolAppActCode;
	}
	public void setTpolAppActCode(String tpolAppActCode) {
		this.tpolAppActCode = tpolAppActCode;
	}
	public Date getTpolAppActPeriod() {
		return tpolAppActPeriod;
	}
	public void setTpolAppActPeriod(Date tpolAppActPeriod) {
		this.tpolAppActPeriod = tpolAppActPeriod;
	}
	public String getPolicycode() {
		return policycode;
	}
	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}
	public String getPolicystatus() {
		return policystatus;
	}
	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}
	public BigDecimal getTpolAllocatedAmount() {
		return tpolAllocatedAmount;
	}
	public void setTpolAllocatedAmount(BigDecimal tpolAllocatedAmount) {
		this.tpolAllocatedAmount = tpolAllocatedAmount;
	}
	
	
	

}
