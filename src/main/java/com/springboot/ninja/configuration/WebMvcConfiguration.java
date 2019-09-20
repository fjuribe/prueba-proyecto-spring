package com.springboot.ninja.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.ninja.component.ResquestTimeInterceptor;



@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	@Autowired
	@Qualifier("requestTimeInterception")
	private ResquestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(requestTimeInterceptor);
	}

	
}
