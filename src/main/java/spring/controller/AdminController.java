package spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.User;
import spring.service.AddressServiceImpl;
import spring.service.UserServiceImpl;



/**
 * 
 * @author yakup
 * 
 */


@Controller
public class AdminController {

	private UserServiceImpl usi;

	private AddressServiceImpl addressServiceImpl;

	@Autowired
	public void setAddressServiceImpl(AddressServiceImpl addressServiceImpl) {
		this.addressServiceImpl = addressServiceImpl;
	}

	@Autowired
	public void setUsi(UserServiceImpl usi) {
		this.usi = usi;
	}

	@RequestMapping(value = { "/adminPage" })
	public String showAdmin() {
		return "adminPage";
	}

	// public ModelAndView getUserList(){
	//
	// List<User> users = usi.getUsers();
	// ModelAndView mav = new ModelAndView("adminHandleUsers");
	// mav.addObject("users", users);
	// mav.addObject("user", new User());
	// return mav;
	// }
	@RequestMapping(value = { "/adminHandleUsers" })
	public String showAdminHandleUser(Model model) {

		List<User> users = usi.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		return "adminHandleUsers";
	}

	@RequestMapping(value = { "/adminHandleUsers" }, method = RequestMethod.POST, params = "update")
	public String updateUser(Model model, @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("invoking updateUser");

		System.out.println(user);
		usi.updateUser(user);
		List<User> users = usi.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		return "adminHandleUsers";
	}

	@RequestMapping(value = { "/adminHandleUsers" }, method = RequestMethod.POST, params = "delete")
	public String deleteUser(Model model, @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("invoking deleteUser");

		System.out.println(user);
		String username = user.getUsername(); // önce addresleri sonra useri siliyoruz yoksa patlar
		addressServiceImpl.deleteAddressByUsername(username);
		usi.deleteUserByUsername(username);
		List<User> users = usi.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		return "adminHandleUsers";
	}

}
