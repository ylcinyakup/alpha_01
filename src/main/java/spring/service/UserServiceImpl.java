package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.UserDAOImpl;
import spring.model.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserDAOImpl udi;

	@Autowired
	public void setUdi(UserDAOImpl udi) {
		this.udi = udi;
	}

	@Override
	public boolean createUser(User user) {

		return udi.createUser(user);
	}

	@Override
	public boolean deleteUserByUsername(String username) {
		return udi.deleteUserByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return udi.getUsers();
	}

	@Override
	public User getUserByUsername(String username) {
		return udi.getUserByUsername(username);
	}

	@Override
	public boolean updateUser(User user) {
		return udi.updateUser(user);
	}

	@Override
	public boolean isUsernameExist(String username) {
		return udi.isUsernameExist(username);
	}

}
