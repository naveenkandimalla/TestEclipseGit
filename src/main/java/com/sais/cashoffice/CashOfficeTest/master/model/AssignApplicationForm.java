package com.sais.cashoffice.CashOfficeTest.master.model;

import java.util.Date;

public class AssignApplicationForm {
	
	private long cashOfficeAppId;
	private long appId;
	private String cashOfficeCode;
	private String applicationCode;
	private String applicationDesc;
	private Date startDate;
	private Date endDate;
	
	
	
	public long getCashOfficeAppId() {
		return cashOfficeAppId;
	}
	public void setCashOfficeAppId(long cashOfficeAppId) {
		this.cashOfficeAppId = cashOfficeAppId;
	}
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getCashOfficeCode() {
		return cashOfficeCode;
	}
	public void setCashOfficeCode(String cashOfficeCode) {
		this.cashOfficeCode = cashOfficeCode;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public String getApplicationDesc() {
		return applicationDesc;
	}
	public void setApplicationDesc(String applicationDesc) {
		this.applicationDesc = applicationDesc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
