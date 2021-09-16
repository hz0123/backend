package coms.softra.RestfulWebService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service 
public class UserService implements UserIService {
	@Autowired
	@Qualifier(value = "jparepository")

	private UserIDao udao;
	
	public UserService() {
		System.out.println("inside UserService");
	}

	@Override
	public User findByAccountIdAndLoginPassword(int userId, String password) { 
		System.out.println("inside verifyUser of UserService" + userId + password);
		Optional<User> user = udao.findByAccountIdAndLoginPassword(userId, password);
		return user.get();
	}
	
	@Override
	public User save(User user) {
		System.out.println("inside save of UserService");
		return udao.save(user);
	}

}
