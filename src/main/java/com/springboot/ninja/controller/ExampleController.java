package com.springboot.ninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ninja.component.ExampleComponent;
import com.springboot.ninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW="example";
	
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	//Inyectando componente
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent examplecomponenet;
	
	//Primera forma
	@GetMapping("/exampleString")
	   public String exampleString(Model model) {
		examplecomponenet.sayHello();
		model.addAttribute("people",exampleService.getListPeople());
		   return EXAMPLE_VIEW;
	   }
	
	//Segunda forma
	@RequestMapping(value="/exampleMAW",method=RequestMethod.GET)
	public ModelAndView exampleMAW() {
		ModelAndView mav= new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people",exampleService.getListPeople());
		return mav;
	}
	
//	private List<Person> getPeople(){
//		List<Person> people= new ArrayList<>();
//		people.add(new Person("Juan",27));
//		people.add(new Person("Andres",13));
//		people.add(new Person("Mauro",33));
//		people.add(new Person("Eva",23));
//		return people;
//		
//	}
}
