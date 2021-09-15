package coms.softra.RestfulWebService.bin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service 
public class FundService implements FundtransferIService {
	@Autowired
	@Qualifier(value = "ftjparepository")

	private FundtransferIDao ftdao;
	
	public FundService() {
		System.out.println("inside FundService");
	}


	@Override
	public List<Fundtransfer> findByfundTransferId(String sd, String ed) {
		System.out.println("inside findByStartDateBetween of FundService" + sd + ed);
		List <Fundtransfer> objList = ftdao.findByfundTransferId(sd, ed);

		return objList;
	}


	

}
