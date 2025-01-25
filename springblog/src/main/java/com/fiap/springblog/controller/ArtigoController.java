package com.fiap.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.service.ArtigoService;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoController {

	@Autowired
	private ArtigoService artigoService;
	
	@GetMapping
	public List<Artigo> obterTodos(){
		return artigoService.obterTodos();
	}
	
	@GetMapping("/{codigo}")
	public Artigo obterPorCodigoArtigo(@PathVariable String codigo) {
		return artigoService.obterPorCodigo(codigo);
	}
	
	@PostMapping
	public Artigo criar(@RequestBody Artigo artigo) {
		return artigoService.criar(artigo);
	}
}
