package coms.softra.RestfulWebService.Payee_;

import java.util.List;

import coms.softra.RestfulWebService.bin.Fundtransfer;

public interface PayeeIDao {
	public Payee save(Payee payee);
	public List<Payee> findByAccountId(int accountId);
}
