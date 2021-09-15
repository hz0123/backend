package coms.softra.RestfulWebService.Transaction;

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
public class TransactionController {
	
	@Autowired
	private ITService tservice;
	
	public TransactionController() {
		System.out.println("Inside default constructor of TransactionController");
	}
	
	@PostMapping(path="/deposit") 
	public Transaction saveDeposit(@RequestBody Transaction deposit) {
		System.out.println("Inside saveDeposit of TransactionController");
		return tservice.saveDeposit(deposit);
	}
	
	@PostMapping(path="/withdraw") 
	public Transaction saveWithdrawal(@RequestBody Transaction withdraw) {
		System.out.println("Inside saveWithdrawal of TransactionController");
		return tservice.saveWithdrawal(withdraw);
	}
	
	// For Admin
	@GetMapping(path="/transaction/{start}/{end}") 
	public List<Transaction> findBydates(@PathVariable Date start, @PathVariable Date end) {
		System.out.println("Inside findBydates of TransactionController");
		return tservice.findBydates(start, end);
	}
	
	// For User
	@GetMapping(path="/transaction/{id}/{start}/{end}") 
	public List<Transaction> findBydatesForUser(@PathVariable int id, @PathVariable Date start, @PathVariable Date end) {
		System.out.println("Inside findBydatesForUser of TransactionController");
		return tservice.findByDatesForUser(id, start, end);
	}
}
