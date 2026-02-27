package gm.rh.repositorio;

import gm.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas más adelante
}
