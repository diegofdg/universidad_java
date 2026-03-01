package test;

import static org.junit.Assert.*;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.PersonaService;
import mx.com.gm.sga.servicio.UsuarioService;
import org.junit.Before;
import org.junit.Test;

public class PersonaServiceTest {

    private PersonaService personaService;
    private UsuarioService usuarioService;

    EJBContainer contenedor;

    @Before
    public void setUp() throws Exception {
        contenedor = EJBContainer.createEJBContainer();
        System.out.println("Abriendo contenedor embebido Glassfish");
        personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService");
        usuarioService = (UsuarioService) contenedor.getContext().lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioService");
    }

    @Test
    public void testEJB() {
        this.testEJBPersonaService();
        this.testEJBUsuarioService();
    }
    
    private void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null);

        assertEquals(2, personaService.listarPersonas().size());

        System.out.println("El no. de personas es igual a:" + personaService.listarPersonas().size());

        this.desplegarPersonas(personaService.listarPersonas());
        System.out.println("Fin test EJB PersonaService");
    }

    private void testEJBUsuarioService() {
        System.out.println("Iniciando test EJB UsuarioService");
        assertTrue(usuarioService != null);

        assertEquals(1, usuarioService.listarUsuarios().size());

        System.out.println("El no. de usuarios es igual a:" + usuarioService.listarUsuarios().size());

        this.desplegarUsuarios(usuarioService.listarUsuarios());
        System.out.println("Fin test EJB UsuarioService");
    }

    private void desplegarUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    private void desplegarPersonas(List<Persona> personas) {

        for (Persona p : personas) {
            System.out.println(p);
        }
        //Esto genera un error ya que el servidor embebido no soporta Java 8
        //personas.forEach((persona) -> {
        //    System.out.println(persona);
        //});
    }
}
