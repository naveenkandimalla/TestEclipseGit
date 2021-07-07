package com.sais.cashoffice.CashOfficeTest.master.model;

import java.util.Date;

import org.springframework.stereotype.Component;


public class AppSetUpForm {
	
	private String applicationCode;	
	private String applicationDesc;
	private int appId;
	private Date startDate;
	private Date endDate;
	private char enabled;
	private String createdBy;
	private String responseMsg;
	private int responseSuccess;
	public AppSetUpForm() {
		
	}
	
	public AppSetUpForm(String applicationCode, String applicationDesc,int appId,Date startDate,Date endDate,String responseMsg) {
		super();
		this.applicationCode = applicationCode;
		this.applicationDesc = applicationDesc;
		this.appId=appId;
		this.startDate=startDate;
		this.endDate=endDate;
		this.responseMsg=responseMsg;
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

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
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

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public int getResponseSuccess() {
		return responseSuccess;
	}

	public void setResponseSuccess(int responseSuccess) {
		this.responseSuccess = responseSuccess;
	}
	
	
	
}
