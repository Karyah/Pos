package com.fiap.springblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public Autor criar(Autor autor) {
		return repository.save(autor);
	}

	@Override
	public Autor obterPorCodigo(String codigo) {
		return repository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Autor não existe"));
	}

}
