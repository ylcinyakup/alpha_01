package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yakup
 * 
 */

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home" })
	public String showHome() {
		return "home";
	}

	@RequestMapping(value = { "/denied" })
	public String showDenied() {
		return "denied";
	}

}
