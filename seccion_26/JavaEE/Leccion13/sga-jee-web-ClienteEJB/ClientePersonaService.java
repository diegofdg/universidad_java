package prueba;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

    public static void main(String[] args) {

        System.out.println("Iniciando llamada al EJB desde el cliente\n");

        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        programmaticLogin.login("admin", "admin".toCharArray());

        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");

            List<Persona> personas = personaService.listarPersonas();

            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\nFin llamada al EJB desde el cliente");
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
