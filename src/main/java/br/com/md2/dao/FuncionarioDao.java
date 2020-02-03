package br.com.md2.dao;

import org.springframework.stereotype.Repository;

import br.com.md2.model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FuncionarioDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Funcionario funcionario) {
        manager.persist(funcionario);
    }
}
