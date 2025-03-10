package com.fiap.springblog.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document 
@Data
public class Artigo {

	@Id
	private String codigo;
	
	//Referencia de uma collection dentro de outra
	@DBRef
	private Autor autor;
	private String titulo;
	private LocalDateTime data;
	@TextIndexed
	private String texto;
	private String url;
	private Integer status;
	
}
