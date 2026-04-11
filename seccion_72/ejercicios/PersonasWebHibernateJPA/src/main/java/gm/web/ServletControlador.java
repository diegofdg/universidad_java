package gm.web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import gm.domain.Persona;
import gm.servicio.ServicioPersonas;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServicioPersonas servicioPersonas = new ServicioPersonas();
        
        List<Persona> personas = servicioPersonas.listarPersonas();
        
        request.setAttribute("personas", personas);
        
        try {
            request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
