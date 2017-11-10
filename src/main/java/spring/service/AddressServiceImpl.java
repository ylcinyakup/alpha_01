package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.AddressDAOImpl;
import spring.model.Address;

@Service("addressServiceImpl")
public class AddressServiceImpl implements AddressService {

	private AddressDAOImpl addressDaoImpl;

	@Autowired
	public void setAddressDao(AddressDAOImpl addressDaoImpl) {
		this.addressDaoImpl = addressDaoImpl;
	}

	@Override
	public boolean create(Address address) {
		return addressDaoImpl.create(address);
	}

	@Override
	public boolean update(Address address) {
		return addressDaoImpl.update(address);
	}

	@Override
	public boolean deleteAddressByUsername(String username) {
		return addressDaoImpl.deleteAddressByUsername(username);
	}

	@Override
	public boolean deleteAddressById(int id) {
		return addressDaoImpl.deleteAddressById(id);
	}

	@Override
	public List<Address> getAddresses() {
		return addressDaoImpl.getAddresses();
	}

	@Override
	public List<Address> getAddressesByUsername(String username) {
		return addressDaoImpl.getAddressesByUsername(username);
	}

	@Override
	public List<Address> getAddressesByCountry(String country) {
		return addressDaoImpl.getAddressesByCountry(country);
	}

	@Override
	public List<Address> getAddressesByCity(String city) {
		return addressDaoImpl.getAddressesByCity(city);
	}

	@Override
	public Address getAddressById(int id) {
		return addressDaoImpl.getAddressById(id);
	}

	@Override
	public boolean isAddressExist(Address address) {
		return addressDaoImpl.isAddressExist(address);
	}

}
