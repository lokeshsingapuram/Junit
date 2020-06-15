package com.tcs.service;

import java.util.List;

import com.tcs.dao.IContactDao;
import com.tcs.exceptions.NoDataFoundException;
import com.tcs.model.Contact;

public class ContactServiceImpl implements ContactService{

	private IContactDao contactDao;
	
	public ContactServiceImpl(IContactDao contactDao) {
		super();
		this.contactDao = contactDao;
	}

	@Override
	public String getNameById(Integer id) {
	String name= contactDao.findNameById(id);
	
	String formattedName=name.toUpperCase();
	System.out.println(formattedName);
	return formattedName;
}

	@Override
	public List<String> getAllContactNames() {
	List<String> names=contactDao.findAllNames();
	System.out.println(names);
	if(!names.isEmpty()) {
		return names;
	}
		return null;
	}

	@Override
	public Contact getContactdetails(Integer id) {
		Contact contact=contactDao.findContactDetailsById(id);
		System.out.println(contact);
		if(contact==null) {
		throw new NoDataFoundException();
		}
		return contact;
		
	}
}