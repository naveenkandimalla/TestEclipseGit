package com.sais.cashoffice.CashOfficeTest.transaction.model;

import java.util.Date;

public class PaymentReceiptTppForm {

	        
    private 	double     	tppActivity;	
    private     String      tppActivityDesc;
    private	    Date        tppPeriod;
    private     int         tppPaypoint;
    private     double      tppGrossAmount;
    private 	double	    tppReceiptedAmount;
    
	public double getTppActivity() {
		return tppActivity;
	}
	public void setTppActivity(double tppActivity) {
		this.tppActivity = tppActivity;
	}
	public String getTppActivityDesc() {
		return tppActivityDesc;
	}
	public void setTppActivityDesc(String tppActivityDesc) {
		this.tppActivityDesc = tppActivityDesc;
	}
	public Date getTppPeriod() {
		return tppPeriod;
	}
	public void setTppPeriod(Date tppPeriod) {
		this.tppPeriod = tppPeriod;
	}
	public int getTppPaypoint() {
		return tppPaypoint;
	}
	public void setTppPaypoint(int tppPaypoint) {
		this.tppPaypoint = tppPaypoint;
	}
	public double getTppGrossAmount() {
		return tppGrossAmount;
	}
	public void setTppGrossAmount(double tppGrossAmount) {
		this.tppGrossAmount = tppGrossAmount;
	}
	public double getTppReceiptedAmount() {
		return tppReceiptedAmount;
	}
	public void setTppReceiptedAmount(double tppReceiptedAmount) {
		this.tppReceiptedAmount = tppReceiptedAmount;
	}
    
	
   

}
