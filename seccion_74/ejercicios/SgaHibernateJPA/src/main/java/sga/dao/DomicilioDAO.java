package sga.dao;

import jakarta.persistence.*;
import sga.domain.Domicilio;

import java.util.List;

public class DomicilioDAO extends GenericDAO {

    public List<Domicilio> listar() {
        String jpql = "SELECT d FROM Domicilio d";
        return getEntityManager().createQuery(jpql, Domicilio.class).getResultList();
    }

    public Domicilio buscarPorId(Domicilio domicilio) {
        return getEntityManager().find(Domicilio.class, domicilio.getIdDomicilio());
    }

    public void insertar(Domicilio domicilio) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(domicilio);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al insertar domicilio", e);
        }
    }

    public void modificar(Domicilio domicilio) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(domicilio);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al modificar domicilio", e);
        }
    }

    public void eliminar(Domicilio domicilio) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(domicilio));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar domicilio", e);
        }
    }

    @Override
    public void close() {
        super.close(); // Llama al cierre definido en GenericDAO
    }
}
