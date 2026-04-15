package sga.test;

import sga.dao.*;

public class TestDAOs {
    public static void main(String[] args) {
        try (
            var alumnoDao = new AlumnoDAO();
            var domicilioDao = new DomicilioDAO();
            var contactoDao = new ContactoDAO();
            var cursoDao = new CursoDAO();
            var asignacionDao = new AsignacionDAO()
        ) {
            System.out.println(" Alumnos:");
            alumnoDao.listar().forEach(alumno -> System.out.println(" " + alumno));

            System.out.println(" Domicilios:");
            domicilioDao.listar().forEach(d -> System.out.println(" " + d));

            System.out.println(" Contactos:");
            contactoDao.listar().forEach(c -> System.out.println(" " + c));

            System.out.println(" Cursos:");
            cursoDao.listar().forEach(curso -> System.out.println(" " + curso));

            System.out.println(" Asignaciones:");
            asignacionDao.listar().forEach(a -> System.out.println(" " + a));
        }
    }
}
