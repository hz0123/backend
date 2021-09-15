package coms.softra.RestfulWebService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coms.softra.RestfulWebService.Payee_.Payee;
import coms.softra.RestfulWebService.Payee_.PayeeIService;
import coms.softra.RestfulWebService.bin.FundService;
import coms.softra.RestfulWebService.bin.Fundtransfer;

@RestController 
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserIService uservice; 
	
	@Autowired
	private FundService ftservice; 
	
	@Autowired
	private PayeeIService payeeservice;

	public UserController() {
		System.out.println("Inside UserResource");	
	}
	
	@PostMapping(path = "/login/{id}/{password}")
	public User findByAccountIdAndName(@PathVariable("id") int id, @PathVariable("password")String password) {
		System.out.println("Inside findByIdOrName() of UserResource, id: " + id + " name: " + password);
		return uservice.findByAccountIdAndLoginPassword(id, password);
	}
	
	@PostMapping(path = "/register")
	public User registerUser(@Valid @RequestBody User user) {
		System.out.println("Inside registerUser() of UserController");
		System.out.println(user);
		return uservice.save(user);
	}	
	
	
	
//	@GetMapping(path = "/queryReport/{inStartDate}/{inEndDate}")
//	public List <Fundtransfer> findByStartDateBetween(@PathVariable("inStartDate") String strStartDate, @PathVariable("inEndDate")String strEndDate) {
////	public List <Object> findByStartDateBetween(@PathVariable("inStartDate") String strStartDate, @PathVariable("inEndDate")String strEndDate) {
//	
//		System.out.println("Inside findByStartDateBetween() of UserResource, startDate: "+ strStartDate + " : endDate: " + strEndDate );
////		List<Object> res = service.findByAccountId(strStartDate, strEndDate); 	
////		for (Object obj: res) {
////			System.out.println(obj);
////		}
////		return res;
//		return service.findByAccountId(strStartDate, strEndDate);
//	}	

	@GetMapping(path = "/queryReport/{inStartDate}/{inEndDate}")
	public List <Fundtransfer> findByfundTransferId(@PathVariable("inStartDate") String strStartDate, @PathVariable("inEndDate")String strEndDate) {
		System.out.println("Inside findByStartDateBetween() of UserResource, startDate: "+ strStartDate + ": " + strEndDate );
		return ftservice.findByfundTransferId(strStartDate, strEndDate);
	}
	
	
//	@GetMapping(path = "/queryReport/{inStartDate}")
//	public List <Fundtransfer> findByfundTransferId(@PathVariable("inStartDate") String strStartDate) {
//	
//		System.out.println("Inside findByfundTransferId() of UserResource, startDate: "+ strStartDate );
//
//		return ftservice.findByfundTransferId(strStartDate);
//	}	
	
}


