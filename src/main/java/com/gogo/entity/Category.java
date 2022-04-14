package com.gogo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gogo.entity.Income;
import com.gogo.entity.Outcome;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int category_id;
	@Column(name="category_name")
	private String category_name;
	
	@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
	private List<Income> incomes = new ArrayList<Income>();
	
	@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
	private List<Outcome> outcomes = new ArrayList<Outcome>();
	
	public Category() {}
	public Category(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	public List<Outcome> getOutcomes() {
		return outcomes;
	}
	
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
}
