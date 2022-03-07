package com.colegio.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Materia {
	
	private Integer idMateria;
	private String nombre;
	private String descripcion;

	
}
