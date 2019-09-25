package com.springboot.ninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.ninja.component.ContactConverter;
import com.springboot.ninja.entity.Contact;
import com.springboot.ninja.model.ContactModel;
import com.springboot.ninja.repository.ContactRepository;
import com.springboot.ninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	
	public ContactModel addcontact(ContactModel contactModel) {
		Contact contact=contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContactModel2Contact(contact);
	}

	@Override
	public List<ContactModel> listAllcontacts() {
		List<Contact> contacts=contactRepository.findAll();
		List<ContactModel> contactsModel= new ArrayList<ContactModel>();
		for(Contact contact:contacts) {
			contactsModel.add(contactConverter.convertContactModel2Contact(contact));
		}

		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findByid(id);

	}
	
    public ContactModel findContactByIdModel(int id) {
	     return contactConverter.convertContactModel2Contact(findContactById(id));
     }
	
	
	@Override
	public void removeContact(int id) {
		Contact contact=findContactById(id);
		if(null!=contact) {
			contactRepository.delete(contact);
		}
	}

	
}
