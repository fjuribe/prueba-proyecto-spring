package com.springboot.ninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.ninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3controller {

	//para establecer log
	private static final Log LOGGER =LogFactory.getLog(Example3controller.class);

	
	public static final String FORM_VIEW="form";
	public static final String RESULT_VIEW="result";
	
	
	//como redireccionar
	//1- forma
    //	@GetMapping("/")
    //	public String redirect() {
    //		return "redirect:/example3/showform";
    //	}
    //	
	
	//2- forma
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public String  showForm(Model model) {
//		LOGGER.info("INF TRACE");
//		LOGGER.warn("WARN TRACE");
//		LOGGER.error("ERROR TRACE");
//		LOGGER.debug("DEBUG");
	
		model.addAttribute("person",new Person());
		//int i=6/0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person,BindingResult bindingResult) {	
		
		ModelAndView mav=new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person",person);
		}
		
		LOGGER.info("METHOD:'addPerson' -- Param:'"+person+"'");
		LOGGER.info("TEMPLATE:'"+RESULT_VIEW+"' --DATA:'"+person+"'");
		return mav;
		
	}
}
