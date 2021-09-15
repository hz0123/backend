package coms.softra.RestfulWebService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserIDao {
	public User save(User user);
	public Optional<User> findByuserIdAndLoginPassword(int userId, String password);
}
