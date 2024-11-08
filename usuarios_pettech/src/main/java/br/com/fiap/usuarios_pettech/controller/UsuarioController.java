package br.com.fiap.usuarios_pettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.usuarios_pettech.dto.UsuarioDTO;
import br.com.fiap.usuarios_pettech.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> findAll(
			@PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {
		Page<UsuarioDTO> usuariosDTO = service.findAll(pageable);
		return ResponseEntity.ok(usuariosDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
		UsuarioDTO usuarioDTO = service.findById(id);
		return ResponseEntity.ok(usuarioDTO);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		UsuarioDTO savedUsuario = service.save(usuarioDTO);
		return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO updatedUsuario = service.update(id, usuarioDTO);
		return ResponseEntity.ok(updatedUsuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
