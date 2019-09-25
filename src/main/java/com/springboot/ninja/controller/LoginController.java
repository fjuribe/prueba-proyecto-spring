package com.springboot.ninja.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.ninja.constant.ViewConstant;


@Controller
public class LoginController {

	private static final Log LOG=LogFactory.getLog(LoginController.class);
	
	
	@GetMapping("/login")
	public String showLoginFrom(Model model,
			@RequestParam(name="error",defaultValue="",required=false) String error,
	        @RequestParam(name="logout",required=false)String logout){
		LOG.info("METHOD:showLoginFrom() -- PARAM:error="+error+"logaut:"+logout);
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);

		LOG.info("Returning to Login view");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/logincheck","/"})
	public String loginCheck() {
		LOG.info("METHOD:loginCheck()");
		LOG.info("Retornando los contactos de la vista");
			return "redirect:/contacts/showcontacts";

	}
	
}
