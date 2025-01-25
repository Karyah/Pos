package com.fiap.springblog.service;

import java.util.List;

import com.fiap.springblog.model.Artigo;

public interface ArtigoService {

	public List<Artigo> obterTodos();
	public Artigo obterPorCodigo(String codigo);
	public Artigo criar(Artigo artigo);
}
