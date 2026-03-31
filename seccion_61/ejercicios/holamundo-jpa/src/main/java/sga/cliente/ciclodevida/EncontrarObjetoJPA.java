package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncontrarObjetoJPA {

     private static final Logger log = LoggerFactory.getLogger(EncontrarObjetoJPA.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
         //Inicia la transaccion
         //Paso 1. Iniciar una transaccion
         try (EntityManager em = emf.createEntityManager()) {
             //Inicia la transaccion
             //Paso 1. Iniciar una transaccion
             EntityTransaction tx = em.getTransaction();
             tx.begin();
             //Paso 2. Ejecuta SQL de tipo select
             Persona persona1 = em.find(Persona.class, 10);
             //Paso 3. termina la transaccion
             tx.commit();
             //Objeto en estado de detached
             log.info("Objeto recuperado en estado de detached: " + persona1);
             //Cerramos el entity manager
         }

    }
}
