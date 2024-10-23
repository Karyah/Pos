package br.com.fiap.pet_tech.pet_tech;

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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping 
	public ResponseEntity<Collection<Produto>> getAll() {
		var produtos = service.findAll();
		return ResponseEntity.ok(produtos);
		/* success status code - 200*/
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> findById(@PathVariable UUID id){
		var produto = service.findbyId(id);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		produto = service.save(produto);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produto);
		/*passar um status code personalizado, poderia ter sido também o método status*/
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable UUID id, @RequestBody Produto produto){
		produto = service.update(id, produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
