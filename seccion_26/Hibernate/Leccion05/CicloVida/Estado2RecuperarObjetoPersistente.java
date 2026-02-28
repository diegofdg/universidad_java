package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

        Session session = null;
        Transaction txt = null;
        try {
            session = em.unwrap(Session.class);
            txt = session.beginTransaction();
            //Proporcionamos el ID a recuperar 
            contacto1 = (Contacto) session.get(Contacto.class, 2);
            System.out.println("Contacto recuperado con get:" + contacto1);
            txt.commit(); //hacemos flush
        } catch (Exception e) {
            txt.rollback();
            e.printStackTrace();
        } 

        //El objeto de contacto1 cambia a edo. detached 
        //al cerrar la sesion
        //2. Metodo load, regresa ObjectNotFoundException 
        //si no encuentra el id proporcionado
        Contacto contacto2 = null;
        //Cramos una segunda transaccion
        try {
            session = em.unwrap(Session.class);
            txt = session.beginTransaction();

            //Proporcionamos el id a recuperar
            contacto2 = (Contacto) session.load(Contacto.class, 2);
            System.out.println("Contacto recuperado con load:" + contacto2);
            txt.commit();
        } catch (Exception e) {
            txt.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        //El objeto contacto2 cambia a edo. detached 
        //al cerrar la transaccion 2
    }
}