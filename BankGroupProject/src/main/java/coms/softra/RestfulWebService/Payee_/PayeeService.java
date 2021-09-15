package coms.softra.RestfulWebService.Payee_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PayeeService implements PayeeIService {
	
	@Autowired
	@Qualifier(value="payeerepository")
	private PayeeIDao payeedao;
	
	@Override
	public Payee save(Payee payee) {
		System.out.println("save() payeeservice");
		return payeedao.save(payee);
	}

	@Override
	public List<Payee> findByAccountId(int accountId) {
		System.out.println("findByAccountId() payeeservice");
		return payeedao.findByAccountId(accountId);
	}

}
