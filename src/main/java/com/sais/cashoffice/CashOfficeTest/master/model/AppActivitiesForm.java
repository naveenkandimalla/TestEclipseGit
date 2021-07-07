package com.sais.cashoffice.CashOfficeTest.master.model;

public class AppActivitiesForm {

	private int appActivityId;
	private int appId;
	private char enabled;
	private String appActivityCode;
	private String appActivityDesc;
	private String createdBy;
	private String responseMsg;
	private int responseSuccess;
	
	
	public int getAppActivityId() {
		return appActivityId;
	}
	public void setAppActivityId(int appActivityId) {
		this.appActivityId = appActivityId;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	public String getAppActivityCode() {
		return appActivityCode;
	}
	public void setAppActivityCode(String appActivityCode) {
		this.appActivityCode = appActivityCode;
	}
	public String getAppActivityDesc() {
		return appActivityDesc;
	}
	public void setAppActivityDesc(String appActivityDesc) {
		this.appActivityDesc = appActivityDesc;
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
