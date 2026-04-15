package sga.test.ciclovida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sga.domain.Contacto;

public class Estado3ModificarObjetoPersistente {

    public static void main(String[] args) {
        try (
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager()
        ) {
            // 1️. Objeto en estado "transient": se declara pero aún no tiene relación con la BD
            Contacto contacto;

            // 2️. Recuperamos un objeto existente: pasa automáticamente a estado "persistent"
            contacto = em.find(Contacto.class, 3);

            // Modificamos un campo (como está en estado "persistent", se sincroniza al hacer commit)
            contacto.setEmail("clara@mail.com");

            // Iniciamos transacción para sincronizar cambios
            em.getTransaction().begin();

            // 3️. Aquí el objeto sigue en estado "persistent", y se sincroniza automáticamente
            // El uso de merge sería innecesario aquí porque el objeto ya está gestionado
            // em.merge(contacto); // Solo si el objeto estuviera "detached"

            em.getTransaction().commit(); // Se guardan los cambios en la BD

            // 4️. Después del commit, el objeto pasa a estado "detached"
            System.out.println("Contacto modificado = " + contacto);
        } catch (Exception e) {
            System.err.println("Error al modificar el contacto: " + e.getMessage());
        }
    }
}
