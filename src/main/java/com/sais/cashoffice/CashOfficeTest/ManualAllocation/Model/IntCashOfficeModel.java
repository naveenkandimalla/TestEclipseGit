package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model;

import java.math.BigDecimal;
import java.util.Date;

public class IntCashOfficeModel {

	
	
	private double listid;
	private double receiptno;
	private String paymentfor;
	private Date dueDate;
	private BigDecimal partyid;
	private BigDecimal allocatedamount;
	private int currency;
	private char status;
	private Date creationdate;
	private String createdby;
	private Date modifiedby;
	private String comments;
	private Date modifieddate;
	private BigDecimal relatedfeeid;
	private BigDecimal policyid;
	private String cashiername;
	private String postingstatus;
	private String policycode;
	private double maualtodtlid;
	
	
		
	
	
	public double getMaualtodtlid() {
		return maualtodtlid;
	}
	public void setMaualtodtlid(double maualtodtlid) {
		this.maualtodtlid = maualtodtlid;
	}
	public double getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(double receiptno) {
		this.receiptno = receiptno;
	}
	public String getPolicycode() {
		return policycode;
	}
	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}

	public String getPostingstatus() {
		return postingstatus;
	}
	public void setPostingstatus(String postingstatus) {
		this.postingstatus = postingstatus;
	}
	public double getListid() {
		return listid;
	}
	public void setListid(double listid) {
		this.listid = listid;
	}
	
	public String getPaymentfor() {
		return paymentfor;
	}
	public void setPaymentfor(String paymentfor) {
		this.paymentfor = paymentfor;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getPartyid() {
		return partyid;
	}
	public void setPartyid(BigDecimal partyid) {
		this.partyid = partyid;
	}
	public BigDecimal getAllocatedamount() {
		return allocatedamount;
	}
	public void setAllocatedamount(BigDecimal allocatedamount) {
		this.allocatedamount = allocatedamount;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
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
	public Date getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(Date modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public BigDecimal getRelatedfeeid() {
		return relatedfeeid;
	}
	public void setRelatedfeeid(BigDecimal relatedfeeid) {
		this.relatedfeeid = relatedfeeid;
	}
	public BigDecimal getPolicyid() {
		return policyid;
	}
	public void setPolicyid(BigDecimal policyid) {
		this.policyid = policyid;
	}
	public String getCashiername() {
		return cashiername;
	}
	public void setCashiername(String cashiername) {
		this.cashiername = cashiername;
	}
	
	
	

}
