package com.ravi.fintrack.model;

import java.sql.Date;

public class SearchCriteria {

	private String categoryId;

	private int trxntype;

	private String description;

	private Date fromDate;

	private Date toDate;

	public SearchCriteria() {
		// TODO Auto-generated constructor stub
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getTrxntype() {
		return trxntype;
	}

	public void setTrxntype(int trxntype) {
		this.trxntype = trxntype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
