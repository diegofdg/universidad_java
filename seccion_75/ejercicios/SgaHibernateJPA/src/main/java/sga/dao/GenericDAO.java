package sga.dao;

import jakarta.persistence.*;

public abstract class GenericDAO implements AutoCloseable {

    protected final EntityManagerFactory emf;
    protected final EntityManager em;

    private static final String PU = "HibernateJpaPU";

    public GenericDAO() {
        this.emf = Persistence.createEntityManagerFactory(PU);
        this.em = emf.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        return this.em;
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
