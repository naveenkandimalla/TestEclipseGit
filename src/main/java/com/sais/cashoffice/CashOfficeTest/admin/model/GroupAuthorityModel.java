package com.sais.cashoffice.CashOfficeTest.admin.model;

import java.util.Date;

public class GroupAuthorityModel {
	
	private String authority;
	private double  groupid;
	private Date  creationdate ;
	private String  createdby ; 
	private Date  modifiedtime;
	private String  modifiedby ;
	private String  comments;
	private char  enabled ;
	
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public double getGroupid() {
		return groupid;
	}
	public void setGroupid(double groupid) {
		this.groupid = groupid;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	
	
	

}
