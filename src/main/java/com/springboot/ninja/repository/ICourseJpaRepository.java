package com.springboot.ninja.repository;

import java.io.Serializable;
//import java.util.List;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ninja.entity.Course;

@Repository("IcourseJpareporitoy")
public interface ICourseJpaRepository extends JpaRepository<Course, Serializable>{

	//void delete(int id);

//     public abstract Course findByPrice(int price);
//         
//     public abstract Course findByPriceAndName(int price,String name);
//     
//     public abstract List<Course> findByNameOrderByHours(String name);
//     
//     public abstract Course findByNameOrPrice(String name,int price);
//
//	public abstract void delete(int id);
	
	
	
}
