package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.generation.BlogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}

//controller é a comunucação com o Client (postman, angular)
//crossorigin -> ele permite que aceita postagem de qualquer origem
//rest,request -> a rota a url
//autowired -> serviço do spring postagem e repository