package com.fiap.springblog.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.ArtigoRepository;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.ArtigoService;

@Service
public class ArtigoServiceImpl implements ArtigoService{

	@Autowired
	private ArtigoRepository artigoRepository;
	
	@Autowired 
	private AutorRepository autorRepository;
	
	private final MongoTemplate mongoTemplate;
	
	public ArtigoServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Artigo> obterTodos() {
		return this.artigoRepository.findAll();
	}

	@Override
	public Artigo obterPorCodigo(String codigo) {
		return this.artigoRepository.findById(codigo).orElseThrow(()->new IllegalArgumentException("Artigo não existe"));
	}

	@Override
	public Artigo criar(Artigo artigo) {
		if (artigo.getAutor().getCodigo() != null) {
			
			Autor autor = autorRepository.findById(artigo.getAutor().getCodigo())
					.orElseThrow(()-> new IllegalArgumentException("Autor inexistente"));
			artigo.setAutor(autor);
			
		}else {
			artigo.setAutor(null);
		}
		
		return this.artigoRepository.save(artigo);
	}

	@Override
	public List<Artigo> findByDataGreaterThan(LocalDateTime data) {
		Query query = new Query(Criteria.where("data").gt(data)); 
		return mongoTemplate.find(query, Artigo.class);
	}

	@Override
	public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status) {
		Query query = new Query
				(Criteria.where("data").is(data).and("status").is(status));
		return mongoTemplate.find(query, Artigo.class);
	}

	@Override
	public void atualizar(Artigo updateArtigo) {
		// O método save vai sobreescrever oq já existe o mudar oq foi pedido, ou criar um novo caso não exista
		artigoRepository.save(updateArtigo);
		
	}

	@Override
	public void atualizarArtigo(String codigo, String novaURL) {
		Query query = new Query(Criteria.where("_id").is(codigo));
		Update update = new Update().set("url", novaURL);
		
		mongoTemplate.updateFirst(query, update, Artigo.class);
		
	}

	@Override
	public void deleteById(String codigo) {
		this.artigoRepository.deleteById(codigo);
	}

	@Override
	public void deleteArtigoById(String codigo) {
		Query query = new Query(Criteria.where("_id").is(codigo));
		mongoTemplate.remove(query, Artigo.class);
		
	}
}
