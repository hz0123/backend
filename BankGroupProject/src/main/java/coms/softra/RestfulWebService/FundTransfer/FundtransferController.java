package coms.softra.RestfulWebService.FundTransfer;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FundtransferController {
	
	@Autowired
	private IFTService ftservice;
	
	public FundtransferController() {
		System.out.println("Inside default constructor of FundtransferController");
	}
	
	@PostMapping(path="/transfer") 
	public Fundtransfer saveFT(@RequestBody Fundtransfer ft) {
		System.out.println("Inside saveFT of FundtransferController");
		System.out.println(ft);
		return ftservice.save(ft);
	}
	
	// NOTE: DATE MUST BE FROM java.sql.Date;
	@GetMapping(path="/fundtransfer/{start}/{end}") 
	public List<Fundtransfer> findBydates(@PathVariable Date start, @PathVariable Date end) {
		System.out.println("Inside findBydates of FundtransferController");
		return ftservice.findBydates(start, end);
	}
}
