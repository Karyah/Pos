package br.com.fiap.usuarios_pettech.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.usuarios_pettech.dto.UsuarioDTO;
import br.com.fiap.usuarios_pettech.entities.Usuario;
import br.com.fiap.usuarios_pettech.repository.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CriacaoUsuarioValidator implements ConstraintValidator<CriacaoUsuarioValid, UsuarioDTO>{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(CriacaoUsuarioValid annotation) {
		
	}
	
	@Override
	public boolean isValid(UsuarioDTO dto, ConstraintValidatorContext context) {
		Optional<Usuario> usuario =  repository.findByEmail(dto.email());
		return usuario.isEmpty();
	}
}
