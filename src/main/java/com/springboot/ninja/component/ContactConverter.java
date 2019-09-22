package com.springboot.ninja.component;

import org.springframework.stereotype.Component;

import com.springboot.ninja.entity.Contact;
import com.springboot.ninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	
	public Contact convertContactModel2Contact(ContactModel contactmodel) {
		Contact contact=new Contact();
		contact.setCity(contactmodel.getCity());
		contact.setFirstname(contactmodel.getFirstname());
		contact.setId(contactmodel.getId());
		contact.setLastname(contactmodel.getLastname());
		contact.setTelephon(contactmodel.getTelephon());
		return contact;
	}
	
	public ContactModel convertContactModel2Contact(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setId(contact.getId());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephon(contact.getTelephon());
		return contactModel;

	}
}
