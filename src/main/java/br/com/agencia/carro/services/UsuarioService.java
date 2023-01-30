package br.com.agencia.carro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.carro.models.Usuario;
import br.com.agencia.carro.repositories.UsuarioRepository;




@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository _usuarioRepository;
	
	public List<Usuario> getAll(){
		return _usuarioRepository.findAll();
}
	
	
	public Optional<Usuario> getOne(String placa){
		return _usuarioRepository.findById(placa);
		
		}
	
	
	public void save(Usuario usuario) {
		_usuarioRepository.save(usuario);
	}
	
	public void update(Usuario usuario) {
		if(this.getOne(usuario.getPlaca()).isPresent()){
			_usuarioRepository.save(usuario);
		}
	}
	
	public void delete(String Placa) {
		_usuarioRepository.deleteById(Placa);
	}
	
	
}





