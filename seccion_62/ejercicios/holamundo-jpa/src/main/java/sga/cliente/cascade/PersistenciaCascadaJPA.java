package sga.cliente.cascade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sga.domain.Persona;
import sga.domain.Usuario;

public class PersistenciaCascadaJPA {

    private static final Logger log = LoggerFactory.getLogger(PersistenciaCascadaJPA.class);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            
            // 1. Crear objeto Persona
            Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "55778822");
            
            // 2. Crear objeto Usuario relacionado con Persona
            Usuario usuario1 = new Usuario("hhernandez", "123", persona1);
            
            // 3. Persistir solo el Usuario (en automatico inserta la persona tambien)
            em.persist(usuario1);
            
            // 4. Confirmar transacción
            tx.commit();
            
            log.info("Persona guardada: " + persona1);
            log.info("Usuario guardado: " + usuario1);
        }
    }
}
