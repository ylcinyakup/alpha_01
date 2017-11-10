package spring.controller;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Address;
import spring.model.User;
import spring.service.AddressServiceImpl;
import spring.service.UserServiceImpl;

/**
 * 
 * @author yakup
 * 
 * */


@Controller
public class AddressController {

	private UserServiceImpl userServiceImpl;

	private AddressServiceImpl addressServiceImpl;

	@Autowired
	public void setAddressServiceImpl(AddressServiceImpl addressServiceImpl) {
		this.addressServiceImpl = addressServiceImpl;
	}

	@Autowired
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@RequestMapping(value = { "/addressPage" }, method = RequestMethod.GET)
	public String getAddress(Model model, Principal principal) {
		System.out.println("invoking getAddress");

		// User user = userServiceImpl.getUserByUsername(principal.getName());
		// user.getUsername()
		List<Address> addresses = addressServiceImpl.getAddressesByUsername(principal.getName());

		model.addAttribute("addresses", addresses);
		model.addAttribute("address", new Address());

		return "addressPage";
	}

	@RequestMapping(value = { "/addressPage" }, method = RequestMethod.POST, params = "create")
	public String createAddress(Model model, @ModelAttribute("address") Address address, BindingResult result,
			Principal principal) {
		System.out.println("invoking createAddress");

		User user = userServiceImpl.getUserByUsername(principal.getName());
		System.out.println(user);
		address.setUser(user);

		System.out.println(address);

		addressServiceImpl.create(address);

		List<Address> addresses = addressServiceImpl.getAddressesByUsername(principal.getName());

		model.addAttribute("addresses", addresses);
		model.addAttribute("address", new Address());
		return "addressPage";
	}

	@RequestMapping(value = { "/addressPage" }, method = RequestMethod.POST, params = "update")
	public String updateAddress(Model model, @ModelAttribute("address") Address address, BindingResult result,
			Principal principal) {
		System.out.println("invoking updateAddress");

		User user = userServiceImpl.getUserByUsername(principal.getName());
		System.out.println(user);
		address.setUser(user);

		System.out.println(address);

		addressServiceImpl.update(address);

		List<Address> addresses = addressServiceImpl.getAddressesByUsername(principal.getName());

		model.addAttribute("addresses", addresses);
		model.addAttribute("address", new Address());
		return "addressPage";
	}

	@RequestMapping(value = { "/addressPage" }, method = RequestMethod.POST, params = "delete")
	public String deleteAddress(Model model, @ModelAttribute("address") Address address, BindingResult result,
			Principal principal) {
		System.out.println("invoking deleteAddress");

		System.out.println(address);

		addressServiceImpl.deleteAddressById(address.getId());

		List<Address> addresses = addressServiceImpl.getAddressesByUsername(principal.getName());

		model.addAttribute("addresses", addresses);
		model.addAttribute("address", new Address());
		return "addressPage";
	}
}
