package br.com.md2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="findEstado", query="select e from Estado e where e.uf LIKE :estado")
public class Estado {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(length=2, nullable=false, unique=true)
	private String uf;
	
	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="gov_id", referencedColumnName="id", nullable=false)
	private Governador governador;
	
	/* Construtores */
	public Estado() {
	}
	public Estado(String uf) {
		this.uf = uf;
	}

	/* Getters e Setters */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Governador getGovernador() {
		return governador;
	}
	public void setGovernador(Governador governador) {
		this.governador = governador;
	}
}
