package coms.softra.RestfulWebService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin("*")
public class UserController {
	@Autowired
	private IService service; 
	
	public UserController() {
		System.out.println("Inside UserResource");	
	}
	
	@PostMapping(path = "/login/{id}/{password}")
	public User findByIdOrName(@PathVariable("id") int id, @PathVariable("password")String password) {
		System.out.println("Inside findByIdOrName() of UserResource, id: " + id + " name: " + password);
		return service.findByuserIdAndLoginPassword(id, password);
//		return service.findByUser_idAndLogin_password(id, password);
	}
	
	@PostMapping(path = "/register")
	public User registerUser(@Valid @RequestBody User user) {
		System.out.println("Inside registerUser() of UserResource");
		System.out.println(user.toString());
		return service.save(user);
	}	
	
}


