package tody.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="/secu/loginPage")
	public String page() throws Exception {
		return "/secu/loginPage";
	}
	
	@RequestMapping(value="/access_denied_page")
	public String accessDeniedPage() throws Exception {
		return "/access_denied_page";
	}

}
