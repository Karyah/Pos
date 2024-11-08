package br.com.fiap.usuarios_pettech.dto;

import java.time.LocalDate;

public record UsuarioDTO(

		Long id, String nome, String email, String cpf, LocalDate dataNascimento) {

}
