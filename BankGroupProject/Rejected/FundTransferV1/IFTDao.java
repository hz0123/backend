package coms.softra.RestfulWebService.FundTransferV1;

import java.util.Date;
import java.util.List;

public interface IFTDao {
	public Fundtransfer save(Fundtransfer ft);
	public List<Fundtransfer> findBydates(Date start, Date end);
	
	/* Additional (if have time):
	 * import java.util.Optional;
	 * public Optional<Fundtransfer> findByFundtransferId(int id);
	 */
}
