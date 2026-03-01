package test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;

public class Estado4ModificarObjetoSesionLarga {

    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();

        //Recuperamos un objeto persistente
        Contacto contacto = null;

        try {
            em.getTransaction().begin();
            //Identificador a recuperar, también se puede usar merge para recuperar un objeto
            contacto = (Contacto) em.find(Contacto.class, 1);
            System.out.println("Contacto sin modificar:" + contacto);
            //Modificamos el objeto en la misma transaccion
            contacto.setTelefono("55551111");
            em.getTransaction().commit(); //hacemos flush
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        //Imprimimos los valores (estado detached)
        System.out.println("Contacto recuperado:" + contacto);
    }

}
