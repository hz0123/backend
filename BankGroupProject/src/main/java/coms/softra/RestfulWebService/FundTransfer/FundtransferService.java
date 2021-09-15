package coms.softra.RestfulWebService.FundTransfer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import coms.softra.RestfulWebService.Exception.InsufficientBalanceException;
import coms.softra.RestfulWebService.Exception.UserNotFoundException;
import coms.softra.RestfulWebService.Transaction.ITDao;
import coms.softra.RestfulWebService.Transaction.Transaction;

@Service
public class FundtransferService implements IFTService {

	@Autowired
	@Qualifier(value = "FTjparepository")
	private IFTDao ftdao;
	
	@Autowired
	@Qualifier(value = "Tjparepository")
	private ITDao tdao;
	
	public FundtransferService() {
		System.out.println("Inside FundtransferService");
	}
	
	@Override
	public Fundtransfer save(Fundtransfer ft) {
		System.out.println("Inside save of FundtransferService");
		int payerId = ft.getPayerId();
		int payeeId = ft.getPayeeId();
		Double amount = ft.getAmount();
		Date date = ft.getDate();
		
		if (ftdao.findById(payeeId)==null) { // PayerId is guaranteed to be there since it is the one transferring
			System.out.println("Customer not found...");
			UserNotFoundException unfe = new UserNotFoundException("Customer with account_id: "+payeeId+" not found");
			throw unfe; // There is no compilation error even without throws as it is a runtime (unchecked) exception
		}
		
		if (ftdao.checkBalance(payerId)<amount) {
			System.out.println("Insuficient Balance...");
			InsufficientBalanceException ibe = new InsufficientBalanceException("Balance is insufficient to transfer amount: "+amount);
			throw ibe;
		}
		
		// For Payer
		ftdao.setAccountBalanceForPayer(amount, payerId);
		tdao.save(new Transaction("Transfer to account_id "+payeeId, date, "T", amount, payerId));
		// For Payee
		ftdao.setAccountBalanceForPayee(amount, payeeId);
		tdao.save(new Transaction("Received from account_id "+payerId, date, "R", amount, payeeId));
		
		return ftdao.save(ft);
	}

	@Override
	public List<Fundtransfer> findBydates(Date start, Date end) {
		System.out.println("Inside findBydates of FundtransferService");
		return ftdao.findBydates(start, end);
	}

}
