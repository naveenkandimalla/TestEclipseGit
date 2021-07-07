package com.sais.cashoffice.CashOfficeTest.transaction.model;


import java.util.Date;

public class PaymentReceiptTpol {
	
	      
    private 	double   	corapp_ActivityId;	
    private 	Date   	    period;
    private 	String   	corPolicyCode;
    private 	String   	corStatus;  
    private	    String      corPayerName;
    private 	double   	corArrears;  
    private	    double      corExpectedAmount; 
    private 	double	    corAllocatedAmount;
    
	public double getCorapp_ActivityId() {
		return corapp_ActivityId;
	}
	public void setCorapp_ActivityId(double corapp_ActivityId) {
		this.corapp_ActivityId = corapp_ActivityId;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public String getCorPolicyCode() {
		return corPolicyCode;
	}
	public void setCorPolicyCode(String corPolicyCode) {
		this.corPolicyCode = corPolicyCode;
	}
	public String getCorStatus() {
		return corStatus;
	}
	public void setCorStatus(String corStatus) {
		this.corStatus = corStatus;
	}
	public String getCorPayerName() {
		return corPayerName;
	}
	public void setCorPayerName(String corPayerName) {
		this.corPayerName = corPayerName;
	}
	public double getCorArrears() {
		return corArrears;
	}
	public void setCorArrears(double corArrears) {
		this.corArrears = corArrears;
	}
	public double getCorExpectedAmount() {
		return corExpectedAmount;
	}
	public void setCorExpectedAmount(double corExpectedAmount) {
		this.corExpectedAmount = corExpectedAmount;
	}
	public double getCorAllocatedAmount() {
		return corAllocatedAmount;
	}
	public void setCorAllocatedAmount(double corAllocatedAmount) {
		this.corAllocatedAmount = corAllocatedAmount;
	}
    
    
    
 
	
    


}
