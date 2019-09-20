package com.springboot.ninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/example3",method=RequestMethod.GET)
public class Example4Controller {
      
	@GetMapping("/error")
	public String error() {
		return "404";
	}
}
