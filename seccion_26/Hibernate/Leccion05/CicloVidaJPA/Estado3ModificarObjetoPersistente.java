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
        try {
            em.getTransaction().begin();
            //Identificador a recuperar, también se puede usar merge para recuperar un objeto
            contacto = (Contacto) em.find(Contacto.class, 1);
            em.getTransaction().commit(); //hacemos flush
        } catch (Exception e) {
            em.getTransaction().rollback();
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
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit(); //hacemos flush
        } catch (Exception e) {
             em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        System.out.println("Objeto contacto modificado:" + contacto);
        //El objeto de contacto cambia a edo. detached al cerrar session
    }
}
