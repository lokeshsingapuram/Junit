package com.tcs.services;

import java.util.ArrayList;
import java.util.List;

import com.tcs.dao.ToDoService;

public class ToDoBusinessServiceImpl {
	
	private ToDoService doService;

	public ToDoBusinessServiceImpl(ToDoService doService) {
		super();
		this.doService = doService;
	}
	public List<String>  retriveTodosRelatedToSpring(String user){
		List<String> filterTodos=new  ArrayList<String>();
		List<String> retriveTodos = doService.retriveTodos(user);
		for(String todo:retriveTodos) {
			if(todo.contains("Spring")) {
				filterTodos.add(todo);
			}
			
		}
		filterTodos.forEach(todos->{
			System.out.println(todos);
		});
		return filterTodos;
	}

}
