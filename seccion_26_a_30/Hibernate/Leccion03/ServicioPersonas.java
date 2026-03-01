package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {

    public List<Persona> listarPersonas() {
        PersonaDAO personaDao = new PersonaDAO();
        return personaDao.listarPersonas();
    }
}