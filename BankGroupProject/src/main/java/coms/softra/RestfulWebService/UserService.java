package coms.softra.RestfulWebService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service 
public class UserService implements IService {
	@Autowired
	@Qualifier(value = "jparepository")
	private IDao dao;
	
	public UserService() {
		System.out.println("inside UserService");
	}

	@Override
	public User findByuserIdAndLoginPassword(int accountId, String password) { 
		System.out.println("inside verifyUser of UserService");
		Optional<User> user = dao.findByuserIdAndLoginPassword(accountId, password);
		return user.get();
	}

//	@Override
//	public User findByUser_idAndLogin_password(int accountId, String password) { 
//		System.out.println("inside verifyUser of UserService");
//		Optional<User> user = dao.findByUser_idAndLogin_password(accountId, password);
//		return user.get();
//	}
	
	
	@Override
	public User save(User user) {
		System.out.println("inside save of UserService");
		return dao.save(user);
	}

}
