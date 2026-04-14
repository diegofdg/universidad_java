package sga.test.ciclovida;

import jakarta.persistence.*;
import sga.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {

    public static void main(String[] args) {
        try (
            // Se crea la fábrica y el gestor de entidades (EntityManager)
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager()
        ) {
            // El objeto encontrado entra al estado PERSISTENTE al ser gestionado por el EntityManager
            int idContacto = 3;
            var contacto = em.find(Contacto.class, idContacto);

            // Aquí el EntityManager sigue abierto, por lo que `contacto` aún está en estado PERSISTENTE

            // Imprimimos el objeto recuperado
            System.out.println("Contacto recuperado = " + contacto);
        } catch (PersistenceException e) {
            System.err.println("Error al recuperar el contacto: " + e.getMessage());
        }
        // Una vez que se sale del bloque try-with-resources y se cierra el EntityManager,
        // el objeto `contacto` entra al estado DETACHED (ya no está gestionado por el EntityManager)
    }
}