package com.springboot.ninja.component;

import org.springframework.stereotype.Component;

import com.springboot.ninja.entity.Contact;
import com.springboot.ninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {

	
	/**
	 * Convert contact model 2 contact.
	 *
	 * @param contactmodel the contactmodel
	 * @return the contact
	 */
	public Contact convertContactModel2Contact(ContactModel contactmodel) {
		Contact contact=new Contact();
		contact.setCity(contactmodel.getCity());
		contact.setFirstname(contactmodel.getFirstname());
		contact.setId(contactmodel.getId());
		contact.setLastname(contactmodel.getLastname());
		contact.setTelephon(contactmodel.getTelephon());
		return contact;
	}
	
	/**
	 * Convert contact model 2 contact.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
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
