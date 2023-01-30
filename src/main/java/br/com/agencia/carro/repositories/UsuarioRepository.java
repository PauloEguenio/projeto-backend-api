package br.com.agencia.carro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.carro.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
