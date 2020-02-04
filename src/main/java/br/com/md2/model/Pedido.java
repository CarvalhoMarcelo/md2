package br.com.md2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nrPedido;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", nullable=false)
	private Cliente cliente;

	/* Getters e Setters */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNrPedido() {
		return nrPedido;
	}
	public void setNrPedido(String nrPedido) {
		this.nrPedido = nrPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
