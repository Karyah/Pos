package com.fiap.springblog.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/maiordata")
	public List<Artigo> findByDataGreaterThan(@RequestParam("data") LocalDateTime data){
		return artigoService.findByDataGreaterThan(data);
	}
	
	@GetMapping("/data-status")
	public List<Artigo> findByDataAndStatus
		(@RequestParam("data") LocalDateTime data, 
		 @RequestParam("status") Integer status){
		return artigoService.findByDataAndStatus(data, status);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Artigo artigo) {
		artigoService.atualizar(artigo);
	}
	
	@PutMapping("/{codigo}")
	public void atualizarArtigo(@PathVariable String codigo, @RequestBody String novaURL) {
		artigoService.atualizarArtigo(codigo, novaURL);
	}
	
	@DeleteMapping("/{codigo}")
	public void deleteArtigo(@PathVariable String codigo) {
		artigoService.deleteById(codigo);
		
	}
	
	@DeleteMapping("/delete	")
	public void deleteArtigoById(@RequestParam("codigo") String codigo) {
		artigoService.deleteArtigoById(codigo);
	}
	
	@GetMapping("/status-maiordata")
	public List<Artigo> findByStatusAndDataGreaterThan
			(@RequestParam("status") Integer status,
			@RequestParam("data") LocalDateTime data){
		return artigoService.findByStatusAndDataGreaterThan(status, data);
	}
	
	@GetMapping("/periodo")
	public List<Artigo> obterArtigoPorDatHora
			(@RequestParam("dataDe") LocalDateTime dataDe,
			 @RequestParam("dataAte") LocalDateTime dataAte){
		return artigoService.obterArtigoPorDatHora(dataDe, dataAte);
	}
	
	@GetMapping("/artigos-complexos")
	public List<Artigo> encontrarArtigosComplexos
			(@RequestParam("status") Integer status,
			@RequestParam("data") LocalDateTime data,
			@RequestParam("titulo") String titulo){
		return artigoService.encontrarArtigosComplexos(status, data, titulo);
		
	}
	
	@GetMapping("/pagina-artigos")
	public ResponseEntity<Page<Artigo>> listaArtigos(Pageable pageable){
		Page<Artigo> artigos =this.artigoService.findAll(pageable);
		return ResponseEntity.ok(artigos);
	} 
	
	@GetMapping("/status-ordenado")
	public List<Artigo> findByStatusOrderByTituloAsc(@RequestParam("status") Integer status){
		return this.artigoService.findByStatusOrderByTituloAsc(status);
	}
	
	@GetMapping("/status-query-ordenacao")
	public List<Artigo> obterArtigoPorStatusComOrdenacao(@RequestParam("status") Integer status) {
		return this.artigoService.obterArtigoPorStatusComOrdenacao(status);
	}
}
