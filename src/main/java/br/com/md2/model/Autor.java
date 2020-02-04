package br.com.md2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "autores")
	private Set<Livro> livros = new HashSet<Livro>();
	
	/* Construtores */
	public Autor() {
	}
	public Autor(String nome) {
		this.nome = nome;
	}
	
	/* Getters e Setters */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
}
