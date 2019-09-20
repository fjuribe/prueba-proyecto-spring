package com.springboot.ninja.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.springboot.ninja.entity.Course;
import com.springboot.ninja.entity.QCourse;


@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse= QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exists) {
		JPAQuery<Course> query=new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		Predicate predicate1 = qCourse.description.endsWith("OP");
		if(exists) {
			Predicate predicate2= qCourse.idCourse.eq(23);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.and(predicate3);
		}
		
		
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		//List<Course> courses1=query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,50)).fetch();
	}
	
}
