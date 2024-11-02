package br.com.fiap.api.usuarios_pettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.api.usuarios_pettech.controller.exception.ControllerNotFoundException;
import br.com.fiap.api.usuarios_pettech.dto.UsuarioDTO;
import br.com.fiap.api.usuarios_pettech.entities.Usuario;
import br.com.fiap.api.usuarios_pettech.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Page<UsuarioDTO> findAll(Pageable pageable) {
		Page<Usuario> usuarios = repository.findAll(pageable);
		return usuarios.map(this::toDTO);
	}

	public UsuarioDTO findById(Long id) {
		Usuario usuario = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Usário não encontrado"));
		return toDTO(usuario);
	}

	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = toEntity(usuarioDTO);
		usuario = repository.save(usuario);
		return toDTO(usuario);
	}

	public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = repository.getReferenceById(id);

			usuario.setNome(usuarioDTO.nome());
			usuario.setCpf(usuarioDTO.cpf());
			usuario.setEmail(usuarioDTO.email());
			usuario.setDataNascimento(usuarioDTO.dataNascimento());

			usuario = repository.save(usuario);
			return toDTO(usuario);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Usuário não encontrado");
		}
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	private UsuarioDTO toDTO(Usuario usuario) {
		return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(),
				usuario.getDataNascimento());
	}

	private Usuario toEntity(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.id(), usuarioDTO.nome(), usuarioDTO.email(), usuarioDTO.cpf(),
				usuarioDTO.dataNascimento());
	}

}
