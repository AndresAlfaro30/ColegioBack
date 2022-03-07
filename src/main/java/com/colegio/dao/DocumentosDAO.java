package com.colegio.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.colegio.model.Documentos;




@Service
public class DocumentosDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Value("${StoredProcedures.selectDocumentos}")
	private String sDocumentos;
	

	public List<Documentos> getDocs() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Documentos> rowMapper = new BeanPropertyRowMapper<>(Documentos.class);
		List<Documentos> list = null;
		try {
			
			list = this.jdbcTemplate.query(sDocumentos, params, rowMapper);
			
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				jdbcTemplate.getJdbcTemplate().getDataSource().getConnection().close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
