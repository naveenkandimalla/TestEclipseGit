package com.sais.cashoffice.CashOfficeTest.paypointtransaction.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvDate;

@Entity
public class GenerateDebitFile {
	
	
	@Id
	private Double id;
	
	private BigDecimal paypointid;
	
	private BigDecimal partyid;
	
	private String partyidetificationcode;
	
	private String employeecode;
	
	private String partyname;
	
	private String policycode;
	
	private String productidcode;
	
	
	private String strikedate;
	
	private String bankcode;
	
	private String branchcode;
	
	private String bankaccountcode;
	
	private String bankaccountholder;
	
	private String bankaccounttype;
	
	private BigDecimal pensionprem;
	
	private BigDecimal otherprem;
	
	private BigDecimal total_life_OTHER_THEBES;
	
	private Date paypointduedate;
	
	private Date collectionperiod;
	
	

	public BigDecimal getPaypointid() {
		return paypointid;
	}

	public void setPaypointid(BigDecimal paypointid) {
		this.paypointid = paypointid;
	}

	public BigDecimal getPartyid() {
		return partyid;
	}

	public void setPartyid(BigDecimal partyid) {
		this.partyid = partyid;
	}

	public String getPartyidetificationcode() {
		return partyidetificationcode;
	}

	public void setPartyidetificationcode(String partyidetificationcode) {
		this.partyidetificationcode = partyidetificationcode;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public String getPolicycode() {
		return policycode;
	}

	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}

	public String getProductidcode() {
		return productidcode;
	}

	public void setProductidcode(String productidcode) {
		this.productidcode = productidcode;
	}

	public String getStrikedate() {
		return strikedate;
	}

	public void setStrikedate(String strikedate) {
		this.strikedate = strikedate;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getBankaccountcode() {
		return bankaccountcode;
	}

	public void setBankaccountcode(String bankaccountcode) {
		this.bankaccountcode = bankaccountcode;
	}

	public String getBankaccountholder() {
		return bankaccountholder;
	}

	public void setBankaccountholder(String bankaccountholder) {
		this.bankaccountholder = bankaccountholder;
	}

	public String getBankaccounttype() {
		return bankaccounttype;
	}

	public void setBankaccounttype(String bankaccounttype) {
		this.bankaccounttype = bankaccounttype;
	}

	public BigDecimal getPensionprem() {
		return pensionprem;
	}

	public void setPensionprem(BigDecimal pensionprem) {
		this.pensionprem = pensionprem;
	}

	public BigDecimal getOtherprem() {
		return otherprem;
	}

	public void setOtherprem(BigDecimal otherprem) {
		this.otherprem = otherprem;
	}

	public BigDecimal getTotal_life_OTHER_THEBES() {
		return total_life_OTHER_THEBES;
	}

	public void setTotal_life_OTHER_THEBES(BigDecimal total_life_OTHER_THEBES) {
		this.total_life_OTHER_THEBES = total_life_OTHER_THEBES;
	}

	public Date getPaypointduedate() {
		return paypointduedate;
	}

	public void setPaypointduedate(Date paypointduedate) {
		this.paypointduedate = paypointduedate;
	}

	public Date getCollectionperiod() {
		return collectionperiod;
	}

	public void setCollectionperiod(Date collectionperiod) {
		this.collectionperiod = collectionperiod;
	}
	
	
	

}
