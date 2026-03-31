package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EliminarObjetoJPA {
    
    private static final Logger log = LoggerFactory.getLogger(EliminarObjetoJPA.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");

        try (EntityManager em = emf.createEntityManager()) {
            // Paso 1: Iniciar la primera transacción
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Paso 2: Buscar el objeto a eliminar
            Persona persona1 = em.find(Persona.class, 4);

            // Paso 3: Finalizar la primera transacción
            tx.commit();

            // Validar si el objeto existe antes de intentar eliminarlo
            if (persona1 == null) {
                log.warn("El objeto con ID 4 no existe en la base de datos.");
                return;
            }

            log.info("Objeto encontrado: " + persona1);

            // Paso 4: Iniciar la segunda transacción
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();

            // Paso 5: Eliminar el objeto
            em.remove(em.contains(persona1) ? persona1 : em.merge(persona1));

            // Paso 6: Finalizar la segunda transacción
            tx2.commit();

            log.info("Objeto eliminado en estado de detached: " + persona1);
        }
    }
}
