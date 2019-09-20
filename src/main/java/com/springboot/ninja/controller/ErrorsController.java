package com.springboot.ninja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorsController {
	
	public static final String ISE_VIEW="error/500";
	
//esta funcion captura cualquier error y lanza la vista declarada en la constante
	@ExceptionHandler(Exception.class)
     public String showInternalServerError() {
    	 return ISE_VIEW;
    	 
     }
}
