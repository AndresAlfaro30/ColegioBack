package com.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.model.Estudiante;
import com.colegio.model.Profesor;
import com.colegio.model.Response;
import com.colegio.service.EstudianteService;
import com.colegio.service.ProfesorService;





@RestController
@RequestMapping("/estudiante")
public class EstdianteController {
	
	@Autowired
	EstudianteService estudianteService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Response> registrar(@RequestBody Estudiante estudiante) {
		return estudianteService.registrarEstudiante(estudiante);
	}

	@PostMapping("/eliminar")
	public ResponseEntity<Response> eliminar(@RequestBody Estudiante estudiante) {
		return estudianteService.eliminarEstudiante(estudiante);
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<Response> obtener() {
		return estudianteService.obtenerEstudiantes();
	}
}
