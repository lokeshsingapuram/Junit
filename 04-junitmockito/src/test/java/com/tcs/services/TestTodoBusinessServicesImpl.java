package com.tcs.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tcs.dao.ToDoService;

public class TestTodoBusinessServicesImpl {
	private static ToDoBusinessServiceImpl service;
	@BeforeClass
	public static void Init() {
		List<String> user=new ArrayList();
		user.add("Spring");
		user.add("hibernate");
		user.add("micro services");
		user.add("Spring");
		ToDoService daoProxy= EasyMock.createMock(ToDoService.class);
		EasyMock.expect(daoProxy.retriveTodos("Spring")).andReturn(user);
		EasyMock.replay(daoProxy);
		service=new ToDoBusinessServiceImpl(daoProxy);
		
		
	}
	
	@Test
	public void testRetriveTodosRelatedToSpring() {
		List<String> list = service.retriveTodosRelatedToSpring("Spring");
		assertNotNull(list);
	}

}
