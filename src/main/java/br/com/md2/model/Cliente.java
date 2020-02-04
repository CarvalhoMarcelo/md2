package br.com.md2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private Set<Pedido> pedido;

	/* Construtores */
	public Cliente() {
	}
	public Cliente(String nome) {
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
	public Set<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}
}
