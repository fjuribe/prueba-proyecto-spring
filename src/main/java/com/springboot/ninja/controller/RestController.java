package com.springboot.ninja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ninja.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		
		ContactModel cm =new ContactModel(2,"Mikel","Perez","123456","MAdrid");
		return new ResponseEntity<ContactModel>(cm,HttpStatus.OK);

		
	}
}
