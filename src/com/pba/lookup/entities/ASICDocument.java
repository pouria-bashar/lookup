package com.pba.lookup.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asic")
public class ASICDocument {

	private String id;
	private String companyName;

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getId() {
		return id;
	}

	
}
