package com.ravi.fintrack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="PERSONAL_FINANCE_CATEGORY")
public class Category extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Column(name="NAME")
	private String name;
	
	@Column(name="COLOR_CODE")
	private String colorCode;
	
	public Category() {
		
	}
	
	public Category(String name, String colorCode) {
		this.name = name;
		this.colorCode = colorCode;
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

}
