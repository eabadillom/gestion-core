package com.ferbo.gestion.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class DAO {
	
	private static Logger log = LogManager.getLogger(DAO.class);
	
	/**Cierra un objeto de sentencia SQL PreparedStatement.
	 * @param ps Objeto PreparedStatement.
	 */
	public static void close(PreparedStatement ps){
		try{
			if(ps != null)
				ps.close();
			ps = null;
			log.debug("El objeto PreparedStatement se cerro satisfactoriamente.");
		} catch(SQLException ex) {
			log.error("Error al cerrar un PreparedStatement: ", ex);
		}
	}
	
	/**Cierra un objeto de sentencia SQL CallableStatement
	 * @param cs Objeto CallableStatement
	 */
	public static void close(CallableStatement cs){
		try{
			if(cs != null)
				cs.close();
			cs = null;
			log.debug("El objeto CallableStatement se cerro satisfactoriamente.");
		} catch(SQLException ex) {
			log.error("Error al cerrar un CallableStatement: ", ex);
		}
	}
	
	/**Cierra un objeto de datos ResultSet.
	 * @param rs Objeto ResultSet.
	 */
	public static void close(ResultSet rs){
		try{
			if(rs != null)
				rs.close();
			rs = null;
			log.debug("El objeto ResultSet se cerro satisfactoriamente");
		} catch(SQLException ex) {
			log.error("Error al cerrar un ResultSet: ", ex);
		}
	}
	
	
	public static synchronized String getTrim(String value) {
		String tmp = null;
		if(value != null)
			tmp = value.trim();
		return tmp;
	}
	
	public static synchronized String getString(ResultSet rs, String column)
	throws SQLException {
		return rs.getString(column);
	}
	
	public static synchronized void setString(PreparedStatement ps, int index, String value)
	throws SQLException{
		if(value == null)
			ps.setNull(index, Types.VARCHAR);
		else
			ps.setString(index, value.trim());
	}
	
	public static synchronized Date getDate(java.sql.Date value) {
		Date tmp = null;
		if(value != null)
			tmp = new Date(value.getTime());
		return tmp;
	}
	
	public static synchronized java.sql.Date getSqlDate(Date value) {
		java.sql.Date tmp = null;
		if(value != null)
			tmp = new java.sql.Date(value.getTime());
		
		return tmp;
	}
	
	public static synchronized void setSqlDate(PreparedStatement ps, int index, Date value)
	throws SQLException {
		
		if(value == null)
			ps.setNull(index, Types.DATE);
		else
			ps.setDate(index, new java.sql.Date(value.getTime()));
	}
	
	public static synchronized Instant getInstant(Timestamp value) {
		Instant tmp = null;
		if(value != null)
			tmp = value.toInstant();
		return tmp;
	}
	
	public static synchronized Timestamp getTimestamp(Instant value) {
		Timestamp tmp = null;
		if(value != null)
			tmp = Timestamp.from(value);
		
		return tmp;
	}
	
	public static synchronized LocalDate getLocalDate(ResultSet rs, String column)
	throws SQLException {
		return rs.getObject(column, LocalDate.class);
	}
	
	public static synchronized void setLocalDate(PreparedStatement ps, int index, LocalDate value)
	throws SQLException {
		if(value == null)
			ps.setNull(index, Types.DATE);
		else
			ps.setObject(index++, value);
	}
	
	public static synchronized Integer getInteger(ResultSet rs, String column)
	throws SQLException {
		Integer result = null;
		Integer iTmp = 0;
		iTmp = rs.getInt(column);
		if (!rs.wasNull()) {
			result = new Integer(iTmp);
		}
		return result;
	}
	
	public static synchronized void setInteger(PreparedStatement ps, int index, Integer value)
	throws SQLException {
		if(value == null)
			ps.setNull(index, Types.INTEGER);
		else
			ps.setInt(index, value);
	}
	
	public static synchronized void setInteger(CallableStatement ps, int index, Integer value)
    throws SQLException {
        if(value == null)
            ps.setNull(index, Types.INTEGER);
        else
            ps.setInt(index, value);
    }
	
	public static synchronized Boolean getBoolean(ResultSet rs, String column)
	throws SQLException {
		Boolean result = Boolean.FALSE;
		result = rs.getBoolean(column);
		if (rs.wasNull())
			return null;
		
		return result;
	}
	
	public static synchronized void setBoolean(PreparedStatement ps, int index, Boolean value)
	throws SQLException {
		if(value == null)
			ps.setNull(index, Types.BOOLEAN);
		else
			ps.setBoolean(index, value);
	}
}
