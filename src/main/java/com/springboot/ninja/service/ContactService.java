package com.springboot.ninja.service;

import java.util.List;

import com.springboot.ninja.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addcontact(ContactModel contactModel);
	
	public abstract List<ContactModel> ListAllcontacts();
	}

