package spring.service;

import java.util.List;

import spring.model.User;

public interface UserService {

	public boolean createUser(User user);

	public boolean deleteUserByUsername(String username);

	public List<User> getUsers();

	public User getUserByUsername(String username);

	public boolean updateUser(User user);

	public boolean isUsernameExist(String username);

}
