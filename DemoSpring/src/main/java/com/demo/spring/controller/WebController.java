package com.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping(value = {"/", "/home"})
	public String homePage() {
		return "hello";
	}
	
	@GetMapping(value="/hello")
	public String hello() {
		return "hello";
	}
	
	
}
