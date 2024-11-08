package br.com.fiap.usuarios_pettech.dto;

import java.time.LocalDate;

import br.com.fiap.usuarios_pettech.service.validation.CriacaoUsuarioValid;

@CriacaoUsuarioValid(message = "Email já cadastrado.")
public record UsuarioDTO(
		Long id, String nome, String email, String cpf, LocalDate dataNascimento) {

}
