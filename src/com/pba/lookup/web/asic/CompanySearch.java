package com.pba.lookup.web.asic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pba.lookup.service.LookupService;

@RestController
public class CompanySearch {

	@Autowired
	private LookupService lookupService;
	@RequestMapping(value = "abc" , method = RequestMethod.GET)
	public String getResponse(){
		
		return lookupService.getCompanyByName("PBA").toString();
	}
}
