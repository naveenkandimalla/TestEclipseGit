package com.sais.cashoffice.CashOfficeTest.admin.model;

public class UserGroupdetails {
	
//	SELECT usr.USER_ID, usr.USERNAME, usr.FIRST_NAME, usr.LAST_NAME,
//	gm.GROUP_MEM_ID, gm.GROUP_ID, gm.ENABLED, g.GROUP_NAME, g.GROUP_DESC
//		FROM GROUP_MEMBERS gm LEFT JOIN USERS usr on gm.USERNAME = usr.USERNAME,
//			T_GROUPS g WHERE gm.GROUP_ID = g.ID AND gm.USERNAME = :userName
	
	private double userid;
	private String username;
	private String firstname;
	private String lastname;
	private double groupmemid;
	private double groupid;
	private String enable;
	private String groupname;
	private String groupdesc;
	
	public double getUserid() {
		return userid;
	}
	public void setUserid(double userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getGroupmemid() {
		return groupmemid;
	}
	public void setGroupmemid(double groupmemid) {
		this.groupmemid = groupmemid;
	}
	public double getGroupid() {
		return groupid;
	}
	public void setGroupid(double groupid) {
		this.groupid = groupid;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
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
	
	
	


}
