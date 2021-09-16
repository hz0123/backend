package coms.softra.RestfulWebService.FundTransfer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import coms.softra.RestfulWebService.User;

@Entity(name="fundtransfer")
public class Fundtransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fundtransfer_id")
	private int id;

	@Column(name = "account_id")
	private int payerId;
	
	@Column(name = "payee_account_id")
	private int payeeId;
	
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_transfer")
	private Date date;
	
	@Column(name = "transfer_amount")
	private double amount;
	
	public Fundtransfer() {}

	public Fundtransfer(int id, int payerId, int payeeId, Date date, double amount) {
		super();
		this.id = id;
		this.payerId = payerId;
		this.payeeId = payeeId;
		this.date = date;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Fundtransfer [id=" + id + ", payerId=" + payerId + ", payeeId=" + payeeId + ", date=" + date
				+ ", amount=" + amount + "]";
	}

}
