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
public class Documentos {
	
	private Integer idDocumento;
	private String nombre;

	
}
