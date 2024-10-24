package br.com.fiap.pet_tech.pet_tech.dto;

import java.util.UUID;


/*RECORD: feature do java 16 p lidar com estrturas imutaveis, para armazenar dados. classe normal especifica p armazenar dados, simplifica DTO*/
public record ProdutoDTO (
		
		UUID id, 
		
		String nome, 
		
		String descricao, 
		
		double preco,
		
		String urlDaImagem
){}
