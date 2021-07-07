package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VW_BANK_ACCOUNTS_INFO")
public class AccountsInfo implements Serializable{
	
	@Id
	@Column(name = "cash_account_id")
	private BigDecimal cashaccountid;
	
	
	@Column(name = "cash_bank")
	private String cashbank;
	
	
	@Column(name = "Bank_Code")
	private String bankcode;
	
	@Column(name = "Bank_Name")
	private String bankname;
	
	@Column(name = "bank_id")
	private BigDecimal bankid;

	@Column(name = "description")
	private String description;

	@Column(name = "cash_account")
	private String cashaccount;
	
	@Column(name = "parent_bank")
	private String parentbank;

	public BigDecimal getCashaccountid() {
		return cashaccountid;
	}

	public void setCashaccountid(BigDecimal cashaccountid) {
		this.cashaccountid = cashaccountid;
	}

	public String getCashbank() {
		return cashbank;
	}

	public void setCashbank(String cashbank) {
		this.cashbank = cashbank;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public BigDecimal getBankid() {
		return bankid;
	}

	public void setBankid(BigDecimal bankid) {
		this.bankid = bankid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCashaccount() {
		return cashaccount;
	}

	public void setCashaccount(String cashaccount) {
		this.cashaccount = cashaccount;
	}

	public String getParentbank() {
		return parentbank;
	}

	public void setParentbank(String parentbank) {
		this.parentbank = parentbank;
	}
	
	
	
}
