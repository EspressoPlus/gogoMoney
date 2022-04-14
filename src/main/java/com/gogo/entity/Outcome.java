package com.gogo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Outcome")
public class Outcome {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="outcome_id")
	private int outcome_id;
	@Column(name="name")
	private String name;
	@Column(name="amount")
	private double amount;
	@Column(name="reccuring")
	private String reccuring;
	@Column(name="reccur_interval")
	private String reccur_interval;
	@Column(name="reccur_day")
	private int reccur_day;
	@Column(name="reccur_count")
	private int reccur_count;
	@Column(name="transaction_date")
	private Date transaction_date;
	@Column(name="entry_date")
	private Date entry_date;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	@JsonIgnore
	private Category category_id;
	
	public Outcome() {}
	public Outcome(String name, double amount, String reccuring, String reccur_interval, int reccur_day,
			int reccur_count, Date transaction_date, Date entry_date, User user, Category category_id) {
		super();
		this.name = name;
		this.amount = amount;
		this.reccuring = reccuring;
		this.reccur_interval = reccur_interval;
		this.reccur_day = reccur_day;
		this.reccur_count = reccur_count;
		this.transaction_date = transaction_date;
		this.entry_date = entry_date;
		this.user = user;
		this.category_id = category_id;
	}
	
	public int getOutcome_id() {
		return outcome_id;
	}
	
	public void setOutcome_id(int income_id) {
		this.outcome_id = income_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getReccuring() {
		return reccuring;
	}
	
	public void setReccuring(String reccuring) {
		this.reccuring = reccuring;
	}
	
	public String getReccur_interval() {
		return reccur_interval;
	}
	
	public void setReccur_interval(String reccur_interval) {
		this.reccur_interval = reccur_interval;
	}
	
	public int getReccur_day() {
		return reccur_day;
	}
	
	public void setReccur_day(int reccur_day) {
		this.reccur_day = reccur_day;
	}
	
	public int getReccur_count() {
		return reccur_count;
	}
	
	public void setReccur_count(int reccur_count) {
		this.reccur_count = reccur_count;
	}
	
	public Date getTransaction_date() {
		return transaction_date;
	}
	
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	public Date getEntry_date() {
		return entry_date;
	}
	
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Category getCetegory() {
		return category_id;
	}
	
	public void setCategory(Category category) {
		this.category_id = category;
	}
	
	@Override
	public String toString() {
		return "Outcome [outcome_id=" + outcome_id + ", name=" + name + ", amount=" + amount + ", reccuring=" + reccuring
				+ ", reccur_interval=" + reccur_interval + ", reccur_day=" + reccur_day + ", reccur_count="
				+ reccur_count + ", transaction_date=" + transaction_date + ", entry_date=" + entry_date + ", user="
				+ user + ", catagory=" + category_id + "]";
	}

}
