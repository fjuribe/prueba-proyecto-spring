package com.springboot.ninja.service;

import java.util.List;

import com.springboot.ninja.entity.Contact;
import com.springboot.ninja.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addcontact(ContactModel contactModel);
	
	public abstract List<ContactModel> ListAllcontacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdModel(int id);
	}

