package com.pba.lookup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pba.lookup.dao.ASICRepository;
import com.pba.lookup.entities.ASICDocument;

@Service
public class LookupService {
	@Autowired
	private ASICRepository asicRepository;

	/**
	 * Returns company details for a company name
	 * @param companyName the company name
	 * @return The ASIC details for a company
	 */
	public ASICDocument getCompanyByName(String companyName){
		return asicRepository.findByCompanyName(companyName);
	}
}
