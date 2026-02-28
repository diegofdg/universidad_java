package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;

public class Estado1Persistido {

    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();
        /**
         * Objetivo: Estado transivito a persistente
         */

        //1. Creamos el objeto (estado new o transitivo)
        Contacto contacto = new Contacto();
        contacto.setEmail1("email2@dominio.com");
        contacto.setVersion(0);
        contacto.setDeleted(0);

        //2. Persistimos el objeto (cambia de estado a persistente)
        //Iniciamos la transaccion
        //No utilizaremos las clases DAO en estos ejercicios
        try {
            // Iniciamos una transaccion
            em.getTransaction().begin();
            // Insertamos la nueva persona
            em.persist(contacto);
            // Terminamos la transaccion
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error al insetar objeto:" + ex.getMessage());
            // ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        //El objeto de contacto cambia de edo. persistente a detached 
        //al cerrar la sesion
        System.out.println("Nuevo contacto:" + contacto);
    }
}
