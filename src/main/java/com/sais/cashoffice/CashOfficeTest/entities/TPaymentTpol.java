package com.sais.cashoffice.CashOfficeTest.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_RCPT_ALLOCATION_THITO_POL")
@NamedQuery(name = "TPaymentTpol.findAll" ,query="select t from TPaymentTpol t")
public class TPaymentTpol implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="rcpt_all_thito_pol_id")
	private 	long   	rcptAllThitoPolId;
	
	@Column(name ="rcpt_all_id")
    private 	double   	rcptAllId;
	
	@Column(name ="app_activity_id")
    private 	double     	app_ActivityId;	
	
	@Column(name ="period")
    private 	String   	    period;
	
	@Column(name ="policy_code")
    private 	String   	policyCode;
	
	@Column(name ="policy_status")
    private 	String   	policyStatus;
	
	@Column(name ="payor")
    private	    String      payor;
	
	@Column(name ="arrears_amt")
    private 	double   	arrearsAmt; 
	
	@Column(name ="expected_prem_amt")
    private	    double      expectedAmt; 
	
	@Column(name ="allocated_amount")
    private 	double	    allocatedAmt;
    
    
	public long getRcptAllThitoPolId() {
		return rcptAllThitoPolId;
	}
	public void setRcptAllThitoPolId(long rcptAllThitoPolId) {
		this.rcptAllThitoPolId = rcptAllThitoPolId;
	}
	public double getRcptAllId() {
		return rcptAllId;
	}
	public void setRcptAllId(double rcptAllId) {
		this.rcptAllId = rcptAllId;
	}
	public double getApp_ActivityId() {
		return app_ActivityId;
	}
	public void setApp_ActivityId(double app_ActivityId) {
		this.app_ActivityId = app_ActivityId;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPayor() {
		return payor;
	}
	public void setPayor(String payor) {
		this.payor = payor;
	}
	public double getArrearsAmt() {
		return arrearsAmt;
	}
	public void setArrearsAmt(double arrearsAmt) {
		this.arrearsAmt = arrearsAmt;
	}
	public double getExpectedAmt() {
		return expectedAmt;
	}
	public void setExpectedAmt(double expectedAmt) {
		this.expectedAmt = expectedAmt;
	}
	public double getAllocatedAmt() {
		return allocatedAmt;
	}
	public void setAllocatedAmt(double allocatedAmt) {
		this.allocatedAmt = allocatedAmt;
	}
	public void add(double obj) {
		// TODO Auto-generated method stub
		
	}
	
    	

}
