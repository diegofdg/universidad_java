package sga.cliente;

import jakarta.persistence.*;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientePersona {
   private static final Logger logger = LoggerFactory.getLogger(ClientePersona.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
       try (EntityManager em = emf.createEntityManager()) {
           EntityTransaction tx = em.getTransaction();
           //Inicia la transaccion
           tx.begin();
           //No se debe especificar el ID de la base de datos
           Persona persona1 = new Persona("Pedro","Jaramillo","pjaramillo@mail.com","44556677");
           logger.info("Objeto a persistir: " + persona1);
           //System.out.println("Objeto a persistir:" + persona1);
           //Persistimos el objeto
           em.persist(persona1);
           //terminamos la transaccion
           tx.commit();
           logger.info("Objeto persistido: " + persona1);
           //System.out.println("Objeto a persistir:" + persona1);
       }
    }
}
