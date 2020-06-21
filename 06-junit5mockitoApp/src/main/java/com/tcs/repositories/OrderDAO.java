package com.tcs.repositories;

import java.sql.SQLException;

import com.tcs.domain.Order;

public interface OrderDAO {
	
	int create(Order order) throws SQLException;
	Order read(Integer id) throws SQLException;
	int update(Order order)throws SQLException;
	int delete(int id)throws SQLException;
	

}
