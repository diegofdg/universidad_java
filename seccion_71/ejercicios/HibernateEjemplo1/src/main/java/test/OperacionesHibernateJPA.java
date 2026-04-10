package test;

import gm.dao.PersonaDAO;
import gm.domain.Persona;

public class OperacionesHibernateJPA {

    public static void main(String[] args) {
        try (PersonaDAO personaDao = new PersonaDAO()) {
            // 1. Caso listar
            personaDao.imprimirPersonas();

            // 2. Caso insertar
            Persona persona = new Persona();
            persona.setNombre("Carlos");
            persona.setApellido("Lara");
            persona.setEmail("clara@mail.com");
            persona.setTelefono("55443322");

            //personaDao.insertar(persona);
            
            // 3. Caso actualizar
//            persona = new Persona();
//            persona.setIdPersona(6);
//
//            persona = personaDao.buscarPersonaPorId(persona);
//            System.out.println("persona encontrada = " + persona);
//
//            //persona.setNombre("Carlos");
//            persona.setApellido("Esparza");
//            persona.setEmail("cesparza@mail.com");
//            //persona.setTelefono("55443322");
//
//            personaDao.modificar(persona);
//            personaDao.imprimirPersonas();

            //4. Caso eliminar
            persona = new Persona();
            persona.setIdPersona(6);

            persona = personaDao.buscarPersonaPorId(persona);
            System.out.println("persona encontrada = " + persona);

            personaDao.eliminar(persona);
            personaDao.imprimirPersonas();
        }
    }
}
