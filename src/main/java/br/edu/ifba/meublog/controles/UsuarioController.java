package br.edu.ifba.meublog.controles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.meublog.entidades.Usuario;
import br.edu.ifba.meublog.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}


	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
/*

	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	*/
	@PostMapping
	public List<Usuario> cadastrar(@RequestBody List<Usuario> usuarios) {
		this.usuarioRepository.saveAllAndFlush(usuarios);
		return usuarios;
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return this.usuarioRepository.findAll();
	}
	
	@GetMapping("/buscarPorNome")
	public List<Usuario> buscarPorNome(@RequestParam String nome) {
	    return this.usuarioRepository.findByNomeContainingIgnoreCase(nome);
	}

	
	
	
}
