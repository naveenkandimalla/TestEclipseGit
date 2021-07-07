package com.sais.cashoffice.CashOfficeTest.paypointmaster.model;

import java.math.BigInteger;

public class DebitFileTemplateModel {
	
	private BigInteger paypointid;
	private String paypointname;
	private String templatecode;
	private String attributedesc;
	private String constant;
	private String period;
	private String strikedate;
	private String fileextension;
	private BigInteger ppattributeid;
	private char pensiononly;
	private char otherpensiononly;
	
	public BigInteger getPaypointid() {
		return paypointid;
	}
	public void setPaypointid(BigInteger paypointid) {
		this.paypointid = paypointid;
	}
	public String getPaypointname() {
		return paypointname;
	}
	public void setPaypointname(String paypointname) {
		this.paypointname = paypointname;
	}
	public String getTemplatecode() {
		return templatecode;
	}
	public void setTemplatecode(String templatecode) {
		this.templatecode = templatecode;
	}
	public String getAttributedesc() {
		return attributedesc;
	}
	public void setAttributedesc(String attributedesc) {
		this.attributedesc = attributedesc;
	}
	public String getConstant() {
		return constant;
	}
	public void setConstant(String constant) {
		this.constant = constant;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getStrikedate() {
		return strikedate;
	}
	public void setStrikedate(String strikedate) {
		this.strikedate = strikedate;
	}
	public String getFileextension() {
		return fileextension;
	}
	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}
	public BigInteger getPpattributeid() {
		return ppattributeid;
	}
	public void setPpattributeid(BigInteger ppattributeid) {
		this.ppattributeid = ppattributeid;
	}
	public char getPensiononly() {
		return pensiononly;
	}
	public void setPensiononly(char pensiononly) {
		this.pensiononly = pensiononly;
	}
	public char getOtherpensiononly() {
		return otherpensiononly;
	}
	public void setOtherpensiononly(char otherpensiononly) {
		this.otherpensiononly = otherpensiononly;
	}
	
	

}
