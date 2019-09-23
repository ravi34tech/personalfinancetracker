package com.ravi.fintrack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ravi.fintrack.bean.FinanceTrackBean;


@Entity
@Table(name="PERSONAL_FINANCE_CATEGORY")
public class Category extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(name="NAME")
	private String name;
	
	@Column(name="COLOR_CODE")
	private String colorCode;
	
	@Column(name="IS_DELETED", columnDefinition="boolean default false")
	private boolean deleted;
	

	public Category() {
		
	}
	
	public Category(String name, String colorCode) {
		this.name = name;
		this.colorCode = colorCode;
	}
	
	public Category(FinanceTrackBean bean) {
		this.name = bean.getCategoryName();
		this.colorCode = bean.getCategoryColor();
		this.id = bean.getCategoryId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
