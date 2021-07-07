package com.sais.cashoffice.CashOfficeTest.ElectronicAllocation.Model;

import java.math.BigDecimal;
import java.util.Date;

public class EsoAllocationModel {
	
	private double crhdrid;
	private BigDecimal paypointid;
	private Date period;
	private double receiptno;
	private double receiptamount;
	private char flag;

	
	public double getCrhdrid() {
		return crhdrid;
	}
	public void setCrhdrid(double crhdrid) {
		this.crhdrid = crhdrid;
	}
	public BigDecimal getPaypointid() {
		return paypointid;
	}
	public void setPaypointid(BigDecimal paypointid) {
		this.paypointid = paypointid;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public double getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(double receiptno) {
		this.receiptno = receiptno;
	}
	public double getReceiptamount() {
		return receiptamount;
	}
	public void setReceiptamount(double receiptamount) {
		this.receiptamount = receiptamount;
	}
	public char getFlag() {
		return flag;
	}
	public void setFlag(char flag) {
		this.flag = flag;
	}
	
	

}
