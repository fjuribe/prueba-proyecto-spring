package com.springboot.ninja.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.ninja.entity.Course;
import com.springboot.ninja.repository.ICourseJpaRepository;
import com.springboot.ninja.service.ICourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements ICourseService{

	private static final Log LOG=LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("IcourseJpareporitoy")
	private ICourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		LOG.info("Call: "+"listAllCourse()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: "+"addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		courseJpaRepository.save(course);
		return courseJpaRepository.save(course);
	}



	
}
