package com.springboot.ninja.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.ninja.constant.ViewConstant;
import com.springboot.ninja.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOG=LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD:redirectToLogin()");
		return "redirect:/login";
	}
	
	
	@GetMapping("/login")
	public String showLoginFrom(Model model,
			@RequestParam(name="error",defaultValue="",required=false) String error,
	        @RequestParam(name="logout",required=false)String logout){
		LOG.info("METHOD:showLoginFrom() -- PARAM:error="+error+"logaut:"+logout);
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		model.addAttribute("userCredentials",new UserCredential());
		LOG.info("Returning to Login view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
		LOG.info("METHOD:loginCheck() -- PARAMS:"+userCredential.toString());
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			return ViewConstant.CONSTANTS;
		}
		LOG.info("Redirect to Login?error");
		return "redirect:/login?error";
	}
	
}
