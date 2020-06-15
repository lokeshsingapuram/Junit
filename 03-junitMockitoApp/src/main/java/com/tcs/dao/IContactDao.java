package com.tcs.dao;

import java.util.List;

import com.tcs.model.Contact;

public interface IContactDao {
	
	public String findNameById(Integer id);
	public List<String> findAllNames();
	public Contact findContactDetailsById(Integer id);

}
