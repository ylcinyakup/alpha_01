package spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.User;
import spring.service.UserServiceImpl;

/**
 * 
 * @author yakup
 * 
 */

@Controller
public class UserController {

	private UserServiceImpl usi;

	@Autowired
	public void setUsi(UserServiceImpl usi) {
		this.usi = usi;
	}

	@RequestMapping(value = { "/newUser" })
	public String showNewUserPage(Model model) {
		model.addAttribute("user", new User());
		return "createUser";
	}

	@RequestMapping(value = { "/createUser" })
	public String createUser(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {

			return "createUser";

		}
		// alttaki mesaj ile createUser ekran�nda var olan bir Username girince k�rm�z�
		// yaz�yla this username already exist yaz�cak
		if (usi.isUsernameExist(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "This Username Already Exist");
			return "createUser";
		}
		user.setAuthority("ROLE_ADMIN");
		user.setBalance(10000);
		try {
			usi.createUser(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
			return "createUser";
		}

		return "home";
	}
}
