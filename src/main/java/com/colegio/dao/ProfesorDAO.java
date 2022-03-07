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

import com.colegio.model.Profesor;



@Service
public class ProfesorDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${StoredProcedures.insertProfesor}")
	private String iProfesor;
	
	@Value("${StoredProcedures.updateProfesor}")
	private String uProfesor;
	
	@Value("${StoredProcedures.deleteProfesor}")
	private String dProfesor;
	
	@Value("${StoredProcedures.selectProfesor}")
	private String sProfesor;
	
	public List<Profesor> insertProfesor(Profesor profesor) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Profesor> rowMapper = new BeanPropertyRowMapper<>(Profesor.class);
		List<Profesor> list = null;
		try {
			
			params.addValue("p_nombres", profesor.getNombres());
			params.addValue("p_apellidos", profesor.getApellidos());
			params.addValue("p_tipo_identificacion", profesor.getTipoIdentificacion());
			params.addValue("p_numero_identificacion", profesor.getNumeroIdentificacion());
			params.addValue("p_correo", profesor.getCorreo());
			params.addValue("p_celular", profesor.getCelular());
			params.addValue("p_materia", profesor.getMateria());
			params.addValue("p_edad", profesor.getEdad());
			list = this.jdbcTemplate.query(iProfesor, params, rowMapper);
			

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

	public List<Profesor> updateProfesor(Profesor profesor) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Profesor> rowMapper = new BeanPropertyRowMapper<>(Profesor.class);
		List<Profesor> list = null;
		try {
			params.addValue("p_id_profesor", profesor.getIdProfesor());
			params.addValue("p_nombres", profesor.getNombres());
			params.addValue("p_apellidos", profesor.getApellidos());
			params.addValue("p_tipo_identificacion", profesor.getTipoIdentificacion());
			params.addValue("p_numero_identificacion", profesor.getNumeroIdentificacion());
			params.addValue("p_correo", profesor.getCorreo());
			params.addValue("p_celular", profesor.getCelular());
			params.addValue("p_materia", profesor.getMateria());
			params.addValue("p_edad", profesor.getEdad());
			list = this.jdbcTemplate.query(uProfesor, params, rowMapper);
			

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

	public List<Profesor> deleteProfesor(Profesor profesor) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Profesor> rowMapper = new BeanPropertyRowMapper<>(Profesor.class);
		List<Profesor> list = null;
		try {
			params.addValue("p_id_profesor", profesor.getIdProfesor());
			list = this.jdbcTemplate.query(dProfesor, params, rowMapper);
			
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

	public List<Profesor> getProfesores() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Profesor> rowMapper = new BeanPropertyRowMapper<>(Profesor.class);
		List<Profesor> list = null;
		try {
			
			list = this.jdbcTemplate.query(sProfesor, params, rowMapper);
			
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
