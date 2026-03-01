package test.persistenciacascada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Contacto;
import model.Domicilio;
import model.Alumno;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();

        // Creamos un objeto Domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Allende");
        domicilio.setNoExterno("115");
        domicilio.setNoInterno("A-101");
        domicilio.setVersion(0);
        domicilio.setDeleted(0);

        // Creamos un objeto Contacto
        Contacto contacto = new Contacto();
        contacto.setTelefono("55717189");
        contacto.setEmail1("contacto@mail.com");
        contacto.setVersion(0);
        contacto.setDeleted(0);

        // Creamos un objeto Alumno (tiene varios valores requeridos, ej.
        // id_domicilio y id_contacto)
        Alumno alumno = new Alumno();
        alumno.setNombre("Martha");
        alumno.setApellidoPaterno("Martinez");
        alumno.setApellidoMaterno("Garcia");
        //Agregamos las relaciones y su persistencia en cascada
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        alumno.setVersion(0);
        alumno.setDeleted(0);

        try {
            em.getTransaction().begin();
            //Solo persistimos el alumno, y se agregan en automatico 
            //las relaciones asociadas marcadas como persistencia en cascada
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        // Objetos insertados
        System.out.println("Alumno insertado:" + alumno);
    }
}