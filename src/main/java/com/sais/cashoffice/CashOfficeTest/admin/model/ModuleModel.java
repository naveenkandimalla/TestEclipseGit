package com.sais.cashoffice.CashOfficeTest.admin.model;

import java.util.Date;

// this is used for fetch the modulecodes
public class ModuleModel {
	
	private double moduleid;
	private String modulecode;
	private String moduledesc ;
	private Date creationdate;
	private String createdby ;
	private Date modifieddatetime; 
	private String modifiedby ;
	private String comments;
	
	
	public double getModuleid() {
		return moduleid;
	}
	public void setModuleid(double moduleid) {
		this.moduleid = moduleid;
	}
	public String getModulecode() {
		return modulecode;
	}
	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}
	public String getModuledesc() {
		return moduledesc;
	}
	public void setModuledesc(String moduledesc) {
		this.moduledesc = moduledesc;
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
	public Date getModifieddatetime() {
		return modifieddatetime;
	}
	public void setModifieddatetime(Date modifieddatetime) {
		this.modifieddatetime = modifieddatetime;
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
	
	
	
	

}
