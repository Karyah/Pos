package com.fiap.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.springblog.model.Autor;
import com.fiap.springblog.service.AutorService;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@PostMapping
	public Autor criar(@RequestBody Autor autor) {
		return autorService.criar(autor);
	}
	
	@GetMapping("/{codigo}")
	public Autor obterPorCodigo(@PathVariable String codigo) {
		return autorService.obterPorCodigo(codigo);
	}
}
