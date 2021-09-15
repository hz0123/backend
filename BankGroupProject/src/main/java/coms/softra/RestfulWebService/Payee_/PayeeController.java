package coms.softra.RestfulWebService.Payee_;

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
public class PayeeController {
	
	@Autowired
	private PayeeIService payeeservice;
	
	public PayeeController() {
		System.out.println("Inside default constructor of payeerController");
	}
	
	@PostMapping(path = "/addPayee")
	public Payee addPayee(@RequestBody Payee payee) {
		System.out.println("addPayee() usercontroller");
		System.out.println(payee);
		return payeeservice.save(payee);
	}
	
	
	@GetMapping(path="/getPayee/{accountId}")
	public List<Payee> findByAccountId(@PathVariable int accountId) {
		System.out.println("findByAccountId() controller");
		return payeeservice.findByAccountId(accountId);
	}
}
