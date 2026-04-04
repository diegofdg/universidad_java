package sga.web;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import sga.domain.Persona;
import sga.servicio.PersonaService;

@WebServlet("/pruebaTransaccion")
public class PruebaTransaccionServlet extends HttpServlet {
    @Inject
    private PersonaService personaService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            int idPersona = Integer.parseInt(request.getParameter("idPersona"));
            String nuevoApellido = request.getParameter("apellido");

            Persona persona = personaService.encontrarPersonaPorId(new Persona(idPersona));
            persona.setApellido(nuevoApellido);

            personaService.modificarPersona(persona);

            response.getWriter().println("<h2>Modificación exitosa</h2>");
        } catch (Exception e) {
            response.getWriter().println("<h2>Error en la transacción, revisa el log</h2>");
        }
    }
}
