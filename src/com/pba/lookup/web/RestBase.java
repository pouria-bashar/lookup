package com.pba.lookup.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pba.lookup.response.JsonResponse;

public abstract class RestBase {
	@Autowired private ServletContext servletContext;
	
	public JsonResponse buildResponse(String result, HttpStatus status){
		JsonResponse response = new JsonResponse(result);
	
		
		return response;
	}
}
