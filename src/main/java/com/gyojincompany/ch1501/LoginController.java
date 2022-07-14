package com.gyojincompany.ch1501;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	
//	@RequestMapping("/loginOk")
//	public String loginOk(Member member, BindingResult result) {
//		String view = "loginOk";
//		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);
//		if(result.hasErrors()) {
//			view = "login";
//		}
//		
//		return view;
//	}
	
	@RequestMapping("/loginOk")
	public String loginOk(@Valid Member member, BindingResult result) {
		String view = "loginOk";
		
//		MemberValidator validator = new MemberValidator();
//		validator.validate(member, result);
		if(result.hasErrors()) {
			view = "login";
		}
		
		return view;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberValidator());
	}
}
