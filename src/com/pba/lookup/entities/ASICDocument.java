package com.pba.lookup.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asic")
public class ASICDocument {

	private String id;
	private String name;
	private String status;
	private String dateOfRegistration;
	private String dateofCancelation;
	private String renewalDate;
	private String formerStateNumber;
	private String previousStateOfRegistration;
	private String abn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getDateofCancelation() {
		return dateofCancelation;
	}

	public void setDateofCancelation(String dateofCancelation) {
		this.dateofCancelation = dateofCancelation;
	}

	public String getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getFormerStateNumber() {
		return formerStateNumber;
	}

	public void setFormerStateNumber(String formerStateNumber) {
		this.formerStateNumber = formerStateNumber;
	}

	public String getPreviousStateOfRegistration() {
		return previousStateOfRegistration;
	}

	public void setPreviousStateOfRegistration(String previousStateOfRegistration) {
		this.previousStateOfRegistration = previousStateOfRegistration;
	}

	public String getAbn() {
		return abn;
	}

	public void setAbn(String abn) {
		this.abn = abn;
	}

}
