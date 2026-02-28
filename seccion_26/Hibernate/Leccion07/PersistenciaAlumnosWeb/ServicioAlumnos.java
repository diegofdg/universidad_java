package servicio;

import dao.AlumnoDAO;
import model.Alumno;
import java.util.List;

public class ServicioAlumnos {

    // El Dao se asocia con la clase
    AlumnoDAO alumnoDao = new AlumnoDAO();

    // Esta clase se comunica con los DAO's que necesite
    public List<Alumno> listarAlumnos() {
        return alumnoDao.listarAlumnos();
    }

    public boolean guardarAlumno(Alumno alumno) {
        if(alumno != null && alumno.getIdAlumno() == null){
            //insert
            alumnoDao.insertar(alumno);
        }
        else{
            //update
            alumnoDao.actualizar(alumno);
        }
        
        return true;// si nada fallo, regresamos verdadero
    }

    public boolean eliminarAlumno(Integer idAlumno) {
        //delete
        alumnoDao.eliminar(new Alumno(idAlumno));        
        return true;// si nada falla regresamos verdadero
    }

    public Alumno encontrarAlumno(Integer idAlumno) {
        return alumnoDao.buscarPorId(new Alumno(idAlumno));
    }
}
