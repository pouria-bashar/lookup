package com.pba.lookup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pba.lookup.dao.ASICRepository;
import com.pba.lookup.entities.ASICDocument;
import com.pba.lookup.exceptions.NotFoundException;

@Service
public class LookupService {
	@Autowired
	private ASICRepository asicRepository;

	/**
	 * Returns company details for a company name
	 * 
	 * @param companyName
	 *            the company name
	 * @return The ASIC details for a company
	 */
	public ASICDocument getCompanyByName(String companyName) throws NotFoundException{
		ASICDocument result = asicRepository.findByCompanyName(companyName);
		if(result == null){
			throw new NotFoundException("Could not find any records for \"" + companyName + " \"");
		}
		return result;
	}

}
