package com.sais.cashoffice.CashOfficeTest.admin.model;

import java.util.Date;



import com.sais.cashoffice.CashOfficeTest.entities.User;

public class GroupMemberDetails {
	

	private double groupMemId;
	private String comments;
	private String createdBy;
	private Date creationDate;
	private char enabled;
	private double groupId;
	private String modifiedBy;
	private Date modifiedDatetime;
    private String username;
    
	public double getGroupMemId() {
		return groupMemId;
	}
	public void setGroupMemId(double groupMemId) {
		this.groupMemId = groupMemId;
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
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	public double getGroupId() {
		return groupId;
	}
	public void setGroupId(double groupId) {
		this.groupId = groupId;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
    

}
