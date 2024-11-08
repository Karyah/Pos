package br.com.fiap.usuarios_pettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.usuarios_pettech.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
