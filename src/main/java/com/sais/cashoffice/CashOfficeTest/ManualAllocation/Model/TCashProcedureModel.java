package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model;

import java.math.BigDecimal;

public class TCashProcedureModel {
	
	private String policycode;
	private BigDecimal feeamount;
	private double receiptno;
	private String loginname;
	private BigDecimal payamount;
	private String purposeid;
	private BigDecimal partyid;
	private String insertedby;
	private String updatedby;
	private BigDecimal paybalance ;
	
	public String getPolicycode() {
		return policycode;
	}
	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}
	public BigDecimal getFeeamount() {
		return feeamount;
	}
	public void setFeeamount(BigDecimal feeamount) {
		this.feeamount = feeamount;
	}
	public double getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(double receiptno) {
		this.receiptno = receiptno;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public BigDecimal getPayamount() {
		return payamount;
	}
	public void setPayamount(BigDecimal payamount) {
		this.payamount = payamount;
	}
	public String getPurposeid() {
		return purposeid;
	}
	public void setPurposeid(String purposeid) {
		this.purposeid = purposeid;
	}
	public BigDecimal getPartyid() {
		return partyid;
	}
	public void setPartyid(BigDecimal partyid) {
		this.partyid = partyid;
	}
	public String getInsertedby() {
		return insertedby;
	}
	public void setInsertedby(String insertedby) {
		this.insertedby = insertedby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public BigDecimal getPaybalance() {
		return paybalance;
	}
	public void setPaybalance(BigDecimal paybalance) {
		this.paybalance = paybalance;
	}
	
	

}
