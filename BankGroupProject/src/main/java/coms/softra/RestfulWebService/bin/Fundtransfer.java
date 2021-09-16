package coms.softra.RestfulWebService.bin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "fundtransferrrr")
//@Entity
@Table(name="fundtransfer",schema="projectdb")
public class Fundtransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fundtransfer_id")
	private int fundTransferId;
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "payee_account_id")
	private int payeeAccountId;
	
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private double amount;
	
	public Fundtransfer() {}
	
	public Fundtransfer(int fundTransferId, int accountId, int payeeAccountId, Date date, double amount) {
		super();
		this.fundTransferId = fundTransferId;
		this.accountId = accountId;
		this.payeeAccountId = payeeAccountId;
		this.date = date;
		this.amount = amount;
	}
	
	public int getFundTransferId() {
		return fundTransferId;
	}
	public void setFundTransferId(int fundTransferId) {
		this.fundTransferId = fundTransferId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPayeeAccountId() {
		return payeeAccountId;
	}
	public void setPayeeAccountId(int payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
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
		return "Fundtransfer [fundTransferId=" + fundTransferId + ", accountId=" + accountId + ", payeeAccountId="
				+ payeeAccountId + ", date=" + date + ", amount=" + amount + "]";
	}
	
}
