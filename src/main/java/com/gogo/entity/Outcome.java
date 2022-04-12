package src.main.java.com.gogo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Id // map column name to PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="outcome_id") 
	private int outcome_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private int amount;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	@JsonIgnore // need this to prevent getting all transactions for each movie when returning JSON 
	private Category category_id;
	
	@Column(name="recurring")
	private String recurring;
	
	@Column(name="recur_interval")
	private String recur_interval;
	
	@Column(name="recurr_day")
	private String recurr_day;
	
	@Column(name="recurr_count")
	private String recurr_count;
	
	@Column(name="transaction_date")
	private String transaction_date;
	
	@Column(name="entry_date")
	private String entry_date;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="transaction_id")
	@JsonIgnore // need this to prevent getting all transactions for each movie when returning JSON 
	private Transaction transactions;

	public int getOutcome_id() {
		return outcome_id;
	}

	public void setOutcome_id(int outcome_id) {
		this.outcome_id = outcome_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Category getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
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

	public String getRecurr_day() {
		return recurr_day;
	}

	public void setRecurr_day(String recurr_day) {
		this.recurr_day = recurr_day;
	}

	public String getRecurr_count() {
		return recurr_count;
	}

	public void setRecurr_count(String recurr_count) {
		this.recurr_count = recurr_count;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public Transaction getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction transactions) {
		this.transactions = transactions;
	}

	public Outcome(int outcome_id, String name, int amount, Category category_id, String recurring,
			String recur_interval, String recurr_day, String recurr_count, String transaction_date, String entry_date,
			Transaction transactions) {
		super();
		this.outcome_id = outcome_id;
		this.name = name;
		this.amount = amount;
		this.category_id = category_id;
		this.recurring = recurring;
		this.recur_interval = recur_interval;
		this.recurr_day = recurr_day;
		this.recurr_count = recurr_count;
		this.transaction_date = transaction_date;
		this.entry_date = entry_date;
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Outcome [name=" + name + ", amount=" + amount + ", category_id=" + category_id + ", recurring="
				+ recurring + ", recur_interval=" + recur_interval + ", recurr_day=" + recurr_day + ", recurr_count="
				+ recurr_count + ", transaction_date=" + transaction_date + ", entry_date=" + entry_date
				+ ", transactions=" + transactions + "]";
	}

}
