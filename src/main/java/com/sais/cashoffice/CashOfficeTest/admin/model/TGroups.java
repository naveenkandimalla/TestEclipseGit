package com.sais.cashoffice.CashOfficeTest.admin.model;

import java.sql.Timestamp;
import java.util.Date;

public class TGroups {
     
	  private double id;
	  private String groupname;
	  private String groupdesc;
	  private Timestamp creationdate;
	  private String createdby;
	  private Timestamp modifieddate;
	  private String modifiedby;
	  
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGroupdesc() {
		return groupdesc;
	}
	public void setGroupdesc(String groupdesc) {
		this.groupdesc = groupdesc;
	}
	public Timestamp getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	  
	  
	  
}
