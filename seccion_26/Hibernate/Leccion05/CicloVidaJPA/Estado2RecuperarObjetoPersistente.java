package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;

public class Estado2RecuperarObjetoPersistente {

    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();
        /**
         * Objetivo: Recuperar un objeto persistente con Hibernate apoyandonos de JPA
         */

        //Existen 2 maneras de realizar esta accion
        //1. Metodo get, regresa null si no encuentra el objeto
        Contacto contacto1 = null;

        try {
            em.getTransaction().begin();
            //Proporcionamos el ID a recuperar, en JPA se usa find en lugar de get
            contacto1 = (Contacto) em.find(Contacto.class, 2);
            System.out.println("Contacto recuperado con find:" + contacto1);
            em.getTransaction().commit(); //hacemos flush
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } 

        //El objeto de contacto1 cambia a edo. detached 
        //al cerrar la sesion
        //2. Metodo load, regresa ObjectNotFoundException 
        //si no encuentra el id proporcionado
        Contacto contacto2 = null;
        //Cramos una segunda transaccion
        try {
            em.getTransaction().begin();

            //Proporcionamos el id a recuperar, no levanta las relaciones (lazy)
            //En JPA tenemos getReference como otra opcion 
            contacto2 = (Contacto) em.getReference(Contacto.class, 2);
            System.out.println("Contacto recuperado con getReference:" + contacto2);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        //El objeto contacto2 cambia a edo. detached 
        //al cerrar la transaccion 2
    }
}