package com.tcs.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tcs.dao.IContactDao;
import com.tcs.exceptions.NoDataFoundException;
import com.tcs.model.Contact;

public class TestContactServiceImpl {
	private static ContactServiceImpl service;
	@BeforeClass
	public static void start() {
		List<String> names=new ArrayList();
		names.add("lokesh");
		names.add("rajesh");
		names.add("pavan");
		Contact contact=new Contact();
		contact.setId("100");
		contact.setContactName("lokesh");
		contact.setPhNo(7032932);
		        //creating the mock
				IContactDao daoProxy=EasyMock.createMock(IContactDao.class);
				//setting the behavior to mock
				EasyMock.expect(daoProxy.findNameById(101)).andReturn("Lokesh");
				EasyMock.expect(daoProxy.findContactDetailsById(201)).andReturn(null);
				EasyMock.expect(daoProxy.findAllNames()).andReturn(names);
				EasyMock.expect(daoProxy.findAllNames()).andReturn(null);
				EasyMock.expect(daoProxy.findContactDetailsById(100)).andReturn(contact);

				EasyMock.replay(daoProxy);
				service=new ContactServiceImpl(daoProxy);
	}
	
	@Test
	public void testGetNameById() {
	String name = service.getNameById(101);
	assertNotNull(name);
	}
	@Test
	public void testGetAllContactNames_01() {
		List<String> contactNames = service.getAllContactNames();
		assertNotNull(contactNames);
	}

	
	  @Test() 
	  public void testGetAllContactNames_02() {
List<String> contactNames = service.getAllContactNames(); 
	  assertNull(contactNames);
	  }
	 
	@Test
public void testGetContactdetails_01() {
	Contact contactdetails = service.getContactdetails(100);
	assertNotNull(contactdetails);
}
	@Test(expected = NoDataFoundException.class)
	public void testGetContactdetails_02() {
		 service.getContactdetails(201);
	}


}
