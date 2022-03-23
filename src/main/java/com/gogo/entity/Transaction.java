package com.gogo.entity;

//import java.sql.Date;
import java.sql.Timestamp; // https://www.baeldung.com/hibernate-date-time

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Timestamp txDate; // switched from LocalDateTime
	
	// ############################
	//     Transaction >-- User 
	// ############################
	// cascade: include all except REMOVE so that a checkout record can be removed wo removing *user*
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="user_id")
	private User user;
	
	// ############################
	//     Transaction >-- Money 
	// ############################
	// cascade: include all except REMOVE so that a checkout record can be removed wo removing *movie*
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="moneyinfo_id")
	private Money money;
	
	// constructors
	public Transaction() {}
	
	public Transaction(User user, Money movie, Timestamp dateOut /*, Timestamp dateIn*/) {
		super();
		this.user = user;
		this.money = money;
		this.txDate = txDate;
	}

	// getters + setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTDate() {
		return txDate;
	}
	public void setTxDate(Timestamp dateOut) {
		this.txDate = txDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Money getMoney() {
		return money;
	}
	public void setMoney(Money money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", txDate=" + txDate + "]";
	}
	
	
}





