package com.sais.cashoffice.CashOfficeTest.paypointtransaction.model;

public class GenerateDebitFileResponse {

	private String errorMsg;

	private Long headerId;

	private int status;

	private boolean sFlag;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean issFlag() {
		return sFlag;
	}

	public void setsFlag(boolean sFlag) {
		this.sFlag = sFlag;
	}

}
