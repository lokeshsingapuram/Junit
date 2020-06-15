package com.tcs.service;

import java.util.List;

import com.tcs.model.Contact;

public interface ContactService {
	public String getNameById(Integer id);
	public List<String> getAllContactNames();
	public Contact getContactdetails(Integer id);

}
