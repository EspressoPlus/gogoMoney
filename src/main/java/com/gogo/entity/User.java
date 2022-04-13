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

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_first_name")
	private String user_first_name;
	@Column(name="user_last_name")
	private String user_last_name;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="start_balance")
	private double start_balance;
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
	private List<Income> incomes = new ArrayList<Income>();
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
	private List<Outcome> outcomes = new ArrayList<Outcome>();
	
	public User() {}
	public User(String first_name, String last_name, String email, String username, String password,
			double user_balance) {
		this.user_first_name = first_name;
		this.user_last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.start_balance = user_balance;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_first_name() {
		return user_first_name;
	}
	
	public void setUser_first_name(String first_name) {
		this.user_first_name = first_name;
	}
	
	public String getUser_last_name() {
		return user_last_name;
	}
	
	public void setUser_last_name(String last_name) {
		this.user_last_name = last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getStart_balance() {
		return start_balance;
	}
	
	public void setStart_balance(double user_balance) {
		this.start_balance = user_balance;
	}
	
	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + user_first_name + ", last_name=" + user_last_name + ", email="
				+ email + ", username=" + username + ", password=" + password + ", user_balance=" + start_balance + "]";
	}
	
}
