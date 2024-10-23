package br.com.fiap.pet_tech.pet_tech;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	//abastração da comunicacao com o banco de dados
}
