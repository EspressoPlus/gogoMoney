package com.gogo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="password")
	private String password;
	
	@Column(name="start_balance")
	private double start_balance;
	
	@Column(name="amount_to_save") 
	private double amount_to_save;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER, orphanRemoval=true) 
	private List<Financial> financials = new ArrayList<Financial>();
	
	public User() {}
	public User(String first_name, String last_name, String email, String password,
			double start_balance, double amount_to_save) {
		this.user_first_name = first_name;
		this.user_last_name = last_name;
		this.email = email;
		this.password = password;
		this.start_balance = start_balance;
		this.amount_to_save = amount_to_save;
	}
	
	public int getUser_id_bypass_db(){
		return user_id;
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

	public List<Financial> getFinancials() {
		return financials;
	}
	
	public Financial getFinancial(int id)
	{
		Financial fin = new Financial();
		for(int i = 0; i < financials.size(); i++)
		{
			if(financials.get(i).getFinancial_id() == id)
			{
				fin = financials.get(i);
			}
		}
		
		return fin;
	}
	
	public double getAmount_to_save() {
		return amount_to_save;
	}
	
	public void setAmount_to_save(double amount_to_save) {
		this.amount_to_save = amount_to_save;
	}
	
	public void setFinancials(List<Financial> financials) {
		this.financials = financials;
	}
	
	public void add(Financial financial)
	{
		financials.add(financial);
		financial.setUser(this);
	}
	
	public void remove(Financial financial)
	{
		financials.remove(financial);
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", email=" + email + ", password=" + password + ", start_balance=" + start_balance
				+ ", amount_to_save=" + amount_to_save + "]";
	}
	

	
}
