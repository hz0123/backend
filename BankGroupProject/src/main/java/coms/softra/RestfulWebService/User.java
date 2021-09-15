package coms.softra.RestfulWebService;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "users")
//@Entity
@Table(name="user",schema="projectdb")
public class User {

//	@ManyToOne(cascade = CascadeType.PERSIST)
//	private Fundtransfer fundtransfer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "login_password")
	private String loginPassword;
	
	@Column(name = "secret_question")
	private String secretQuestion;
	
	@Column(name = "transaction_password")
	private String transactionPassword;
	
	@Column(name = "lock_status")
	private String lockStatus;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "account_balance")
	private Double accountBalance;
	
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "openDate")
	private Date openDate;

	
	public User() {}
	
	public User(int accountId, int userId, String loginPassword, String secretQuestion, String transactionPassword,
			String lockStatus, @Size(min = 3, message = "Name must have atleast 3 chars") String accountType,
			Double AccountBalance, Date openDate) {
		super();
		this.accountId = accountId;		
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
		this.accountType = accountType;
		this.accountBalance = AccountBalance;
		this.openDate = openDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Override
	public String toString() {
		return "User [accountId=" + accountId + ", userId=" + userId + ", loginPassword=" + loginPassword
				+ ", secretQuestion=" + secretQuestion + ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + ", accountType=" + accountType + ", AccountBalance=" + accountBalance
				+ ", openDate=" + openDate + "]";
	}
		
}
