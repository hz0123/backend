package coms.softra.RestfulWebService.Transaction;

import java.sql.Date;
import java.util.List;

public interface ITService {
	public Transaction saveDeposit(Transaction deposit);
	public Transaction saveWithdrawal(Transaction withdraw);
	public List<Transaction> findBydates(Date start, Date end);
	public List<Transaction> findByDatesForUser(int id, Date start, Date end);
}
