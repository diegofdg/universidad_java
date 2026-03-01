package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Estado4ModificarObjetoSesionLarga {
    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();

        //Recuperamos un objeto persistente
        Contacto contacto = null;
        Session session = null;
        Transaction txt = null;
        try {
            session = em.unwrap(Session.class);
            txt = session.beginTransaction();
            //Identificador a recuperar
            contacto = (Contacto) session.get(Contacto.class, 1);
            System.out.println("Contacto sin modificar:" + contacto);
            //Modificamos el objeto en la misma transaccion
            contacto.setTelefono("55551111");
            txt.commit();
        } catch (Exception e) {
            txt.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        //Imprimimos los valores (estado detached)
        System.out.println("Contacto recuperado:" + contacto);
    }

}
