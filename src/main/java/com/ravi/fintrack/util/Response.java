package com.ravi.fintrack.util;

import java.util.List;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.Transaction;

public class Response {
	
	private int statusCode;

	private String status;
	
	private String statusMessage;
	
	private List<Category> categoryList;
	
	private List<Transaction> trxnList;
	
	private Transaction transaction;
	
	private Category category;
	
	private FinanceTrackBean finTrxnBean;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Transaction> getTrxnList() {
		return trxnList;
	}

	public void setTrxnList(List<Transaction> trxnList) {
		this.trxnList = trxnList;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public FinanceTrackBean getFinTrxnBean() {
		return finTrxnBean;
	}

	public void setFinTrxnBean(FinanceTrackBean finTrxnBean) {
		this.finTrxnBean = finTrxnBean;
	}
	

}
