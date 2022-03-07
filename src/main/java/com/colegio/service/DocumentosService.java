package com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colegio.dao.DocumentosDAO;
import com.colegio.model.Documentos;
import com.colegio.model.Response;
import com.colegio.model.Result;

@Service
public class DocumentosService {
	
	@Autowired
	DocumentosDAO documentosDAO;
	
	public ResponseEntity<Response> obtenerDocs() {
		Response response = new Response();
		Result result = new Result();
		try {
							
				List<Documentos> docs = documentosDAO.getDocs();
				result.setCode("200");
				result.setDescription("Select exitoso.");
				response.setResult(result);
				response.setDatos(docs);
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
