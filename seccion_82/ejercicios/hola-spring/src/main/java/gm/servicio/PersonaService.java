package gm.servicio;

import java.util.List;
import gm.domain.Persona;

public interface PersonaService {
    
    List<Persona> listarPersonas();
    
    void guardar(Persona persona);
    
    void eliminar(Persona persona);
    
    Persona encontrarPersona(Persona persona);
}
