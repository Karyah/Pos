package br.com.organicxpto.estoque;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final ProdutoService produtoService;
	
	public Controller(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping("get-all")
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoService.getAll());
	}
	
	
}
