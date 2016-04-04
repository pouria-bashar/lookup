package com.pba.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	public List<ASICDocument> searchByName(String name) throws NotFoundException {
	

		Query query = new Query();
		query.limit(10);		
		query.addCriteria(Criteria.where("name").regex(name));
		query.limit(10);

		return asicRepository.searchByName(query, name);

	}
	public ASICDocument validateByABN(String abn) throws NotFoundException{
		Query query = new Query();
		query.addCriteria(Criteria.where("abn").is(abn));

		return asicRepository.validateABN(query, abn);

	}
	

}
