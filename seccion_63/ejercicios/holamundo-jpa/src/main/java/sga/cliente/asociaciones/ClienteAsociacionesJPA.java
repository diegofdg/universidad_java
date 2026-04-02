package sga.cliente.asociaciones;

import java.util.List;
import jakarta.persistence.*;
import sga.domain.Persona;
import sga.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteAsociacionesJPA {
  
    private static final Logger log = LoggerFactory.getLogger(ClienteAsociacionesJPA.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");

        try (EntityManager em = emf.createEntityManager()) {
            // Recuperar todas las personas
            List<Persona> personas = em.createNamedQuery("Persona.findAll", Persona.class).getResultList();

            // Imprimir los objetos de tipo persona y sus usuarios asociados
            for (Persona persona : personas) {
                log.info("Persona: {}", persona);
                for (Usuario usuario : persona.getUsuarioList()) {
                    log.info("Usuario asociado: {}", usuario);
                }
            }
        }
    }
}
