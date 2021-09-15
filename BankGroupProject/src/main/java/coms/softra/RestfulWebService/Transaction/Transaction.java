package coms.softra.RestfulWebService.Transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private int id;
	
	@Column(name = "transaction_description")
	private String description;
	
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_transaction")
	private Date date;
	
	@Column(name = "transaction_type")
	private String type;
	
	@Column(name = "transaction_amount")
	private Double amount;
	
	@Column(name = "account_id")
	private int customerId;

	public Transaction() {}

	public Transaction(String description, Date date, String type, Double amount, int customerId) {
		super();
		this.description = description;
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", date=" + date + ", type=" + type
				+ ", amount=" + amount + ", customerId=" + customerId + "]";
	}	
}
