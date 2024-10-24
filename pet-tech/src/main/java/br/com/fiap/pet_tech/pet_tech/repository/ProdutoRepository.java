package br.com.fiap.pet_tech.pet_tech.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.pet_tech.pet_tech.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	//abastração da comunicacao com o banco de dados
}
