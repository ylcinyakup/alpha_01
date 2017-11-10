package spring.service;

import java.util.List;

import spring.model.Address;

public interface AddressService {

	public boolean create(Address address);

	public boolean update(Address address);

	public boolean deleteAddressByUsername(String username);

	public boolean deleteAddressById(int id);

	public List<Address> getAddresses();

	public List<Address> getAddressesByUsername(String username);

	public List<Address> getAddressesByCountry(String country);

	public List<Address> getAddressesByCity(String city);

	public Address getAddressById(int id);

	public boolean isAddressExist(Address address);

}
