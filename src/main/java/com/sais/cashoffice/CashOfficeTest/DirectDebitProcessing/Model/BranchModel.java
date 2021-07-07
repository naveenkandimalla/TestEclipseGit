package com.sais.cashoffice.CashOfficeTest.DirectDebitProcessing.Model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VW_BRANCH")
public class BranchModel implements Serializable {
	
	@Id
	@Column(name = "branch_code")
	private String branchcode;
	
	@Column(name = "branch_name")
	private String branchname;

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
    
	
}
