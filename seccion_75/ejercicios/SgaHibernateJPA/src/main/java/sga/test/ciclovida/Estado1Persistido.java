package sga.test.ciclovida;

import jakarta.persistence.*;
import sga.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        try (
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager()
        ) {
            // 1️. Estado Transitivo (transient)
            var contacto = new Contacto();
            contacto.setEmail("clara");
            contacto.setTelefono("11223344");

            // 2️. Persistimos el objeto (estado managed)
            var tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(contacto);
                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) tx.rollback();
                throw new PersistenceException("Error al persistir contacto", e);
            }

            // 3️. Estado Detached (separado)
            System.out.println("Contacto persistido = " + contacto);
        }
    }
}
