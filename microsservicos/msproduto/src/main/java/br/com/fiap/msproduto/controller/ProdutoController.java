package br.com.fiap.msproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.msproduto.model.Produto;
import br.com.fiap.msproduto.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listarProduto() {
		return produtoService.listarProduto();
	}
	
	@PostMapping
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		return produtoService.cadastrarProduto(produto);
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<?> consultarProduto(@PathVariable Integer produtoId){
		return produtoService.consultarProduto(produtoId);
	}
	
	@PutMapping("/{produtoId}")
	public Produto atualizarProduto(@PathVariable Integer produtoId, 
									@RequestBody Produto produto) {
		return produtoService.atualizarProduto(produtoId, produto);
	}
	
	@PutMapping("/atualizar/estoque/{produtoId}/{quantidade}")
	public Produto atualizarEstoque(@PathVariable Integer produtoId,
									@PathVariable int quantidade) {
		return produtoService.atualizarEstoque(produtoId, quantidade);
	}
	
	@DeleteMapping("/{produtoId}")
	public void excluirProduto(@PathVariable Integer produtoId) {
		produtoService.excluirProduto(produtoId);
	}
}
