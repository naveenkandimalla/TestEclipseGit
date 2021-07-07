package com.sais.cashoffice.CashOfficeTest.admin.model;

import java.util.Date;


import com.sais.cashoffice.CashOfficeTest.entities.TModule;

public class PageAccessMaster {
	
	private double pageaccessId;
	private String comments;
	private String createdBy;
	private Date creationDate;
	private String modifiedBy;
	private Date modifiedDatetime;
	private String screenCode;
	private String screenDesc;
	private String url;
    private double moduleid;
    private char status;
    
    
    
    
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public double getPageaccessId() {
		return pageaccessId;
	}
	public void setPageaccessId(double pageaccessId) {
		this.pageaccessId = pageaccessId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDatetime() {
		return modifiedDatetime;
	}
	public void setModifiedDatetime(Date modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}
	public String getScreenCode() {
		return screenCode;
	}
	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	public String getScreenDesc() {
		return screenDesc;
	}
	public void setScreenDesc(String screenDesc) {
		this.screenDesc = screenDesc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getModuleid() {
		return moduleid;
	}
	public void setModuleid(double moduleid) {
		this.moduleid = moduleid;
	}
    
    


}
