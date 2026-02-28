package test;

import dao.AlumnoDAO;
import dao.AsignacionDAO;
import dao.ContactoDAO;
import dao.CursoDAO;
import dao.DomicilioDAO;
import dao.InstructorDAO;
import dao.PagoDAO;
import dao.RolDAO;
import dao.SucursalDAO;
import dao.UsuarioDAO;

/**
 *
 * @author gm
 */
public class TestDAOs {
      public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        alumnoDao.listar();
        
        AsignacionDAO asignacionDao = new AsignacionDAO();
        asignacionDao.listar();
        
        ContactoDAO contactoDao = new ContactoDAO();
        contactoDao.listar();
        
        CursoDAO cursoDao = new CursoDAO();
        cursoDao.listar();
        
        DomicilioDAO domicilioDao = new DomicilioDAO();
        domicilioDao.listar();
        
        InstructorDAO instructorDao = new InstructorDAO();
        instructorDao.listar();
        
        PagoDAO pagoDao = new PagoDAO();
        pagoDao.listar();
        
        RolDAO rolDao = new RolDAO();
        rolDao.listar();
        
        SucursalDAO sucursalDao = new SucursalDAO();
        sucursalDao.listar();
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.listar();
    }
}
