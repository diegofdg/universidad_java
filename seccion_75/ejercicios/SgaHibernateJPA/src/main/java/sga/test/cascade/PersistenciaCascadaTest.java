package sga.test.cascade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sga.domain.Alumno;
import sga.domain.Contacto;
import sga.domain.Domicilio;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        // Crear EntityManager y Factory con try-with-resources
        try (
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager()
        ) {
            // Crear objetos dependientes
            Domicilio domicilio = new Domicilio();
            domicilio.setCalle("Nogales");
            domicilio.setNoCalle("10");
            domicilio.setPais("México");

            Contacto contacto = new Contacto();
            contacto.setEmail("clara@mail.com");
            contacto.setTelefono("44332211");

            // Crear entidad principal
            Alumno alumno = new Alumno();
            alumno.setNombre("Carlos");
            alumno.setApellido("Lara");
            alumno.setDomicilio(domicilio); // Relación uno a uno con cascade
            alumno.setContacto(contacto);   // Relación uno a uno con cascade

            // Persistir con manejo adecuado de la transacción
            try {
                em.getTransaction().begin();
                em.persist(alumno); // Hibernate se encarga de persistir en cascada
                em.getTransaction().commit();
                System.out.println("Alumno persistido correctamente: " + alumno);
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println("Error al persistir el alumno: " + e.getMessage());
            }

        } catch (Exception ex) {
            System.err.println("Error al inicializar EntityManager: " + ex.getMessage());
        }
    }
}
