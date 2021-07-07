package com.sais.cashoffice.CashOfficeTest.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GenerateNumber")
public class GenerateNumber {

	@Id
	private double newnumber;
	
	
	
	@Column(name = "id")
	private double generatednumber;

	public double getGeneratednumber() {
		return generatednumber;
	}

	public void setGeneratednumber(double generatednumber) {
		this.generatednumber = generatednumber;
	}
	
	
}
