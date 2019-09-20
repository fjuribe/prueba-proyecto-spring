package com.springboot.ninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ninja.entity.Course;
import com.springboot.ninja.service.ICourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	
	private static final String COURSES_VIEW="course";
	
	private static final Log LOG=LogFactory.getLog(CourseController.class);
	
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private ICourseService courseSevice; 

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call:"+"listAllCourses()");
		ModelAndView mav=new ModelAndView(COURSES_VIEW);
		mav.addObject("courses",courseSevice.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call:"+"addCourse()"+"-- Param:"+course.toString());
		courseSevice.addCourse(course);
		return "redirect:/course/listcourses";
	}
}
