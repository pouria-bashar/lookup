/**
 * 
 */
package com.pba.lookup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pba.lookup.entities.ASICDocument;

@Repository
public class ASICRepository {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	public List<ASICDocument> searchByName(Query query , String name){
		return mongoTemplate.find(query, ASICDocument.class);
	}
	

}