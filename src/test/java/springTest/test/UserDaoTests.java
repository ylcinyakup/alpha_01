package springTest.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.dao.UserDAO;
import spring.model.User;

@ActiveProfiles("testProfile")
@ContextConfiguration(locations = { "classpath:spring/config/dao-context.xml",
		"classpath:spring/config/security-context.xml", "classpath:springTest/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from address");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateUser() {
		User user = new User("asdqwe", "asdqwe", "asdqwe", "asdqwe", "asdqwe@email.com", 10000, "ROlE_ADMIN", true);
		// ********
		assertTrue("User creation should return true", userDao.createUser(user));

		// ********
		List<User> users = userDao.getUsers();

		assertEquals("Number of users should be 1.", 1, users.size());
		// ********
		assertTrue("User should exist.", userDao.isUsernameExist(user.getUsername()));

		assertEquals("Created user should be identical to retrieved user", user, users.get(0));

		List<User> admins = userDao.getUsersByAuthority("ROLE_ADMIN");

		assertEquals("how many admin are there.", 1, admins.size());

		User byusername = userDao.getUserByUsername("asdqwe");

		assertEquals("should be same", "asdqwe", byusername.getUsername());

		User user2 = new User("asdqwe", "sirma", "sirma", "sirma", "sirma@email.com", 10000, "ROlE_ADMIN", true);

		userDao.updateUser(user2);
		assertEquals("should be updated", "sirma", user2.getName());
		
		//assertTrue("user should be deleted", userDao.deleteUserByUsername(user2.getUsername()));
	}

}
