package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActualizarObjetoJPA {
    
    private static final Logger log = LoggerFactory.getLogger(ActualizarObjetoJPA.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            //Paso 1. Iniciar una transaccion
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //Paso 2. Ejecuta SQL de tipo select
            //El id proporcionado debe existir en la base de datos
            Persona persona1 = em.find(Persona.class, 1);
            //Paso 3. termina la trasaccion 1
            tx.commit();
            //Objeto en estado detache
            log.info("Objeto recuperado:" + persona1);
            //Paso 4. setValue (nuevoValor)
            persona1.setApellido("Juarez");
            //Paso5. Inicia transaccion 2
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();
            //Paso 6. Modificamos el objeto
            em.merge(persona1);
            //flush - metodo intermedio para guardar cambios 
            //pendientes antes de terminar transaccion
            //em.flush() 
            //Paso 7. Termina transaccion 2
            tx2.commit();
            //objeto en estado detached ya modificado
            log.info("Objeto recuperado:" + persona1);
        }

    }
}
