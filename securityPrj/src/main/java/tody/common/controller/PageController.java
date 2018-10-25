package tody.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="/page")
	public String page() throws Exception {
		return "/page";
	}
	
	@RequestMapping(value="/user/page")
	public String userPage() throws Exception {
		return "/user/page";
	}
	
	@RequestMapping(value="/member/page")
	public String memberPage() throws Exception {
		return "/member/page";
	}
	
	@RequestMapping(value="/admin/page")
	public String adminPage() throws Exception {
		return "/admin/page";
	}
}
