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
	
    @RequestMapping(value="/access_denied")
    public ModelAndView accessDenied() throws Exception {
    	ModelAndView mv = new ModelAndView("/goIndex");
    	mv.addObject("msg", "접근 권한이 없습니다.");
    	mv.addObject("url", "/");
    	return mv;
    }

}
