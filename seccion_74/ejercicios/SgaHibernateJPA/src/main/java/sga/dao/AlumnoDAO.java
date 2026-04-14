package sga.dao;

import jakarta.persistence.*;
import sga.domain.Alumno;

import java.util.List;

public class AlumnoDAO extends GenericDAO {

    public List<Alumno> listar() {
        String jpql = "SELECT a FROM Alumno a";
        return getEntityManager().createQuery(jpql, Alumno.class).getResultList();
    }

    public Alumno buscarPorId(Alumno alumno) {
        return getEntityManager().find(Alumno.class, alumno.getIdAlumno());
    }

    public void insertar(Alumno alumno) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(alumno);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al insertar alumno", e);
        }
    }

    public void modificar(Alumno alumno) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(alumno);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al modificar alumno", e);
        }
    }

    public void eliminar(Alumno alumno) {
        var tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(alumno));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error al eliminar alumno", e);
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
