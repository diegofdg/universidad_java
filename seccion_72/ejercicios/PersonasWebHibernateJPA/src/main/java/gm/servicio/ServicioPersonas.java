package gm.servicio;

import java.util.List;
import gm.dao.PersonaDAO;
import gm.domain.Persona;

public class ServicioPersonas {
    
    private final PersonaDAO personaDao;
    
    public ServicioPersonas(){
        this.personaDao = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }
}
