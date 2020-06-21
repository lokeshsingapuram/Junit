package com.tcs.service;

import com.tcs.domain.Order;

public interface OrderService {
	
	boolean placeOrder(Order order);
	boolean cancelOrder(int id);
	boolean deleteOrder(int id);

}
