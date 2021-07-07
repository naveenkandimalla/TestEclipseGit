package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ManuallAllocationFromRcptProcedure {
	
	private double recepitno;
	private int paypoint;
	private Date period;
	private BigInteger allocatedamount;
	private double grossamount;
	private BigDecimal recepitamount;
	private double unallocatedamount;
	private String postingstatus;
	private String hdrpostingstatus;
	
	public double getRecepitno() {
		return recepitno;
	}
	public void setRecepitno(double recepitno) {
		this.recepitno = recepitno;
	}
	public int getPaypoint() {
		return paypoint;
	}
	public void setPaypoint(int paypoint) {
		this.paypoint = paypoint;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public BigInteger getAllocatedamount() {
		return allocatedamount;
	}
	public void setAllocatedamount(BigInteger allocatedamount) {
		this.allocatedamount = allocatedamount;
	}
	public double getGrossamount() {
		return grossamount;
	}
	public void setGrossamount(double grossamount) {
		this.grossamount = grossamount;
	}
	public BigDecimal getRecepitamount() {
		return recepitamount;
	}
	public void setRecepitamount(BigDecimal recepitamount) {
		this.recepitamount = recepitamount;
	}
	public double getUnallocatedamount() {
		return unallocatedamount;
	}
	public void setUnallocatedamount(double unallocatedamount) {
		this.unallocatedamount = unallocatedamount;
	}
	public String getPostingstatus() {
		return postingstatus;
	}
	public void setPostingstatus(String postingstatus) {
		this.postingstatus = postingstatus;
	}
	public String getHdrpostingstatus() {
		return hdrpostingstatus;
	}
	public void setHdrpostingstatus(String hdrpostingstatus) {
		this.hdrpostingstatus = hdrpostingstatus;
	}
	
	
	

}
