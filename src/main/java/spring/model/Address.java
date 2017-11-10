package spring.model;

import spring.model.User;

public class Address {

	private int id;
	private User user;
	private String country;
	private String city;
	private String neighborhood;
	private String street;
	private String building;
	private String door;

	public Address() {
	}

	public Address(int id) {
		this.id = id;
	}

	public Address(int id, User user, String country, String city, String neighborhood, String street, String building,
			String door) {
		this.id = id;
		this.user = user;
		this.country = country;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.building = building;
		this.door = door;
	}

	public Address(User user, String country, String city, String neighborhood, String street, String building,
			String door) {
		this.user = user;
		this.country = country;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.building = building;
		this.door = door;
	}

	public Address(String country, String city, String neighborhood, String street, String building, String door) {
		this.country = country;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.building = building;
		this.door = door;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((door == null) ? 0 : door.hashCode());
		result = prime * result + ((neighborhood == null) ? 0 : neighborhood.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (door == null) {
			if (other.door != null)
				return false;
		} else if (!door.equals(other.door))
			return false;
		if (neighborhood == null) {
			if (other.neighborhood != null)
				return false;
		} else if (!neighborhood.equals(other.neighborhood))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", neighborhood=" + neighborhood + ", street="
				+ street + ", building=" + building + ", door=" + door + "]";
	}


}
