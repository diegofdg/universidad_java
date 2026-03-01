package mx.com.gm.sga.cliente.transacciones;

import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class PruebaManejoTransacciones {

    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
        System.out.println("Iniciando prueba Manejo Transaccional PersonaService");

        //Buscamos un objeto persona
        Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));

        //Cambiamos la persona
        persona1.setApellidoMaterno("Cambio con error....................................................................");
        //persona1.setApellidoMaterno("Cambio sin errror");

        personaService.modificarPersona(persona1);
        System.out.println("Objeto modificado:" + persona1);
        System.out.println("Fin prueba EJB PersonaService");
    }
}
