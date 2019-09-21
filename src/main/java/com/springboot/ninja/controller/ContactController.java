package com.springboot.ninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ninja.constant.ViewConstant;
import com.springboot.ninja.model.ContactModel;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG=LogFactory.getLog(ContactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONSTANTS;
	}
	
	
	@GetMapping("/contactform")
	private String redirectContactFrom(Model model) {
		model.addAttribute("contactModel",new ContactModel());
		return ViewConstant.CONSTANT_FORM;
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,Model model) {
		LOG.info("METHOD:addContact() -- PARAMS:"+contactModel.toString());
		model.addAttribute("result",1);
		return ViewConstant.CONSTANTS;
	}
}
