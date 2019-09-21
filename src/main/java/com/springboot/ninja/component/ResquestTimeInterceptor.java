package com.springboot.ninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterception")
public class ResquestTimeInterceptor extends HandlerInterceptorAdapter{

	
	private static final Log LOG=LogFactory.getLog(ResquestTimeInterceptor.class);
	
	//primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime",System.currentTimeMillis());
		return true;
	}

	
	//segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime=(long)request.getAttribute("startTime");
		LOG.info("Url to:'"+request.getRequestURI().toString()+"'in'"+(System.currentTimeMillis()-startTime)+"ms'");
	}



	
	
}
