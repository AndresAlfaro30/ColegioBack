package com.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.model.Materia;
import com.colegio.model.Response;
import com.colegio.service.MateriaService;





@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	MateriaService materiaService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Response> consultar(@RequestBody Materia materia) {
		return materiaService.registrarMateria(materia);
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<Response> eliminar(@RequestBody Materia materia) {
		return materiaService.eliminarMateria(materia);
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<Response> obtener() {
		return materiaService.obtenerMaterias();
	}
}
