package sga.dao;

import jakarta.persistence.*;
import sga.domain.Contacto;

import java.util.List;

public class ContactoDAO extends GenericDAO {

    public List<Contacto> listar() {
        String jpql = "SELECT c FROM Contacto c";
        return getEntityManager().createQuery(jpql, Contacto.class).getResultList();
    }

    public Contacto buscarPorId(Contacto contacto) {
        return getEntityManager().find(Contacto.class, contacto.getIdContacto());
    }

    public void insertar(Contacto contacto) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(contacto);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al insertar contacto", e);
        }
    }

    public void modificar(Contacto contacto) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(contacto);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al modificar contacto", e);
        }
    }

    public void eliminar(Contacto contacto) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(contacto));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar contacto", e);
        }
    }

    @Override
    public void close() {
        super.close(); // Llama al método close del GenericDAO
    }
}
