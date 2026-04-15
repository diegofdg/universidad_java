package sga.dao;

import jakarta.persistence.*;
import sga.domain.Asignacion;

import java.util.List;

public class AsignacionDAO extends GenericDAO {

    public List<Asignacion> listar() {
        String jpql = "SELECT a FROM Asignacion a";
        return getEntityManager().createQuery(jpql, Asignacion.class).getResultList();
    }

    public Asignacion buscarPorId(Asignacion asignacion) {
        return getEntityManager().find(Asignacion.class, asignacion.getIdAsignacion());
    }

    public void insertar(Asignacion asignacion) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(asignacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al insertar asignación", e);
        }
    }

    public void modificar(Asignacion asignacion) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(asignacion);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al modificar asignación", e);
        }
    }

    public void eliminar(Asignacion asignacion) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(asignacion));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar asignación", e);
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
