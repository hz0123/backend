package coms.softra.RestfulWebService.FundTransfer;

import java.util.Date;
import java.util.List;

import coms.softra.RestfulWebService.User;

public interface IFTDao {
	public Fundtransfer save(Fundtransfer ft);
	public List<Fundtransfer> findBydates(Date start, Date end);
	public int setAccountBalanceForPayer(Double amount, int accountId);
	public int setAccountBalanceForPayee(Double amount, int accountId);
	public Integer findById(int id);
	public Double checkBalance(int id);
}
