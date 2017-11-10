package spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import spring.model.Address;
import spring.model.User;

@Component("addressDaoImpl")
public class AddressDAOImpl implements AddressDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	@Transactional
	public boolean create(Address address) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", address.getUser().getUsername());
		params.addValue("country", address.getCountry());
		params.addValue("city", address.getCity());
		params.addValue("neighborhood", address.getNeighborhood());
		params.addValue("street", address.getStreet());
		params.addValue("building", address.getBuilding());
		params.addValue("door", address.getDoor());
		return jdbc.update(
				"insert into address(username, country, city, neighborhood, street, building, door) values(:username, :country, :city, :neighborhood, :street, :building, :door)",
				params) == 1;
	}

	@Override
	public boolean update(Address address) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(address);
		return jdbc.update(
				"update address set country=:country, city=:city, neighborhood=:neighborhood, street=:street, building=:building, door=:door where id=:id",
				params) == 1;
	}

	@Override
	public boolean deleteAddressByUsername(String username) {
		MapSqlParameterSource params = new MapSqlParameterSource("username", username);

		return jdbc.update("delete from address where username=:username", params) == 1;
	}

	@Override
	public boolean deleteAddressById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from address where id=:id", params) == 1;
	}

	@Override
	public List<Address> getAddresses() {
		return jdbc.query("select * from address", BeanPropertyRowMapper.newInstance(Address.class));
	}

	@Override
	public List<Address> getAddressesByUsername(String username) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbc.query("select * from address where username=:username", params,
				BeanPropertyRowMapper.newInstance(Address.class));
	}

	@Override
	public List<Address> getAddressesByCountry(String country) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("country", country);

		return jdbc.query("select * from address where country=:country", params,
				BeanPropertyRowMapper.newInstance(Address.class));
	}

	@Override
	public List<Address> getAddressesByCity(String city) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("city", city);

		return jdbc.query("select * from address where city=:city", params,
				BeanPropertyRowMapper.newInstance(Address.class));
	}

	@Override
	public Address getAddressById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from address where id=:id", params,
				BeanPropertyRowMapper.newInstance(Address.class));
	}

	@Override
	public boolean isAddressExist(Address address) {
		int id = address.getId();
		return jdbc.queryForObject("select count(*) from address where id=:id",
				new MapSqlParameterSource("id", id), Integer.class) > 0;
	}

}
