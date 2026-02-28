package test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import mx.com.gm.capadatos.PersonaDao;
import mx.com.gm.capadatos.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPersonaDaoImpl {

    private final Logger logger = LogManager.getRootLogger();

    @Autowired
    private PersonaDao personaDao;

    @Test
    @Transactional
    public void deberiaA_MostrarPersonas() {
        try {
            System.out.println();
            logger.info("Inicio del test deberiaMostrarPersonas");
            List<Persona> personas = personaDao.findAllPersonas();
            int contadorPersonas = 0;
            for (Persona persona : personas) {
                logger.info("Persona: " + persona);
                contadorPersonas++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertEquals(contadorPersonas, personaDao.contadorPersonas());
            logger.info("Fin del test deberiaMostrarPersonas");
        } catch (Exception e) {
            logger.error("Error JBDC", e);
        }
    }

    @Test
    @Transactional
    //Por default hace rollback al terminar
    public void deberiaB_EncontrarPersonaPorId() {
        try {
            System.out.println();
            logger.info("Inicio del test deberiaEncontrarPersonaPorId");
            //Debe ser un id_persona valido en la base de datos
            int idPersona = 1;
            Persona persona = personaDao.findPersonaById(idPersona);
            // Imprimimos todo el objeto
            logger.info("Persona recuperada (id=" + idPersona + "): " + persona);
            logger.info("Fin del test deberiaEncontrarPersonaPorId");
        } catch (Exception e) {
            logger.error("Error JBDC", e);
        }
    }

    @Test
    @Transactional
    @Commit 
    //Si queremos guardar cambios hacemos commit, por default hace rollback
    public void deberiaC_InsertarPersona() {
        try {
            System.out.println();
            logger.info("Inicio del test deberiaInsertarPersona");

            Persona persona = new Persona();
            persona.setNombre("Carlos");
            persona.setApePaterno("Romero");
            persona.setApeMaterno("Esparza");
            int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
            //Unique email
            persona.setEmail(randomNum + "carlos.romero@gmail.com");

            personaDao.insertPersona(persona);

            // Recuperamos a la persona recien insertada por su email
            persona = personaDao.getPersonaByEmail(persona);
            logger.info("Persona insertada: " + persona);

            logger.info("Fin del test deberiaInsertarPersona");
        } catch (Exception e) {
            logger.error("Error JBDC", e);
        }
    }

    @Test
    @Transactional
    @Commit
    //Por default hace rollback si no se especifica commit
    public void deberiaD_ActualizarPersona() {
        try {
            System.out.println();
            logger.info("Inicio del test deberiaActualizarPersona");
            //debe ser un idPersona valido en la base de datos
            int idPersona = 1;
            Persona persona = personaDao.findPersonaById(idPersona);
            logger.info("Persona a modificar (id=" + idPersona + "): " + persona);

            // Actualizamos el nombre y apeMaterno
            persona.setNombre("Administrador");
            persona.setApeMaterno("Sistemas");

            personaDao.updatePersona(persona);

            // Volvemos a leer el usuario
            persona = personaDao.findPersonaById(idPersona);

            // Imprimimos todo el objeto
            logger.info("Persona modificada (id=" + idPersona + "): " + persona);
            logger.info("Fin del test deberiaActualizarPersona");
        } catch (Exception e) {
            logger.error("Error JBDC", e);
        }
    }

    @Test
    @Transactional
    //@Commit
    //Por default hace rollback, si no se especifica commit
    public void deberiaE_EliminarPersona() {
        try {
            System.out.println();
            logger.info("Inicio del test deberiaEliminarPersona");
            // Debe ser un id valido a eliminar
            int idPersona = 2;
            Persona persona = personaDao.findPersonaById(idPersona);
            logger.info("Persona a eliminar (id=" + idPersona + "): " + persona);

            // Eliminamos la persona recuperada
            personaDao.deletePersona(persona);

            logger.info("Nuevo listado de personas:");
            List<Persona> personas = personaDao.findAllPersonas();
            int contadorPersonas = 0;
            for (Persona persona2 : personas) {
                logger.info("Persona: " + persona2);
                contadorPersonas++;
            }
            // Segun el numero de personas recuperadas, deberia ser el mismo de
            // la tabla
            assertEquals(contadorPersonas, personaDao.contadorPersonas());
            logger.info("Fin del test deberiaEliminarPersona");
            System.out.println();
        } catch (Exception e) {
            logger.error("Error JBDC", e);
        }
    }
}