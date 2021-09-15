package coms.softra.RestfulWebService.bin;

import java.util.Date;
import java.util.List;


public interface FundtransferIService {	
	public List <Fundtransfer> findByfundTransferId(String sd, String ed);

}
