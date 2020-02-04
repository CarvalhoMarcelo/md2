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
public class Funcionario {
    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="f_seq")
    @SequenceGenerator(name="f_seq", sequenceName="func_seq", allocationSize=1, initialValue=1)
    private Long func_id;

    @Column(length=50, nullable=false, unique=false)
    private String nome;

    @OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL)
    private List<FuncionarioTelefones> listaFuncTel;

    /* Construtores */
    public Funcionario() {
    }
    public Funcionario(String nome) {
        this.nome = nome;
    }

    /* Getters e Setter */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<FuncionarioTelefones> getListaFuncTel() {
		return listaFuncTel;
	}
	public void setListaFuncionarioTelefones(List<FuncionarioTelefones> listaFuncTel) {
		this.listaFuncTel = listaFuncTel;
	}
}
