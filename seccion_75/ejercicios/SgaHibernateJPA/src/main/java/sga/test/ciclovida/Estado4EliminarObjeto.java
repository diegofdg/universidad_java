package sga.test.ciclovida;

import jakarta.persistence.*;
import sga.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        // try-with-resources para cerrar correctamente EntityManagerFactory y EntityManager
        try (
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager()
        ) {
            // 1️. Recuperamos el objeto: queda en estado "persistent"
            Contacto contacto = em.find(Contacto.class, 3);

            if (contacto != null) {
                // 2️. Iniciamos transacción
                em.getTransaction().begin();

                // 3️. Eliminamos el objeto (como está gestionado, no se requiere merge)
                em.remove(contacto);

                // 4️. Confirmamos la transacción (se ejecuta el DELETE en la BD)
                em.getTransaction().commit();

                System.out.println("Contacto eliminado: " + contacto);
            } else {
                System.out.println("No se encontró un contacto con ID 3.");
            }

        } catch (Exception e) {
            System.err.println("Error al eliminar el contacto: " + e.getMessage());
        }
    }
}
