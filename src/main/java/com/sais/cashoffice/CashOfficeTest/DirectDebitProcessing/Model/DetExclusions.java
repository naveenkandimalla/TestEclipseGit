package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model;

import java.math.BigDecimal;
import java.util.Date;

public class DetExclusions {
	
	private Date pERIOD;
	private String pOLICY_CODE;
	private int pOLICY_STATUS_ID;
	private String pAYOR;
	private BigDecimal eXPECTED_PREMIUM;
	private BigDecimal aLLOCATED_AMOUNT;
	private double policyexculsionid;
	
	public Date getpERIOD() {
		return pERIOD;
	}
	public void setpERIOD(Date pERIOD) {
		this.pERIOD = pERIOD;
	}
	public String getpOLICY_CODE() {
		return pOLICY_CODE;
	}
	public void setpOLICY_CODE(String pOLICY_CODE) {
		this.pOLICY_CODE = pOLICY_CODE;
	}
	public int getpOLICY_STATUS_ID() {
		return pOLICY_STATUS_ID;
	}
	public void setpOLICY_STATUS_ID(int pOLICY_STATUS_ID) {
		this.pOLICY_STATUS_ID = pOLICY_STATUS_ID;
	}
	public String getpAYOR() {
		return pAYOR;
	}
	public void setpAYOR(String pAYOR) {
		this.pAYOR = pAYOR;
	}
	public BigDecimal geteXPECTED_PREMIUM() {
		return eXPECTED_PREMIUM;
	}
	public void seteXPECTED_PREMIUM(BigDecimal eXPECTED_PREMIUM) {
		this.eXPECTED_PREMIUM = eXPECTED_PREMIUM;
	}
	public BigDecimal getaLLOCATED_AMOUNT() {
		return aLLOCATED_AMOUNT;
	}
	public void setaLLOCATED_AMOUNT(BigDecimal aLLOCATED_AMOUNT) {
		this.aLLOCATED_AMOUNT = aLLOCATED_AMOUNT;
	}
	public double getPolicyexculsionid() {
		return policyexculsionid;
	}
	public void setPolicyexculsionid(double policyexculsionid) {
		this.policyexculsionid = policyexculsionid;
	}
	
	

}
