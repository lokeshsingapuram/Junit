package com.tcs.repositories;

import java.sql.SQLException;

import com.tcs.domain.Order;

public class OrderDaoImpl implements OrderDAO{

	@Override
	public int create(Order order) throws SQLException {
		return 0;
	}

	@Override
	public Order read(Integer id) throws SQLException {
		return null;
	}

	@Override
	public int update(Order order) throws SQLException {
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException {
		return 0;
	}

}
