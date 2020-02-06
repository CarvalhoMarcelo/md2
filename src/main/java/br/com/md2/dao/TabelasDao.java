package br.com.md2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.md2.model.Autor;
import br.com.md2.model.Cliente;
import br.com.md2.model.Departamento;
import br.com.md2.model.Estado;
import br.com.md2.model.Livro;

@Repository
public class TabelasDao {
	@PersistenceContext
	private EntityManager entityManager;


	public String save(Estado estado)  {
		
//		List<Estado> estado1 = entityManager.createQuery("select e from Estado e where e.uf LIKE :estado")
//							.setParameter("estado", estado.getUf())
//							.getResultList();
		
		TypedQuery<Estado> minhaQuery = entityManager.createNamedQuery("findEstado", Estado.class)
				.setParameter("estado", estado.getUf());
		Estado uf = minhaQuery.getSingleResult();					
							
		if(uf.getUf().equals(estado.getUf())) {
			return "UF já existe no banco de dados!";
//			System.out.println("erro");
		}else {
			entityManager.persist(estado);
			return "Estado/Governador adicionado com sucesso!";
		}
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
	public void save(Autor autor) {
		entityManager.persist(autor);
	}
	
}
