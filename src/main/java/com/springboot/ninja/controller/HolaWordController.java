package com.springboot.ninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/soy")
public class HolaWordController {
	
	@GetMapping("/hola")
   public String holamundo(){
	   return "hola";
   }
}
