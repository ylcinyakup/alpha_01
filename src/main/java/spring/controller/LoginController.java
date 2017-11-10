package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yakup
 * 
 */

@Controller
public class LoginController {

	@RequestMapping(value = { "/login" })
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = { "/logout" })
	public String showLogOut() {
		return "logout";
	}

}
