package com.sais.cashoffice.CashOfficeTest.paypointReports.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="vw_bank_dde_allocations")
public class StatementAllocation {

	@Id
	private Long id ;
	
	private String bank_stmt_id,
		bank_stmt_number,
		bank_name,
		account_id,
		account_number,
		account_desc,
		paypoint_id,
		paypoint_name,
		period,
		transaction_type,
		strike_date,
		allocated_amount,
		policy_code,
		premium,
		amount,
		product_abbr,
		policy_status,
		party_name ;

	@Override
	public String toString() {
		return "StatementAllocation [id=" + id + ", bank_stmt_id=" + bank_stmt_id + ", bank_stmt_number="
				+ bank_stmt_number + ", bank_name=" + bank_name + ", account_id=" + account_id + ", account_number="
				+ account_number + ", account_desc=" + account_desc + ", paypoint_id=" + paypoint_id
				+ ", paypoint_name=" + paypoint_name + ", period=" + period + ", transaction_type=" + transaction_type
				+ ", strike_date=" + strike_date + ", allocated_amount=" + allocated_amount + ", policy_code="
				+ policy_code + ", premium=" + premium + ", amount=" + amount + ", product_abbr=" + product_abbr
				+ ", policy_status=" + policy_status + ", party_name=" + party_name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBank_stmt_id() {
		return bank_stmt_id;
	}

	public void setBank_stmt_id(String bank_stmt_id) {
		this.bank_stmt_id = bank_stmt_id;
	}

	public String getBank_stmt_number() {
		return bank_stmt_number;
	}

	public void setBank_stmt_number(String bank_stmt_number) {
		this.bank_stmt_number = bank_stmt_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_desc() {
		return account_desc;
	}

	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}

	public String getPaypoint_id() {
		return paypoint_id;
	}

	public void setPaypoint_id(String paypoint_id) {
		this.paypoint_id = paypoint_id;
	}

	public String getPaypoint_name() {
		return paypoint_name;
	}

	public void setPaypoint_name(String paypoint_name) {
		this.paypoint_name = paypoint_name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getStrike_date() {
		return strike_date;
	}

	public void setStrike_date(String strike_date) {
		this.strike_date = strike_date;
	}

	public String getAllocated_amount() {
		return allocated_amount;
	}

	public void setAllocated_amount(String allocated_amount) {
		this.allocated_amount = allocated_amount;
	}

	public String getPolicy_code() {
		return policy_code;
	}

	public void setPolicy_code(String policy_code) {
		this.policy_code = policy_code;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getProduct_abbr() {
		return product_abbr;
	}

	public void setProduct_abbr(String product_abbr) {
		this.product_abbr = product_abbr;
	}

	public String getPolicy_status() {
		return policy_status;
	}

	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
}
