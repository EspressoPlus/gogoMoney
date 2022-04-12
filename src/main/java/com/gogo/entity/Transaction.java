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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id // primary key field is "id"
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int transaction_id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user_id;
	
	@OneToMany(mappedBy="income", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Income> income = new ArrayList<Income>();
	
	@OneToMany(mappedBy="outcome", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Outcome> outcome = new ArrayList<Outcome>();

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	public void add(Income incomes)
	{
		income.add(incomes);
		incomes.setTransactions(this);
	}
	
	public void remove(Income incomes)
	{
		income.remove(incomes);
	}
	
	public void add(Outcome outcomes)
	{
		outcome.add(outcomes);
		outcomes.setTransactions(this);
	}
	
	public void remove(Outcome outcomes)
	{
		outcome.remove(outcomes);
	}

	public List<Income> getIncome_id() {
		return income;
	}

	public void setIncome_id(List<Income> income_id) {
		this.income = income_id;
	}

	public List<Outcome> getOutcome_id() {
		return outcome;
	}

	public void setOutcome_id(List<Outcome> outcome_id) {
		this.outcome = outcome_id;
	}

	public Transaction(int transaction_id, User user_id, List<Income> income_id, List<Outcome> outcome_id) {
		super();
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.income = income_id;
		this.outcome = outcome_id;
	}

	@Override
	public String toString() {
		return "Transaction [user_id=" + user_id + ", income_id=" + income + ", outcome_id=" + outcome + "]";
	}
}
