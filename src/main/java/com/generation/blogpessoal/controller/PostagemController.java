package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	// Localiza todas as postagens
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	// Localizar postagens por Id
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getByID(@PathVariable Long id) {
		//@PathVariable -> significa que o caminho id vai variar
		return postagemRepository.findById(id)
				// map -> pega tudo o que foi requisitado na linha anterior
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	// Localizar postagens por Título
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.
				findAllByTituloContainingIgnoreCase(titulo));
				//ContainingIgnoreCase -> ignora se letras estao em maiúsculo ou minúsculo. Ou seja, não diferencia entre "Willa" e "willa", retornando ambos.
		
	}
	
	// Inclusão de postagens
	@PostMapping
	public ResponseEntity<Postagem> port(@Valid @RequestBody Postagem postagem) {
		//@ Valid -> validação feita na model conforme especificações passadas anteriormente
		//@RequestBody -> indicando que teremos um corpo de requisição
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(postagemRepository.save(postagem));
	}
	
	// Atualização de postagens
	@PutMapping 
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT) // retorna caso meu metodo execute com sucesso o que esta sendo esperado
	@DeleteMapping("/{id}") // Exclusão de postagens
	public void delete(@PathVariable Long id) { // void -> nao retorna valor, por isso nao tem return
		//tratando e prevenindo erros do retorno da postagem que foi pesquisada no banco de dados
		Optional<Postagem> postagem = postagemRepository.findById(id);
		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		postagemRepository.deleteById(id);
	}

}
