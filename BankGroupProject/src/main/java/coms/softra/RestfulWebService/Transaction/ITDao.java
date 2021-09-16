package coms.softra.RestfulWebService.Transaction;

import java.util.Date;
import java.util.List;

public interface ITDao {
	public Transaction save(Transaction t);
	public int setAccountBalanceForDeposit(Double amount, int accountId);
	public int setAccountBalanceForWithdrawal(Double amount, int accountId);
	public List<Transaction> findBydates(Date start, Date end);
	public List<Transaction> findByDatesForUser(int id, Date start, Date end);
	public Double checkBalance(int id);
}
