package beans.servicio;

import beans.domain.Colonia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ColoniaService {

    @PersistenceContext
    EntityManager em;

    public List<Colonia> findAll() {
        return em.createNamedQuery("Colonia.findAll").getResultList();
    }
}
