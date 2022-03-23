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

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Money_Info")
public class Money {

	@Id // map column name to PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	// ############################
	//     Money --< Transaction
	// ############################
	@OneToMany  
	@JsonIgnore // need this to prevent getting all transactions for each movie when returning JSON 
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	@Column(name="somefield")
	private String someField;
		
	// constructors
	public Money() {}
	
	public Money(String someField) {
		super();
		this.someField = someField;
	}

	// getters + setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsomeField() {
		return someField;
	}
	public void setsomeField(String someField) {
		this.someField = someField;
	}
	
	@Override
	public String toString() {
		return "MoneInfo [id=" + id + ", someField=" + someField + "]";
	}	
}
