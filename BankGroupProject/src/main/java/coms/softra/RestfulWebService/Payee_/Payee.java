package coms.softra.RestfulWebService.Payee_;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="payee")
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "add_payee_id")
	private int addPayeeId; 
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name="payee_account_id")
	private int payeeAccountId;
	
	@Column(name="nickname")
	private String nickname;

	public Payee() {
		super();
	}

	public Payee(int addPayeeId, int accountId, int payeeAccountId, String nickname) {
		super();
		this.addPayeeId = addPayeeId;
		this.accountId = accountId;
		this.payeeAccountId = payeeAccountId;
		this.nickname = nickname;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Payee [accountId=" + accountId + ", payeeAccountId=" + payeeAccountId + ", nickname=" + nickname + "]";
	}
	
	
}
