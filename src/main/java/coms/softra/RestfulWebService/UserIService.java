package coms.softra.RestfulWebService;

import java.util.Date;
import java.util.List;

public interface UserIService {
	public User save(User user);
	public User findByuserIdAndLoginPassword(int userId, String password);

}
