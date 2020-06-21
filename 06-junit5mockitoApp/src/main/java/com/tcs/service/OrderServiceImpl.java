package com.tcs.service;

import java.sql.SQLException;

import com.tcs.domain.Order;
import com.tcs.exception.BOException;
import com.tcs.repositories.OrderDAO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderdao;

	
	public OrderServiceImpl(OrderDAO orderdao) {
		super();
		this.orderdao = orderdao;
	}

	@Override
	public boolean placeOrder(Order order) {
		try {
			int result = orderdao.create(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException("Items are not available");
		}

		return true;
	}

	@Override
	public boolean cancelOrder(int id) {
		try {
			Order order = orderdao.read(id);
			order.setStatus("Order Cancelled");
			int updatedItem = orderdao.update(order);
			if (updatedItem == 0) {
				return false;
			}

		} catch (SQLException e) {
			throw new BOException("no data found");
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) {
		try {
			int result = orderdao.delete(id);
			if (result == 0) {
				return false;
			}

		} catch (SQLException e) {
			throw new BOException("no data found");

		}
		return true;
	}

}
