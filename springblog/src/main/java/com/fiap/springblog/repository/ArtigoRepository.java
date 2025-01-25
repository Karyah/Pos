package com.fiap.springblog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.springblog.model.Artigo;

public interface ArtigoRepository extends MongoRepository<Artigo, String>{

}
