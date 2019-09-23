package com.springboot.ninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ninja.constant.ViewConstant;
import com.springboot.ninja.model.ContactModel;
import com.springboot.ninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG=LogFactory.getLog(ContactController.class);
	
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	
	@GetMapping("/contactform")
	private String redirectContactFrom(Model model) {
		model.addAttribute("contactModel",new ContactModel());
		return ViewConstant.CONSTANT_FORM;
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,Model model) {
		LOG.info("METHOD:addContact() -- PARAMS:"+contactModel.toString());
		
		if(null!=contactService.addcontact(contactModel)) {
			model.addAttribute("result",1);
		}else {
			model.addAttribute("result",0);
		}
		
		model.addAttribute("result",1);
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView maw=new ModelAndView(ViewConstant.CONSTANTS);
		maw.addObject("contacts",contactService.ListAllcontacts());
		return maw;
		
	}
	
	
}
