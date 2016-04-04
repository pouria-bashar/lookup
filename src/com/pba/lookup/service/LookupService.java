package com.pba.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pba.lookup.dao.ASICRepository;
import com.pba.lookup.entities.ASICDocument;
import com.pba.lookup.exceptions.NotFoundException;

@Service
public class LookupService {
	@Autowired
	private ASICRepository asicRepository;
	private final int MAX_NUMBER_OF_RECORDS = 20;

	/**
	 * Perform search on the company name
	 * 
	 * @param name the name of the compnay to search
	 * @param limit maximum number of records to return
	 * @return List of ASICDocuments matching the search criteria
	 * @throws NotFoundException
	 *             if no records are found
	 */
	public List<ASICDocument> searchByName(String name, int limit) throws NotFoundException {
		return asicRepository.searchByName(name, limit > MAX_NUMBER_OF_RECORDS ? MAX_NUMBER_OF_RECORDS : limit);
	}

	/**
	 * Performs ABN validation
	 * 
	 * @param abn the abn to validate
	 * @return ASIC document matching the abn
	 * @throws NotFoundException if there are no records matching the search criteria
	 */
	public ASICDocument validateByABN(String abn) throws NotFoundException {
		return asicRepository.validateABN(abn);
	}

}
