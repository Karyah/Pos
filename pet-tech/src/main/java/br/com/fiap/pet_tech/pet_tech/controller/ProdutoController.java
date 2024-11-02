package br.com.fiap.pet_tech.pet_tech.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pet_tech.pet_tech.dto.ProdutoDTO;
import br.com.fiap.pet_tech.pet_tech.entity.Produto;
import br.com.fiap.pet_tech.pet_tech.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping 
	public ResponseEntity<Collection<ProdutoDTO>> getAll() {
		var produtos = service.findAll();
		return ResponseEntity.ok(produtos);
		/* success status code - 200*/
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id){
		var produto = service.findbyId(id);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
		produtoDTO = service.save(produtoDTO);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produtoDTO);
		/*passar um status code personalizado, poderia ter sido também o método status*/
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable UUID id, @Valid @RequestBody ProdutoDTO produtoDTO){
		produtoDTO = service.update(id, produtoDTO);
		return ResponseEntity.ok(produtoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
