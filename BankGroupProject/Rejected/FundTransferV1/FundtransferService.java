package coms.softra.RestfulWebService.FundTransferV1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FundtransferService implements IFTService {

	@Autowired
	@Qualifier(value = "FTjparepository")
	private IFTDao ftdao;
	
	public FundtransferService() {
		System.out.println("Inside FundtransferService");
	}
	
	@Override
	public Fundtransfer save(Fundtransfer ft) {
		System.out.println("Inside save of FundtransferService");
		return ftdao.save(ft);
	}

	@Override
	public List<Fundtransfer> findBydates(Date start, Date end) {
		System.out.println("Inside findBydates of FundtransferService");
		return ftdao.findBydates(start, end);
	}

}
