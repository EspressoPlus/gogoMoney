package com.gogo.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Entity
@Table(name="financial")
public class Financial {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="financial_id")
	private int financial_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="income_outcome")
	private String income_outcome;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="recurring")
	private String recurring;
	
	@Column(name="recur_interval")
	private String recur_interval;
	
	@Column(name="recurr_day")
	private int recurr_day;
	
	@Column(name="recurr_count")
	private int recurr_count;
	
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
	
	public Financial() {}

	public int getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(int financial_id) {
		this.financial_id = financial_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIncome_outcome() {
		return income_outcome;
	}

	public void setIncome_outcome(String income_outcome) {
		this.income_outcome = income_outcome;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecurring() {
		return recurring;
	}

	public void setRecurring(String recurring) {
		this.recurring = recurring;
	}

	public String getRecur_interval() {
		return recur_interval;
	}

	public void setRecur_interval(String recur_interval) {
		this.recur_interval = recur_interval;
	}

	public int getRecurr_day() {
		return recurr_day;
	}

	public void setRecurr_day(int recurr_day) {
		this.recurr_day = recurr_day;
	}

	public int getRecurr_count() {
		return recurr_count;
	}

	public void setRecurr_count(int recurr_count) {
		this.recurr_count = recurr_count;
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

	public Category getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}

	public Financial(int financial_id, String name, String income_outcome, double amount, String recurring,
			String recur_interval, int recurr_day, int recurr_count, Date transaction_date, Date entry_date, User user,
			Category category_id) {
		super();
		this.financial_id = financial_id;
		this.name = name;
		this.income_outcome = income_outcome;
		this.amount = amount;
		this.recurring = recurring;
		this.recur_interval = recur_interval;
		this.recurr_day = recurr_day;
		this.recurr_count = recurr_count;
		this.transaction_date = transaction_date;
		this.entry_date = entry_date;
		this.user = user;
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Financial [name=" + name + ", income_outcome=" + income_outcome + ", amount=" + amount + ", recurring="
				+ recurring + ", recur_interval=" + recur_interval + ", recurr_day=" + recurr_day + ", recurr_count="
				+ recurr_count + ", transaction_date=" + transaction_date + ", entry_date=" + entry_date + ", user="
				+ user + ", category_id=" + category_id + "]";
	}
	
}
