package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActualizarObjetoSesionLarga {

     private static final Logger log = LoggerFactory.getLogger(ActualizarObjetoSesionLarga.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
         try (EntityManager em = emf.createEntityManager()) {
             //Paso 1. Iniciar una transaccion
             EntityTransaction tx = em.getTransaction();
             tx.begin();
             //Paso 2. ejecutamos SQL de tipo select
             Persona persona1 = em.find(Persona.class, 1);
             log.debug("Objecto encontrado:" + persona1);
             //Paso 3. setValue(nuevoValor)
             persona1.setEmail("r.juarez@mail.com");
             persona1.setEmail("rjuarez@mail.com");
             //Paso 4. Termina la transaccion 1
             tx.commit();
             //Objeto en estado detached
             log.info("objeto modificado estado detached:" + persona1);
         }
    }

}
