package br.com.md2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Departamento {
    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dpto")
    @SequenceGenerator(name="dpto", sequenceName="dpto_seq", allocationSize=1, initialValue=1)
    private Long dep_id;

    @Column(length=50, nullable=false, unique=false)
    private String departamento;

    @OneToMany(mappedBy="departamento", cascade=CascadeType.ALL)
    private List<Funcionarios> listaFuncionarios;

    /* Construtores */
    public Departamento() {
    }
    public Departamento(String departamento) {
    	this.departamento = departamento;
    }
    
    /* Getters e Setters */
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public List<Funcionarios> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public void setListaFuncionarios(List<Funcionarios> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
}
