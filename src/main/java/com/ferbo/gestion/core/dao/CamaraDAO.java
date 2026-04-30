package com.ferbo.gestion.core.dao;

<<<<<<< Updated upstream
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ferbo.gestion.core.model.Camara;

public class CamaraDAO extends DAO implements IDAO<Camara> {
	
	private static final String SELECT = "select CAMARA_CVE, PLANTA_CVE, CAMARA_DS, CAMARA_ABREV from camara ";
	
	@Override
	public Camara getBean(ResultSet rs) throws SQLException {
		Camara bean = new Camara();
		bean.setIdCamara(getInteger(rs, "CAMARA_CVE"));
		bean.setIdPlanta(getInteger(rs, "PLANTA_CVE"));
		bean.setNombre(getTrim(rs.getString("CAMARA_DS")));
		bean.setAbreviatura(getTrim(rs.getString("CAMARA_ABREV")));
		return bean;
	}

	@Override
	public List<Camara> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Camara get(Connection conn, Object id) throws SQLException {
		Camara bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE CAMARA_CVE = ?";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, (Integer)id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				bean = this.getBean(rs);
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return bean;
	}

	@Override
	public int insert(Connection conn, Camara bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Camara bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, Camara bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
=======
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferbo.gestion.core.commons.dao.BaseDAO;
import com.ferbo.gestion.core.model.Camara;
import com.ferbo.gestion.core.model.Planta;
import com.ferbo.gestion.core.tools.JpaExecutor;

public class CamaraDAO extends BaseDAO<Camara, Integer> 
{
    private static Logger log = LogManager.getLogger(CamaraDAO.class);

    public CamaraDAO() {
        super(Camara.class);
    }

    public List<Camara> buscarPorPlanta(Planta p) 
    {
        return JpaExecutor.executeRead(em -> 
            em.createNamedQuery("Camara.findByPlanta", Camara.class)
            .setParameter("idPlanta", p.getId())
            .getResultList()
        );
    }
>>>>>>> Stashed changes

}
