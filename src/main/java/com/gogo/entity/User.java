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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

	@Id // primary key field is "id"
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_first_name")
	private String first_name;
	
	@Column(name="user_last_name")
	private String last_name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="start_balance")
	private String start_balance;
	
	@Column(name="amount_to_save")
	private String save;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> transaction = new ArrayList<Transaction>();

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStart_balance() {
		return start_balance;
	}

	public void setStart_balance(String start_balance) {
		this.start_balance = start_balance;
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public User(int user_id, String first_name, String last_name, String password, String email, String start_balance,
			String save, List<Transaction> transaction) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.start_balance = start_balance;
		this.save = save;
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", password=" + password + ", email="
				+ email + ", start_balance=" + start_balance + ", save=" + save + ", transaction=" + transaction + "]";
	}
}