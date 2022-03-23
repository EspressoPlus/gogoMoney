package com.gogo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

	@Id // primary key field is "id"
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="uname")
	private String uname;
	
	// ############################
	//     User --< Transaction
	// ############################
	// need List<Transaction> bc one User links to (potentially) many Transaction
	@OneToMany(mappedBy="user")
	@JsonIgnore // need this to prevent getting all transactions for each user when returning JSON
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	// add() and remove() needed ...
	// to interact with List<Transaction>
	public void add(Transaction newTransaction) {
		transactions.add(newTransaction);
		newTransaction.setUser(this); // "this" is an object of User class
	}
	public void remove(Transaction remTransaction) {
		transactions.remove(remTransaction);
	}
		
	// constructors
	public User() {}
	
	public User(String uname) { // not sure if this is needed bc users are hardcoded 
		super();
		this.uname = uname;
	}
	
	// getters + setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	// toString() .. wo/ transactions attached
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + "]";
	}
	
}


























