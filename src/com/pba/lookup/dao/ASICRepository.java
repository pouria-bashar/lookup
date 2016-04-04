/**
 * 
 */
package com.pba.lookup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pba.lookup.entities.ASICDocument;
import com.pba.lookup.exceptions.NotFoundException;

@Repository
public class ASICRepository {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	/**
	 * Looks up company by name
	 * @param the name of the company to look up
	 * @param limit the maximum number of records to return
	 * @return List of ASICDocuments martching the search criteria
	 * @throws NotFoundException if there are no records matching the search criteria
	 */
	public List<ASICDocument> searchByName(String name, int limit) throws NotFoundException{
		Query query = new Query().limit(limit).addCriteria(Criteria.where("name").regex(name));
		List<ASICDocument> documents = mongoTemplate.find(query, ASICDocument.class);
		if(documents == null  || documents.size() < 1){
			throw new NotFoundException("Could not find records matching the search criteria");
		}
		return documents;
	}
	
	/**
	 * Finds record matching the abn record
	 * @param abn the abn to lookup
	 * @return ASIC document matching the search criteria
	 * @throws NotFoundException if there are no records matching the search criteria
	 */
	public ASICDocument validateABN(String abn) throws NotFoundException{
		Query query = new Query().addCriteria(Criteria.where("abn").is(abn));
		ASICDocument document =  mongoTemplate.findOne(query, ASICDocument.class);
		if(document == null){
			throw new NotFoundException("Could not find records matching the search criteria");
		}
		return document;
		
	}
	

}