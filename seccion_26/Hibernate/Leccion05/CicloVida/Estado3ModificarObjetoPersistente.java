package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Estado3ModificarObjetoPersistente {

    public static void main(String[] args) {
         /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();
       
        /**
         * Objetivo: Modificar un objeto persistente (reattaching) Pasar de un
         * estado detached a persistente
         */

        //Recuperamos un objeto persistente
        Contacto contacto = null;
        Session session = null;
        Transaction txt = null;
        try {
            session = em.unwrap(Session.class);
            txt = session.beginTransaction();
            //Identificador a recuperar
            contacto = (Contacto) session.get(Contacto.class, 1);
            txt.commit();
        } catch (Exception e) {
            txt.rollback();
            e.printStackTrace();
        } 

        //Imprimimos los valores del objeto recuperado
        //estado detached
        System.out.println("Contacto recuperado:" + contacto);

        //Modificamos el objeto fuera de una transaccion
        contacto.setEmail2("emailModificado@mail.com");

        //Volvemos a guardar el objeto en una nueva transaccion
        //Cambiamos el estado de detached a persistente (reattaching)
        try {
            session = em.unwrap(Session.class);
            txt = session.beginTransaction();
            session.update(contacto);
            txt.commit();
        } catch (Exception e) {
            txt.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        System.out.println("Objeto contacto modificado:" + contacto);
        //El objeto de contacto cambia a edo. detached al cerrar session
    }
}
