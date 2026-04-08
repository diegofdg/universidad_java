package test;

import domain.Persona;
import java.util.List;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestPersonaServiceRS {
    
    //Variables que vamos a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
          HttpAuthenticationFeature feature = 
                HttpAuthenticationFeature.basicBuilder()
                        .nonPreemptive().credentials("admin", "admin").build();
        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client cliente = ClientBuilder.newClient(clientConfig);
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada:" + persona);
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>
        response = webTarget.request(MediaType.APPLICATION_XML).get();
        personas = response.readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas");
        personas.forEach(System.out::println);
        
        //Agregar una persona (metodo post)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmiranda3@mail.com");
        nuevaPersona.setTelefono("99887700");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la personas recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada:" + personaRecuperada);
        
        //Modificar la persona (metodo put)
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona modifica:" + response.readEntity(Persona.class));
        
        //Eliminar una persona
        //persona recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona Eliminada" + personaEliminar);
        
    }
    
}
