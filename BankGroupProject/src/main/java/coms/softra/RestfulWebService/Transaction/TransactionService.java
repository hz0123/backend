package coms.softra.RestfulWebService.Transaction;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import coms.softra.RestfulWebService.Exception.InsufficientBalanceException;

@Service
public class TransactionService implements ITService {

	@Autowired
	@Qualifier(value = "Tjparepository")
	private ITDao tdao;
	
	public TransactionService() {
		System.out.println("Inside TransactionService");
	}
	
	@Override
	public Transaction saveDeposit(Transaction deposit) {
		System.out.println("Inside saveDeposit of TransactionService");
		tdao.setAccountBalanceForDeposit(deposit.getAmount(), deposit.getCustomerId());
		return tdao.save(deposit);
	}

	@Override
	public Transaction saveWithdrawal(Transaction withdraw) {
		System.out.println("Inside saveWithdrawal of TransactionService");
		int id = withdraw.getCustomerId();
		Double amount = withdraw.getAmount();
		
		if (tdao.checkBalance(id)<amount) {
		System.out.println("Insuficient Balance...");
		InsufficientBalanceException ibe = new InsufficientBalanceException("Balance is insufficient to withdraw amount: "+amount);
		throw ibe;
	}
		
		tdao.setAccountBalanceForWithdrawal(amount, id);
		return tdao.save(withdraw);
	}
	
	@Override
	public List<Transaction> findBydates(Date start, Date end) {
		System.out.println("Inside findBydates of TransactionService");
		return tdao.findBydates(start, end);
	}

	@Override
	public List<Transaction> findByDatesForUser(int id, Date start, Date end) {
		System.out.println("Inside findByDatesForUser of TransactionService");
		return tdao.findByDatesForUser(id, start, end);
	}

}
