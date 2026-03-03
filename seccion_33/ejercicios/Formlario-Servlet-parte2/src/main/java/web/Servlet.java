package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ubaldo
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Procesar los parametros
        var usuario = request.getParameter("usuario");
        var password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        var genero = request.getParameter("genero");
        var ocupacion = request.getParameter("ocupacion");
        var comentarios = request.getParameter("comentarios");
        var valorOculto = request.getParameter("oculto");
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html data-bs-theme='dark'>");
            out.println("<head>");
            out.println("<title>Resultado Servlet</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body class='container mt-5'>");
            out.println("<h1 class='mb-4 text-center text-warning'>Parámetros procesados por el Servlet</h1>");
            out.println("<table class='table table-bordered table-striped'");
            out.println("<tr><th>Usuario</th><td>" + usuario + "</td></tr>");
            out.println("<tr><th>Password</th><td>" + password + "</td></tr>");
            out.println("<tr><th>Tecnologías</th><td>");
            if(tecnologias != null){
                out.println(String.join(" / ", tecnologias));
            }
            else{
                out.println("Tecnologías no proporcionadas");
            }
            out.println("</td></tr>");
            
            out.println("<tr><th>Género</th><td>" + genero + "</td></tr>");
            out.println("<tr><th>Ocupación</th><td>" + ocupacion + "</td></tr>");
            out.println("<tr><th>Comentarios</th><td>" + comentarios + "</td></tr>");
            out.println("<tr><th>Valor oculto</th><td>" + valorOculto + "</td></tr>");
            
            out.println("</table>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
