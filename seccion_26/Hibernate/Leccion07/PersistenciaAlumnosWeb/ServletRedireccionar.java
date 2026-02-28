package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRedireccionar", urlPatterns = {"/ServletRedireccionar"})
public class ServletRedireccionar extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Redireccionamos a la pagina de Agregar Alumno
        request.getRequestDispatcher("WEB-INF/agregarAlumno.jsp").forward(request, response);
    }
}
