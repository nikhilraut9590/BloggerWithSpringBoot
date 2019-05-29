package com.nikhilraut.blogger.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class BlogCategory {
	@Id
	@GeneratedValue
	private Integer catId;
	private String categoryName;

	public BlogCategory() {
		// TODO Auto-generated constructor stub
	}

	public BlogCategory(Integer catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
