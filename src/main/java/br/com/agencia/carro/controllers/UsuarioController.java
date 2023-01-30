package br.com.agencia.carro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agencia.carro.models.Usuario;
import br.com.agencia.carro.services.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService _usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> usuarios = _usuarioService.getAll();
		return ResponseEntity.ok(usuarios);
		}

	@GetMapping(path="/{placa}")
	public ResponseEntity<Usuario> getOne(@PathVariable String placa){
		Optional<Usuario> usuario = _usuarioService.getOne(placa);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	
		}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Usuario usuario){
		_usuarioService.save(usuario);
		
		return ResponseEntity.ok("Usuario cadastro com sucesso.");
	}
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Usuario usuario){
		_usuarioService.update(usuario);
		return ResponseEntity.ok("Usuario atualizado com sucesso.");
	}
	@DeleteMapping(path="/{placa}")
	public ResponseEntity<String> delete(@PathVariable String placa){
		_usuarioService.delete(placa);
		return ResponseEntity.ok("Usuario removido com sucesso.");
		
	}
}
