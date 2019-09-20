package com.springboot.ninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.springboot.ninja.model.Person;
import com.springboot.ninja.service.ExampleService;


@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
public static final Log LOG =LogFactory.getLog(ExampleServiceImpl.class);


	@Override
	public List<Person> getListPeople() {

			List<Person> people= new ArrayList<>();
			people.add(new Person("Juan",27));
			people.add(new Person("Andres",13));
			people.add(new Person("Mauro",33));
			people.add(new Person("Eva",23));
			LOG.info("HELLO FROM SERVICE");
			return people;
	}

	
}
