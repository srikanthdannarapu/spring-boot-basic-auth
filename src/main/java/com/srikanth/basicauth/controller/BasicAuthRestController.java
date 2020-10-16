package com.srikanth.basicauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthRestController {

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "You are trying to access \"user\" API and you are logged in as "+authentication.getName()+" and your roles are "+ authentication.getAuthorities().toString();
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "You are trying to access \"admin\" API and you are logged in as "+authentication.getName()+" and your roles are "+ authentication.getAuthorities().toString();
	}
}
