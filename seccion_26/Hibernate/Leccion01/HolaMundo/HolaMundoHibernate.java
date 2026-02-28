package mx.com.gm.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HolaMundoHibernate {
    
        static Logger log = LogManager.getLogger(HolaMundoHibernate.class);

	public static void main(String[] args) {
		String hql = "SELECT p FROM Persona p";
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
		EntityManager entityManager = fabrica.createEntityManager();
		Query query = entityManager.createQuery(hql);
		List<Persona> list = query.getResultList();
                log.info("Listado de Personas:");
		for (Persona p : list) {
			log.info("persona:" + p);
		}
	}
}