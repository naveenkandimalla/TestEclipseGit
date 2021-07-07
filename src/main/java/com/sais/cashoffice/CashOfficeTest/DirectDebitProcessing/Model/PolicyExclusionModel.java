package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyExclusionModel {
	
	public double peid;
	public double  bankstmtid;
	public Date period;
	public String policycode;
	public String payour;
	public String policystatus;
	public BigDecimal exceptedamount;
	public Date creationdate;
	public String createdby;
	public BigDecimal allocatedpremium;
	
	
	public double getPeid() {
		return peid;
	}
	public void setPeid(double peid) {
		this.peid = peid;
	}
	public double getBankstmtid() {
		return bankstmtid;
	}
	public void setBankstmtid(double bankstmtid) {
		this.bankstmtid = bankstmtid;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public String getPolicycode() {
		return policycode;
	}
	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}
	public String getPayour() {
		return payour;
	}
	public void setPayour(String payour) {
		this.payour = payour;
	}
	public String getPolicystatus() {
		return policystatus;
	}
	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}
	public BigDecimal getExceptedamount() {
		return exceptedamount;
	}
	public void setExceptedamount(BigDecimal exceptedamount) {
		this.exceptedamount = exceptedamount;
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
	public BigDecimal getAllocatedpremium() {
		return allocatedpremium;
	}
	public void setAllocatedpremium(BigDecimal allocatedpremium) {
		this.allocatedpremium = allocatedpremium;
	}
	
	
	

}
