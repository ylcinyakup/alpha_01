package springTest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import spring.dao.AddressDAO;
import spring.dao.UserDAO;
import spring.model.Address;
import spring.model.User;

@ActiveProfiles("testProfile")
@ContextConfiguration(locations = { "classpath:spring/config/dao-context.xml",
		"classpath:spring/config/security-context.xml", "classpath:springTest/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressDaoTests {

	@Autowired
	private AddressDAO addressDao;

	@Autowired
	UserDAO userDao;

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

		Address address = new Address(user, "turkey", "istanbul", "gop", "813", "30", "3");

		assertTrue("address creation should return true", addressDao.create(address));
		List<Address> addresses = addressDao.getAddresses();

		assertEquals("Number of address should be 1.", 1, addresses.size());
		
		assertTrue("address should exist.", addressDao.isAddressExist(addresses.get(0)));

		assertEquals("Created user should be identical to retrieved user", address, addresses.get(0));
		
		assertEquals("should be same", "istanbul",addressDao.getAddressesByCountry("turkey").get(0).getCity());


	}

}
