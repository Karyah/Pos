package com.fiap.springblog.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fiap.springblog.model.Artigo;

public interface ArtigoRepository extends MongoRepository<Artigo, String>{ 
	
	public void deleteById(String codigo);
	
	public List<Artigo> findByStatusAndDataGreaterThan(Integer status, LocalDateTime data);
	
	// ?0 representa o primeiro parametro
	@Query("{ $and: [ {'data': {$gte: ?0}}, {'data': {$lte: ?1 }} ] }")
	public List<Artigo> obterArtigoPorDatHora(LocalDateTime dataDe, LocalDateTime dataAte);
	
	Page<Artigo> findAll(Pageable pageable);
	
	public List<Artigo> findByStatusOrderByTituloAsc(Integer status);
	
	@Query(value = "{'status': {$eq: ?0} }",sort = "{'titulo':1}" )
	public List<Artigo> obterArtigoPorStatusComOrdenacao(Integer status);
}
