package coms.softra.RestfulWebService.FundTransferV1;

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

//	@Column(name = "account_id")
//	private int payerId;
	
//	@Column(name = "payee_account_id")
//	private int payeeId;
	
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_transfer")
	private Date date;
	
	@Column(name = "transfer_amount")
	private double amount;
	
	//In replacement of private int payerId;
	@ManyToOne
	private User payer;
	
	//In replacement of private int payeeId;
	@ManyToOne
	private User payee;
	
	// Will not have @Column annotation as respective id will be stored by above two attribute
	private int payerId;
	private int payeeId;
	
	public Fundtransfer() {}

//	public Fundtransfer(int id, int payerId, int payeeId, Date date, double amount) {
//		super();
//		this.id = id;
//		this.payerId = payerId;
//		this.payeeId = payeeId;
//		this.date = date;
//		this.amount = amount;
//	}

	public Fundtransfer(int id, int payerId, int payeeId, Date date, double amount) {
		super();
		System.out.println("Inside constructor of Fundtransfer");
//		this.id = id; //This is not needed since id is auto-incremented
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

//	public int getPayerId() {
//		return payerId;
//	}
//
//	public void setPayerId(int payerId) {
//		this.payerId = payerId;
//	}

//	public int getPayeeId() {
//		return payeeId;
//	}
//
//	public void setPayeeId(int payeeId) {
//		this.payeeId = payeeId;
//	}

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
	
	public User getPayer() {
		return payer;
	}

	public void setPayer(User payer) {
		this.payer = payer;
	}

	public User getPayee() {
		return payee;
	}

	public void setPayee(User payee) {
		this.payee = payee;
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

	@Override
	public String toString() {
		return "Fundtransfer [id=" + id + ", date=" + date + ", amount=" + amount + ", payer=" + payer + ", payee="
				+ payee + "]";
	}

//	@Override
//	public String toString() {
//		return "Fundtransfer [id=" + id + ", payerId=" + payerId + ", payeeId=" + payeeId + ", date=" + date
//				+ ", amount=" + amount + "]";
//	}
}
