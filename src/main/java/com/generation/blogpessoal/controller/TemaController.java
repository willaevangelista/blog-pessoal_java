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

import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.repository.TemaRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	// Localiza todas os temas
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){ // Entity - representa uma entidade no banco de dados, em que o JPA entende que essa classe deve ser mapeada para uma tabela no banco de dados.
		return ResponseEntity.ok(temaRepository.findAll());
	}
		
	// Localizar temas por Id
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getByID(@PathVariable Long id) {
		//@PathVariable -> significa que o caminho id vai variar
		return temaRepository.findById(id)
				// map -> pega tudo o que foi requisitado na linha anterior
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	// Localizar postagens por descricao
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByTitle(@PathVariable String descricao) {
		return ResponseEntity.ok(temaRepository.
			findAllByDescricaoContainingIgnoreCase(descricao));
			//ContainingIgnoreCase -> ignora se letras estao em maiúsculo ou minúsculo. Ou seja, não diferencia entre "Willa" e "willa", retornando ambos.
			
	}
	
	// Inclusão de temas
	@PostMapping
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema) {
		//@ Valid -> validação feita na model conforme especificações passadas anteriormente
		//@RequestBody -> indicando que teremos um corpo de requisição
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(temaRepository.save(tema));
	}
		
	// Atualização de temas
	@PutMapping 
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
		return temaRepository.findById(tema.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
						.body(temaRepository.save(tema)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
		
		
	@ResponseStatus(HttpStatus.NO_CONTENT) // retorna caso meu metodo execute com sucesso o que esta sendo esperado
	@DeleteMapping("/{id}") // Exclusão de postagens
	public void delete(@PathVariable Long id) { // void -> nao retorna valor, por isso nao tem return
		//tratando e prevenindo erros do retorno da postagem que foi pesquisada no banco de dados
		Optional<Tema> tema = temaRepository.findById(id);
		if (tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		temaRepository.deleteById(id);
	}

}
