package com.ferbo.gestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferbo.gestion.model.DetallePartida;

public class DetallePartidaDAO extends DAO implements IDAO<DetallePartida> {
	
	private static final String SELECT = "select DET_PART_CVE, PARTIDA_CVE, tipo_mov_cve, edo_inv_cve, det_anterior, det_part_anterior, det_padre, det_part_padre, cantidad_u_manejo, u_medida_cve, cantidad_u_medida, dtp_codigo, dtp_lote, dtp_caducidad, dtp_PO, dtp_MP, dtp_pedimento, dtp_SAP, dtp_tarimas from DETALLE_PARTIDA ";

	@Override
	public DetallePartida getBean(ResultSet rs) throws SQLException {
		DetallePartida bean = new DetallePartida();
		bean.setIdDetallePartida(getInteger(rs, "DET_PART_CVE"));
		bean.setIdPartida(getInteger(rs, "PARTIDA_CVE"));
		bean.setIdTipoMovimiento(getInteger(rs, "tipo_mov_cve"));
		bean.setIdEstadoMovimiento(getInteger(rs, "edo_inv_cve"));
		bean.setIdDetalleAnterior(getInteger(rs, "det_anterior"));
		bean.setIdPartidaAnterior(getInteger(rs, "det_part_anterior"));
		bean.setIdDetallePadre(getInteger(rs, "det_padre"));
		bean.setIdPartidaPadre(getInteger(rs, "det_part_padre"));
		bean.setCantidad(getInteger(rs, "cantidad_u_manejo"));
		bean.setIdUnidadMedida(getInteger(rs, "u_medida_cve"));
		bean.setPeso(rs.getBigDecimal("cantidad_u_medida"));
		bean.setCodigo(getTrim(rs.getString("dtp_codigo")));
		bean.setLote(getTrim(rs.getString("dtp_lote")));
		bean.setCaducidad(rs.getDate("dtp_caducidad"));
		bean.setPo(getTrim(rs.getString("dtp_PO")));
		bean.setMp(getTrim(rs.getString("dtp_MP")));
		bean.setPedimento(getTrim(rs.getString("dtp_pedimento")));
		bean.setSap(getTrim(rs.getString("dtp_SAP")));
		bean.setTarimas(getTrim(rs.getString("dtp_tarimas")));
		return bean;
	}

	@Override
	public List<DetallePartida> get(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DetallePartida> getByIdPartida(Connection conn, Integer idPartida) throws SQLException {
		List<DetallePartida> list = null;
		DetallePartida bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int idx = 1;
		
		try {
			sql = SELECT + "WHERE PARTIDA_CVE = ? ";
			ps = conn.prepareStatement(sql);
			setInteger(ps, idx++, idPartida);
			
			rs = ps.executeQuery();
			list = new ArrayList<DetallePartida>();
			while(rs.next()) {
				bean = getBean(rs);
				list.add(bean);
			}
			
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	@Override
	public DetallePartida get(Connection conn, Object id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, DetallePartida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, DetallePartida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, DetallePartida bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
