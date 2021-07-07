package com.sais.cashoffice.CashOfficeTest.ManualAllocation.Model;

import java.math.BigDecimal;
import java.util.Date;

public class AllocationPostingProcedureModel {
	
    
    private BigDecimal policyid;
	private Date duetime;
	private double feeid;
	private double listid;
	
	public BigDecimal getPolicyid() {
		return policyid;
	}
	public void setPolicyid(BigDecimal policyid) {
		this.policyid = policyid;
	}
	public Date getDuetime() {
		return duetime;
	}
	public void setDuetime(Date duetime) {
		this.duetime = duetime;
	}
	public double getFeeid() {
		return feeid;
	}
	public void setFeeid(double feeid) {
		this.feeid = feeid;
	}
	public double getListid() {
		return listid;
	}
	public void setListid(double listid) {
		this.listid = listid;
	}
	
	
	

}
