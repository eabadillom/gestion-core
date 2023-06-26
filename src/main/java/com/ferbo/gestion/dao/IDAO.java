package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
	public T getBean(ResultSet rs) throws SQLException;
	
	public List<T> get(Connection conn) throws SQLException;
	
	public T get(Connection conn, Object id) throws SQLException;
	
	public int insert(Connection conn, T bean) throws SQLException;
	
	public int update(Connection conn, T bean) throws SQLException;
	
	public int delete(Connection conn, T bean) throws SQLException;
}
