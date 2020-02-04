package br.com.md2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	
	@ManyToMany	(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "Livro_Autor", 
		joinColumns = { @JoinColumn(name = "livro_id") },
		inverseJoinColumns = { @JoinColumn(name = "autor_id") }
	)
	private Set<Autor> autores = new HashSet<Autor>();
	
	/* Construtores */
	public Livro() {
	}
	public Livro(String titulo) {
		this.titulo = titulo;
	}
	
	/* Getters e Setters */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
}
