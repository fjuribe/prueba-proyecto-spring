package com.springboot.ninja.service;

import java.util.List;

import com.springboot.ninja.entity.Course;

public interface ICourseService {
       public abstract List<Course> listAllCourses();
	   public abstract Course addCourse(Course course);
	   public abstract int removeCourse(int id);
	   public abstract Course updateCourse(Course course);
   
}
