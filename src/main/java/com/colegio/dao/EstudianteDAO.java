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

import com.colegio.model.Estudiante;
import com.colegio.model.Profesor;



@Service
public class EstudianteDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${StoredProcedures.insertEstudiante}")
	private String iEstudiante;
	
	@Value("${StoredProcedures.updateEstudiante}")
	private String uEstudiante;
	
	@Value("${StoredProcedures.deleteEstudiante}")
	private String dEstudiante;
	
	@Value("${StoredProcedures.selectEstudiante}")
	private String sEstudiante;
	
	public List<Estudiante> insertEstudiante(Estudiante estudiante) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Estudiante> rowMapper = new BeanPropertyRowMapper<>(Estudiante.class);
		List<Estudiante> list = null;
		try {
			
			params.addValue("p_nombres", estudiante.getNombres());
			params.addValue("p_apellidos", estudiante.getApellidos());
			params.addValue("p_tipo_identificacion", estudiante.getTipoIdentificacion());
			params.addValue("p_numero_identificacion", estudiante.getNumeroIdentificacion());
			params.addValue("p_correo", estudiante.getCorreo());
			params.addValue("p_celular", estudiante.getCelular());
			params.addValue("p_edad", estudiante.getEdad());
			list = this.jdbcTemplate.query(iEstudiante, params, rowMapper);
			

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

	public List<Estudiante> updateEstudiante(Estudiante estudiante) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Estudiante> rowMapper = new BeanPropertyRowMapper<>(Estudiante.class);
		List<Estudiante> list = null;
		try {
			params.addValue("p_id_estudiante", estudiante.getIdEstudiante());
			params.addValue("p_nombres", estudiante.getNombres());
			params.addValue("p_apellidos", estudiante.getApellidos());
			params.addValue("p_tipo_identificacion", estudiante.getTipoIdentificacion());
			params.addValue("p_numero_identificacion", estudiante.getNumeroIdentificacion());
			params.addValue("p_correo", estudiante.getCorreo());
			params.addValue("p_celular", estudiante.getCelular());
			params.addValue("p_edad", estudiante.getEdad());
			list = this.jdbcTemplate.query(uEstudiante, params, rowMapper);
			

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

	public List<Estudiante> deleteEstudiante(Estudiante estudiante) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Estudiante> rowMapper = new BeanPropertyRowMapper<>(Estudiante.class);
		List<Estudiante> list = null;
		try {
			params.addValue("p_id_estudiante", estudiante.getIdEstudiante());
			list = this.jdbcTemplate.query(dEstudiante, params, rowMapper);
			
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

	public List<Estudiante> getEstudiantes() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		RowMapper<Estudiante> rowMapper = new BeanPropertyRowMapper<>(Estudiante.class);
		List<Estudiante> list = null;
		try {
			
			list = this.jdbcTemplate.query(sEstudiante, params, rowMapper);
			
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
