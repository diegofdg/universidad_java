package sga.cliente.ciclodevida;

import jakarta.persistence.*;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistirObjetoJPA {
    
    private static final Logger log = LoggerFactory.getLogger(PersistirObjetoJPA.class);
    
    public static void main(String[] args) {
        System.out.println("comenzando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            //Inicia la transaccion
            
            //Paso 1. Crea nuevo objeto
            //Objeto en estado transitivo
            Persona persona1 = new Persona("Pedro", "Luna", "pluna@mail.com", "13135566");
            //Paso 2. Inicia transaccion
            tx.begin();
            //Paso 3. Ejecuta SQL
            em.persist( persona1 );
            log.info("Objeto persistido - aun sin commit:" + persona1);
            //Paso 4. commit/rollback
            tx.commit();
            //Objeto en estado detached
            log.info("Objeto persistido - estado detached:" + persona1);
            //Cerramos el entity manager
        }
        
    }
    
}
