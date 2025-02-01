package com.fiap.springblog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.springblog.model.Autor;

public interface AutorRepository extends MongoRepository<Autor, String>{

}
