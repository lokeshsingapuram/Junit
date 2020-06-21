package com.tcs.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tcs.domain.Order;
import com.tcs.exception.BOException;
import com.tcs.repositories.OrderDAO;
import com.tcs.service.OrderService;
import com.tcs.service.OrderServiceImpl;

public class OrderServiceImplTest {
	private static final int ORDER_ID = 123;
	private static OrderDAO dao;
	private static OrderService service;
	@BeforeClass
	public static void setUp() throws SQLException {
		dao=mock(OrderDAO.class);
		service=new OrderServiceImpl(dao);	
	}
	
	@Test
	public void placeOrder_should_createAnOrder() throws SQLException {
		Order	order =new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean placeOrder = service.placeOrder(order);
		assertTrue(placeOrder);
		verify(dao).create(order);
	}
	@Test
	public void placeOrder_should_dontCreateAnOrder_forNonAvailableItems() throws SQLException {
		Order	order =new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean placeOrder = service.placeOrder(order);
		assertFalse(placeOrder);
	}
	@Test(expected = BOException.class)
	public void placeOrder_should_throwException()throws SQLException {
		Order	order =new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		boolean placeOrder = service.placeOrder(order);
	}
	@Test
	public void cancelOrder_should_CancelTheOrder() throws SQLException {
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean cancelOrder = service.cancelOrder(ORDER_ID);
		assertTrue(cancelOrder);
	}
	@Test
	public void cancelOrder_should_NotCancelTheOrder() throws SQLException {
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean cancelOrder = service.cancelOrder(ORDER_ID);
		assertFalse(cancelOrder);
	}
	@Test(expected = BOException.class)
	public void cancelOrder_should_throwException() throws SQLException {
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
		service.cancelOrder(ORDER_ID);
	}
	@Test(expected = BOException.class)
	public void cancelOrder_should_throwException_onUpdate() throws SQLException {
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		service.cancelOrder(123);
	}
@Test
 public void deleteOrder_should_deleteTheItem() throws SQLException {
	 Order order=new Order();
	 when(dao.delete(ORDER_ID)).thenReturn(1);
	 boolean deleteOrder = service.deleteOrder(ORDER_ID);
	 assertTrue(deleteOrder);
	 
 }
@Test
public void deleteOrder_should_notdeleteTheItem() throws SQLException {
	 Order order=new Order();
	 when(dao.delete(ORDER_ID)).thenReturn(0);
	 boolean deleteOrder = service.deleteOrder(ORDER_ID);
	 assertFalse(deleteOrder);	 
}
@Test(expected = BOException.class)
public void deleteOrder_should_throwException() throws SQLException {
	 Order order=new Order();
	 when(dao.delete(ORDER_ID)).thenThrow(SQLException.class);
	service.deleteOrder(ORDER_ID);
}

}
