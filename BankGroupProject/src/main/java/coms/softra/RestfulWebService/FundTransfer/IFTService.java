package coms.softra.RestfulWebService.FundTransfer;

import java.util.Date;
import java.util.List;

public interface IFTService {
	public Fundtransfer save(Fundtransfer ft);
	public List<Fundtransfer> findBydates(Date start, Date end);
}
