package br.com.fiap.msproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.msproduto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
