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

import com.colegio.model.Materia;



@Service
public class MateriaDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${StoredProcedures.insertMateria}")
	private String iMateria;
	
	@Value("${StoredProcedures.updateMateria}")
	private String uMateria;
	
	@Value("${StoredProcedures.deleteMateria}")
	private String dMateria;
	
	@Value("${StoredProcedures.selectMateria}")
	private String sMateria;
	
	

	public List<Materia> insertMateria(Materia materia) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Materia> rowMapper = new BeanPropertyRowMapper<>(Materia.class);
		List<Materia> list = null;
		try {
			
			params.addValue("p_nombre", materia.getNombre());
			params.addValue("p_descripcion", materia.getDescripcion());
			
			list = this.jdbcTemplate.query(iMateria, params, rowMapper);
			

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

	public List<Materia> updateMateria(Materia materia) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Materia> rowMapper = new BeanPropertyRowMapper<>(Materia.class);
		List<Materia> list = null;
		try {
			
			params.addValue("p_id_materia", materia.getIdMateria());
			params.addValue("p_nombre", materia.getNombre());
			params.addValue("p_descripcion", materia.getDescripcion());
			
			list = this.jdbcTemplate.query(uMateria, params, rowMapper);
			

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

	public List<Materia> deleteMateria(Materia materia) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Materia> rowMapper = new BeanPropertyRowMapper<>(Materia.class);
		List<Materia> list = null;
		try {
			params.addValue("p_id_materia", materia.getIdMateria());
			list = this.jdbcTemplate.query(dMateria, params, rowMapper);
			
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

	public List<Materia> getMateria() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Materia> rowMapper = new BeanPropertyRowMapper<>(Materia.class);
		List<Materia> list = null;
		try {
			
			list = this.jdbcTemplate.query(sMateria, params, rowMapper);
			
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
