package com.pba.lookup.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pba.lookup.entities.ASICDocument;

@Repository
public interface ASICRepository extends MongoRepository<ASICDocument, String> {
	   
	   ASICDocument findByCompanyName(String companyName);
	   
	   
	}