package spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Address;
import spring.model.User;

@Component("userDaoImpl")
public class UserDAOImpl implements UserDAO {

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	@Transactional
	public boolean createUser(User user) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("name", user.getName());
		params.addValue("surname", user.getSurname());
		params.addValue("email", user.getEmail());
		params.addValue("balance", user.getBalance());
		params.addValue("authority", user.getAuthority());
		params.addValue("enabled", 1);
		return jdbc.update(
				"insert into users(username, password, name, surname, email, balance, authority, enabled) values(:username, :password, :name, :surname, :email, :balance, :authority, :enabled)",
				params) == 1;
	}

	@Override
	public boolean deleteUserByUsername(String username) {
		MapSqlParameterSource params = new MapSqlParameterSource("username", username);

		return jdbc.update("delete from users where username=:username", params) == 1;
	}

	@Override
	public List<User> getUsers() {
		return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public List<User> getUsersByAuthority(String authority) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("authority", authority);

		return jdbc.query("select * from users where authority=:authority", params,
				BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public User getUserByUsername(String username) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		return jdbc.queryForObject("select * from users where username=:username", params,
				BeanPropertyRowMapper.newInstance(User.class));
		// return (User) jdbc.queryForObject("select * from user where
		// username=:username", params, new UserRowMapper());
	}

	@Override
	public boolean updateUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update(
				"update users set password=:password, name=:name, surname=:surname, email=:email, balance=:balance, authority=:authority, enabled=:enabled where username=:username",
				params) == 1;
	}

	@Override
	public boolean isUsernameExist(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

}
