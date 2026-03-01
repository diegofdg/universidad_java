package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;
import servicio.ServicioAlumnos;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. Nos comunicamos con la capa de servicio
        ServicioAlumnos servicioAlumnos = new ServicioAlumnos();

        //2. Recuperamos todos los alumnos
        List<Alumno> alumnos = servicioAlumnos.listarAlumnos();

        //3. Compartimos la informacion (MOdelo) con la vista
        request.setAttribute("alumnos", alumnos);

        //4. Seleccionamos la vista a mostrar la info de alumnos
        request.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
