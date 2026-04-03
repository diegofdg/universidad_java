package sga.cliente.criteria;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PruebaApiCriteria {

    private static final Logger log = LoggerFactory.getLogger(PruebaApiCriteria.class);

    public static void main(String[] args) {
        // 1️. Crear la fábrica de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");

        try (EntityManager em = emf.createEntityManager()) {

            // 2️. Crear el CriteriaBuilder
            CriteriaBuilder cb = em.getCriteriaBuilder();

            // 3️. Crear una consulta de Criteria para la entidad Persona
            CriteriaQuery<Persona> criteriaQuery = cb.createQuery(Persona.class);

            // 4️. Definir la raíz de la consulta (especificar de qué entidad obtener los datos)
            Root<Persona> fromPersona = criteriaQuery.from(Persona.class);

            // 5️. Seleccionar los datos desde la raíz
            criteriaQuery.select(fromPersona);

            // 6️. Crear y ejecutar la consulta
            TypedQuery<Persona> query = em.createQuery(criteriaQuery);
            List<Persona> personas = query.getResultList();

            // 7️. Mostrar los resultados
            mostrarPersonas(personas);

            // **2-a. Consulta de la Persona con id = 1 (Forma Directa)**
            log.info("\n2-a. Consulta de la Persona con id = 1");
            cb = em.getCriteriaBuilder();
            criteriaQuery = cb.createQuery(Persona.class);
            fromPersona = criteriaQuery.from(Persona.class);
            criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
            Persona persona = em.createQuery(criteriaQuery).getSingleResult();
            log.info("Persona: " + persona);

            // **2-b. Consulta de la Persona con id = 1 (Usando Predicate)**
            log.info("\n2-b. Consulta de la Persona con id = 1 usando Predicate");
            cb = em.getCriteriaBuilder();
            criteriaQuery = cb.createQuery(Persona.class);
            fromPersona = criteriaQuery.from(Persona.class);
            criteriaQuery.select(fromPersona);

            // La clase Predicate permite agregar varios criterios dinámicamente
            List<Predicate> criterios = new ArrayList<>();

            // Verificamos si tenemos criterios que agregar
            Integer idPersonaParam = 1;
            ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
            criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));

            // Se agregan los criterios a la consulta
            if (criterios.isEmpty()) {
                throw new RuntimeException("Sin criterios");
            } else if (criterios.size() == 1) {
                criteriaQuery.where(criterios.get(0));
            } else {
                criteriaQuery.where(cb.and(criterios.toArray(Predicate[]::new)));
            }

            query = em.createQuery(criteriaQuery);
            query.setParameter("idPersona", idPersonaParam);

            // Se ejecuta el query
            persona = query.getSingleResult();
            log.info("Persona: " + persona);
        }
    }

    // Método para mostrar los resultados obtenidos
    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.info("Persona: " + p);
        }
    }
}
