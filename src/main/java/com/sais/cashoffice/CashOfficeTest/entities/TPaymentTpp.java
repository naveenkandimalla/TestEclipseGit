package com.sais.cashoffice.CashOfficeTest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="T_RCPT_ALLOCATION_THITO_PP")
@NamedQuery(name = "TPaymentTpp.findAll" ,query="select t from TPaymentTpp t")
public class TPaymentTpp {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="rcpt_all_thito_pp_id")
	private 	long   	rcptAllThitoPpId; 
	
	@Column(name ="rcpt_all_id")
    private 	double   	rcptAllId;
	
	@Column(name ="app_activity_id")
    private 	double     	app_ActivityId;	
	
	@Column(name ="paypoint_id")
    private	    int         payPointId;
	
	@Column(name ="gross_amount")
    private     double      grossAmt;
	
	@Column(name ="allocated_amount")
    private 	double	    allocatedAmt;
	
	@Column(name ="period")
	private String period;
	
    
	public long getRcptAllThitoPpId() {
		return rcptAllThitoPpId;
	}
	public void setRcptAllThitoPpId(long rcptAllThitoPpId) {
		this.rcptAllThitoPpId = rcptAllThitoPpId;	
		
	}
	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public int getPayPointId() {
		return payPointId;
	}
	public void setPayPointId(int payPointId) {
		this.payPointId = payPointId;
	}
	public double getGrossAmt() {
		return grossAmt;
	}
	public void setGrossAmt(double grossAmt) {
		this.grossAmt = grossAmt;
	}
	public double getAllocatedAmt() {
		return allocatedAmt;
	}
	public void setAllocatedAmt(double allocatedAmt) {
		this.allocatedAmt = allocatedAmt;
	}
	public void add(double d) {
		// TODO Auto-generated method stub
		
	}
    
}
