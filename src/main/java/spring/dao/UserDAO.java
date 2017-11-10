package spring.dao;

import java.util.List;

import spring.model.User;

public interface UserDAO {

	public boolean createUser(User user);

	public boolean deleteUserByUsername(String username);

	public List<User> getUsers();

	public List<User> getUsersByAuthority(String authority);

	public User getUserByUsername(String username);

	public boolean updateUser(User user);
	

	public boolean isUsernameExist(String username);

	// public Map<String, String> getUsernamePassword(String username);
}
