package com.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.model.Response;
import com.colegio.service.DocumentosService;


@RestController
@RequestMapping("/documentos")
public class DocumentosController {
	
	@Autowired
	DocumentosService documentosService;
	
	@GetMapping("/obtener")
	public ResponseEntity<Response> obtener() {
		return documentosService.obtenerDocs();
	}
}
