package com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colegio.dao.MateriaDAO;
import com.colegio.model.Materia;
import com.colegio.model.Response;
import com.colegio.model.Result;

@Service
public class MateriaService {
	
	@Autowired
	MateriaDAO materiaDAO;
	
	public ResponseEntity<Response> registrarMateria(Materia materia) {
		Response response = new Response();
		Result result = new Result();
		try {
			
			if (materia.getIdMateria() == null ||materia.getIdMateria() == 0 ) {
				
				
				
				List<Materia> materiaInsertada = materiaDAO.insertMateria(materia);
				result.setCode("200");
				result.setDescription("Insert exitoso.");
				response.setResult(result);
				response.setDatos(materiaInsertada);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}else {
			
				
				List<Materia> materiaModificada = materiaDAO.updateMateria(materia);
				result.setCode("200");
				result.setDescription("Insert exitoso.");
				response.setResult(result);
				response.setDatos(materiaModificada);
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
	public ResponseEntity<Response> eliminarMateria(Materia materia) {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Materia> materiaEliminada = materiaDAO.deleteMateria(materia);
				result.setCode("200");
				result.setDescription("Delete exitoso.");
				response.setResult(result);
				response.setDatos(materiaEliminada);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			
			
		} catch (Exception e) {
			result.setCode("400");
			result.setDescription("Error en el proceso.");
			response.setResult(result);
			response.setDatos(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}
	public ResponseEntity<Response> obtenerMaterias() {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Materia> materias = materiaDAO.getMateria();
				result.setCode("200");
				result.setDescription("Select exitoso.");
				response.setResult(result);
				response.setDatos(materias);
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
