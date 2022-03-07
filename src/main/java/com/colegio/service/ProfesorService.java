package com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colegio.dao.ProfesorDAO;
import com.colegio.model.Profesor;
import com.colegio.model.Response;
import com.colegio.model.Result;

@Service
public class ProfesorService {
	
	@Autowired
	ProfesorDAO profesorDAO;
	public ResponseEntity<Response> registrarProfesor(Profesor profesor) {
		Response response = new Response();
		Result result = new Result();
		try {
			
			if (profesor.getIdProfesor() == null ||profesor.getIdProfesor() == 0 ) {
				
				if (profesor.getEdad() < 18) {
					result.setCode("400");
					result.setDescription("El Profesor Debe Ser Mayor De Edad.");
					response.setResult(result);
					response.setDatos(null);
					return new ResponseEntity<Response>(response,HttpStatus.OK);
				}
				
				List<Profesor> profesorInsertado = profesorDAO.insertProfesor(profesor);
				result.setCode("200");
				result.setDescription("Registro Exitoso.");
				response.setResult(result);
				response.setDatos(profesorInsertado);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}else {
				if (profesor.getEdad() < 18) {
					result.setCode("400");
					result.setDescription("El Profesor Debe Ser Mayor De Edad.");
					response.setResult(result);
					response.setDatos(null);
					return new ResponseEntity<Response>(response,HttpStatus.OK);
				}
				
				List<Profesor> profesorModificado = profesorDAO.updateProfesor(profesor);
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
	public ResponseEntity<Response> eliminarProfesor(Profesor profesor) {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Profesor> profesorEliminado = profesorDAO.deleteProfesor(profesor);
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
	public ResponseEntity<Response> obtenerProfesores() {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Profesor> profesores = profesorDAO.getProfesores();
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
