package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("")
	public String home() {
		return "index";
	}

	@GetMapping("/return")
	public String returnToHome() {
		return "redirect:";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
		
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	
}
