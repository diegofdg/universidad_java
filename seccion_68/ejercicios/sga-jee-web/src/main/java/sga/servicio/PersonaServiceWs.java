package sga.servicio;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import sga.domain.Persona;

@WebService
public interface PersonaServiceWs {
    
    @WebMethod
    List<Persona> listarPersonas();
}
