package sga.dao;

import jakarta.persistence.*;
import sga.domain.Curso;

import java.util.List;

public class CursoDAO extends GenericDAO {

    public List<Curso> listar() {
        String jpql = "SELECT c FROM Curso c";
        return getEntityManager().createQuery(jpql, Curso.class).getResultList();
    }

    public Curso buscarPorId(Curso curso) {
        return getEntityManager().find(Curso.class, curso.getIdCurso());
    }

    public void insertar(Curso curso) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(curso);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al insertar curso", e);
        }
    }

    public void modificar(Curso curso) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(curso);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al modificar curso", e);
        }
    }

    public void eliminar(Curso curso) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(curso));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar curso", e);
        }
    }
}