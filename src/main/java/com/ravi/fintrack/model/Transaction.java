package com.ravi.fintrack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAL_FINANCE_TRANSACTION")
public class Transaction extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AMOUNT")
	private Integer amount;
	
	@Column(name="PURCHASED_DATE")
	private Date purchasedDate;
	
	@Column(name="TRNASACTION_TYPE")
	private int trxType;
	
	@OneToOne
	@JoinColumn(name="CATEGEORY_ID")
	private Category category;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getTrxType() {
		return trxType;
	}

	public void setTrxType(int trxType) {
		this.trxType = trxType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
