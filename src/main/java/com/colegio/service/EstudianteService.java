package com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colegio.dao.EstudianteDAO;
import com.colegio.dao.ProfesorDAO;
import com.colegio.model.Estudiante;
import com.colegio.model.Profesor;
import com.colegio.model.Response;
import com.colegio.model.Result;

@Service
public class EstudianteService {
	
	@Autowired
	EstudianteDAO estudianteDAO;
	
	public ResponseEntity<Response> registrarEstudiante(Estudiante estudiante) {
		Response response = new Response();
		Result result = new Result();
		try {
			
			if (estudiante.getIdEstudiante()== null ||estudiante.getIdEstudiante() == 0 ) {
				
				
				List<Estudiante> profesorInsertado = estudianteDAO.insertEstudiante(estudiante);
				result.setCode("200");
				result.setDescription("Registro Exitoso.");
				response.setResult(result);
				response.setDatos(profesorInsertado);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}else {
				
				
				List<Estudiante> profesorModificado = estudianteDAO.updateEstudiante(estudiante);
				result.setCode("200");
				result.setDescription("Actualizacion Exitosa.");
				response.setResult(result);
				response.setDatos(profesorModificado);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}
			
		} catch (Exception e) {
			result.setCode("400");
			result.setDescription("Error en el proceso.");
			response.setResult(result);
			response.setDatos(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		
	}
	public ResponseEntity<Response> eliminarEstudiante(Estudiante estudiante) {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Estudiante> profesorEliminado = estudianteDAO.deleteEstudiante(estudiante);
				result.setCode("200");
				result.setDescription("Delete exitoso.");
				response.setResult(result);
				response.setDatos(profesorEliminado);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			
			
		} catch (Exception e) {
			result.setCode("400");
			result.setDescription("Error en el proceso.");
			response.setResult(result);
			response.setDatos(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}
	public ResponseEntity<Response> obtenerEstudiantes() {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Estudiante> profesores = estudianteDAO.getEstudiantes();
				result.setCode("200");
				result.setDescription("Delete exitoso.");
				response.setResult(result);
				response.setDatos(profesores);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
					
		} catch (Exception e) {
			result.setCode("400");
			result.setDescription("Error en el proceso.");
			response.setResult(result);
			response.setDatos(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}

}
