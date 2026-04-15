package sga.servicio;

import java.util.List;
import sga.dao.AlumnoDAO;
import sga.domain.Alumno;

public class ServicioAlumno {
    private final AlumnoDAO alumnoDao = new AlumnoDAO();
    
    public List<Alumno> listarAlumnos(){
        return alumnoDao.listar();
    }
    
    public void guardarAlumno(Alumno alumno){
        if( alumno != null && alumno.getIdAlumno() == null){
            alumnoDao.insertar(alumno);
        }
        else{
            alumnoDao.modificar(alumno);
        }
    }
    
    public void eliminarAlumno(Alumno alumno){
        alumnoDao.eliminar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno){
        return alumnoDao.buscarPorId(alumno);
    }
    
}
