package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import jakarta.xml.ws.BindingProvider;
import java.util.List;

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWs servicio = new PersonaServiceImplService().getPersonaServiceImplPort();

        BindingProvider proveedor = (BindingProvider) servicio;
        proveedor.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        proveedor.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

        System.out.println("Ejecutando servicio listar personas...");
        List<Persona> personas = servicio.listarPersonas();

        personas.forEach(p -> System.out.println(
            "Id: " + p.getIdPersona() + ", nombre: " + p.getNombre() +
            ", apellido: " + p.getApellido() + ", email: " + p.getEmail()
        ));

        System.out.println("Fin del servicio");
    }
}
