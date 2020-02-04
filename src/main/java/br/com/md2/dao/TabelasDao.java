package br.com.md2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.md2.model.Cliente;
import br.com.md2.model.Departamento;
import br.com.md2.model.Estado;
import br.com.md2.model.Livro;

@Repository
public class TabelasDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Estado estado) {
		entityManager.persist(estado);
	}
	
	public void save(Departamento departamento) {
		entityManager.persist(departamento);
	}
	
	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public void save(Livro livro) {
		entityManager.persist(livro);
	}
	
	
	
}
