package coms.softra.RestfulWebService.Payee_;

import java.util.List;

public interface PayeeIService {
	public Payee save(Payee payee);
	public List<Payee> findByAccountId(int accountId);
}
