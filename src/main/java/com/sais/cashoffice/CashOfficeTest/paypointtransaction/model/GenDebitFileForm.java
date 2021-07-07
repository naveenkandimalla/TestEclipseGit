package com.sais.cashoffice.CashOfficeTest.paypointtransaction.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GenDebitFileForm {
    
	@Id
   	private int paypointId;
	private String paypointName;
	private Date period;
	private String templateName;
	private Date strikeDateFrom;
	private Date strikeDateTo;
	
	
	public int getPaypointId() {
		return paypointId;
	}
	public void setPaypointId(int paypointId) {
		this.paypointId = paypointId;
	}
	public String getPaypointName() {
		return paypointName;
	}
	public void setPaypointName(String paypointName) {
		this.paypointName = paypointName;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public Date getStrikeDateFrom() {
		return strikeDateFrom;
	}
	public void setStrikeDateFrom(Date strikeDateFrom) {
		this.strikeDateFrom = strikeDateFrom;
	}
	public Date getStrikeDateTo() {
		return strikeDateTo;
	}
	public void setStrikeDateTo(Date strikeDateTo) {
		this.strikeDateTo = strikeDateTo;
	}

}
