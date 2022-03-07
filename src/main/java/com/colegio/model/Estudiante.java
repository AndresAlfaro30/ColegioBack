package com.colegio.model;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {
	
	private Integer idEstudiante;
	private String nombres;
	private String apellidos;
	private String tipoIdentificacion;
	private Integer numeroIdentificacion;
	private String correo;
	private Integer celular;
	private Integer edad;
	private Integer estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
}
