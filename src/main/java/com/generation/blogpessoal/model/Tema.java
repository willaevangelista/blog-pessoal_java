package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity //indicação que isso é uma nova tabela no banco de dados
@Table(name="tb_temas") // indicar o nome dessa tabela no bando de dados
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// NotNull -> não permite passar o campo vazio
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema",
			cascade = CascadeType.REMOVE)
	/*
	 * fetch -> define a estrategia de busca e carregamento dos dados. 
	 * Tem tipo eager (traz tudo e é mais demoarda) e a lazy (que traz aos poucos e só o que foi pedido, sendo mais rápida)
	 * Cascade -> define como vai se comportar a tabela relacionada em 
	 * momentos de deletar dados
	 */
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	// Sem constructor nesse caso, pois não vamos passar informações/criação de menu - Dá para criar, mas não tem necessidade
	
	/*
	 * tornamos a postagem uma lista, pois podemos
	 * ter mais de uma postagem para o mesmo tema
	 * se colcassemos private Postagem postagem; pois
	 * ficaraia uma relacao de 1 para 1, não de Vários para 1
	 */
	
	// Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
