package coms.softra.RestfulWebService;

public interface IService {
	public User save(User user);
	public User findByuserIdAndLoginPassword(int userId, String password);
//	public User findByUser_idAndLogin_password(int userId, String password);
}
