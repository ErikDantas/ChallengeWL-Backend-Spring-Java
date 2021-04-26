package br.challengwl.challengewl.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.challengwl.challengewl.Model.Colaborador;

@Service
public class NativeScriptQueries {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void execute (String sql){
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Colaborador> getAllColaboradores(String sql) {
        Query q = entityManager.createNativeQuery(sql, Colaborador.class);
        List<Colaborador> colaboradores = q.getResultList();
        return colaboradores;
    }
}
