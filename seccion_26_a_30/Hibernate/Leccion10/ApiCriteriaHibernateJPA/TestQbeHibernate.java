package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Alumno;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class TestQbeHibernate {

    public static void main(String[] args) {
        /*Utilizamos la Unidad de Persistencia de JPA*/
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = fabrica.createEntityManager();

        //Variables de ayuda 
        Session s = em.unwrap(Session.class);
        List<Alumno> alumnos = null;
        Alumno alumno = null;

        // Query 1
        System.out.println("\nQuery 1");
        alumno = new Alumno();//Clase DTO o de Entidad
        alumno.setNombre("a");

        //Clase Example que envuelve al DTO
        Example example = Example.create(alumno).ignoreCase().enableLike(MatchMode.END);
        alumnos = s.createCriteria(Alumno.class)//Query by Criteria
                .add(example) //se filtra el query con el DTO envuelto en una clase Example
                .list();

        imprimirAlumnos(alumnos);
    }

    private static void imprimirAlumnos(List<Alumno> alumnos) {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
}
