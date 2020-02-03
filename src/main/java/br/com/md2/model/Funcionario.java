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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="nome_seq", allocationSize=1, initialValue=25)
    private Long func_id;

    @Column(length=50, nullable=false, unique=false)
    private String nome;

    @OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL)
    private List<FuncionarioTelefones> listaFuncTel;
        
    /**
     * @deprecated hibernate only
     */
    public Funcionario() {

    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

	public Long getFunc_id() {
		return func_id;
	}

	public void setFunc_id(Long func_id) {
		this.func_id = func_id;
	}

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
