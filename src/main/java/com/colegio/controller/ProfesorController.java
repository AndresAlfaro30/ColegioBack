package com.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.model.Profesor;
import com.colegio.model.Response;
import com.colegio.service.ProfesorService;





@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	ProfesorService profesorService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Response> registrar(@RequestBody Profesor profesor) {
		return profesorService.registrarProfesor(profesor);
	}

	@PostMapping("/eliminar")
	public ResponseEntity<Response> eliminar(@RequestBody Profesor profesor) {
		return profesorService.eliminarProfesor(profesor);
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<Response> obtener() {
		return profesorService.obtenerProfesores();
	}
}
