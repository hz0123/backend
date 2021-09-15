package coms.softra.RestfulWebService;

import java.util.Optional;

public interface IDao {
	public User save(User user);
	public Optional<User> findByuserIdAndLoginPassword(int userId, String password);
//	public Optional<User> findByUser_idAndLogin_password(int userId, String password);

}
