package com.fiap.springblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.repository.ArtigoRepository;
import com.fiap.springblog.service.ArtigoService;

@Service
public class ArtigoServiceImpl implements ArtigoService{

	@Autowired
	private ArtigoRepository artigoRepository;
	
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
		return this.artigoRepository.save(artigo);
	}

}
