package br.com.md2.model;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Governador {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="uf_id", referencedColumnName="id")
	private Estado estado;

	/* Construtores */
	public Governador() {
	}
	public Governador(String nome) {
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
