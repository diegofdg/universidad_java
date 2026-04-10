package gm.dao;

import gm.domain.Persona;
import jakarta.persistence.*;

import java.util.List;

public class PersonaDAO implements AutoCloseable {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public PersonaDAO() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public List<Persona> listar() {
        String hql = "SELECT p FROM Persona p";
        return em.createQuery(hql, Persona.class).getResultList();
    }

    public void imprimirPersonas() {
        listar().forEach(p -> System.out.println(" " + p));
    }

    public void insertar(Persona persona) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e; // se relanza la excepción para que la maneje el llamador si quiere
        }
    }

    public void modificar(Persona persona) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public Persona buscarPersonaPorId(Persona persona) {
        try {
            return em.find(Persona.class, persona.getIdPersona());
        } catch (Exception e) {
            throw new PersistenceException("Error al buscar persona por ID: " + persona.getIdPersona(), e);
        }
    }

    public void eliminar(Persona persona) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(persona));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar persona con ID: " + persona.getIdPersona(), e);
        }
    }

    @Override
    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
