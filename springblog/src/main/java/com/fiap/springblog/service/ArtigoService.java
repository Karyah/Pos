package com.fiap.springblog.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fiap.springblog.model.Artigo;

public interface ArtigoService {

	public List<Artigo> obterTodos();
	
	public Artigo obterPorCodigo(String codigo);
	
	public Artigo criar(Artigo artigo);
	
	public List<Artigo> findByDataGreaterThan(LocalDateTime data);
	
	public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status);
	
	public void atualizar(Artigo updateArtigo);
	
	public void atualizarArtigo(String codigo, String novaURL);
	
	public void deleteById(String codigo);
	
	public void deleteArtigoById(String codigo);
	
	public List<Artigo> findByStatusAndDataGreaterThan(Integer status, LocalDateTime data);
	
	public List<Artigo> obterArtigoPorDatHora(LocalDateTime dataDe, LocalDateTime dataAte);
	
	public List<Artigo> encontrarArtigosComplexos(Integer status, LocalDateTime data, String titulo);
}
