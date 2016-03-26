package com.pba.lookup.web.asic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pba.lookup.service.LookupService;

@RestController
public class CompanySearch {

	@Autowired
	private LookupService lookupService;
	
	@RequestMapping(value = "ASIC/search" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public String getResponse(@RequestParam("name") String name){
		
		return lookupService.getCompanyByName(name).toString();
	}
}
