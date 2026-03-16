package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Rectangulo;

/**
 *
 * @author ubaldo
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

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
        
        // 1. Procesamos parámetros
        String accion = request.getParameter("accion");
        
        // 2. Creamos los JavaBeans (clases de Modelo)
        Rectangulo rectanguloRequest = new Rectangulo(1, 2);
        Rectangulo rectanguloSession = new Rectangulo(3,4);
        Rectangulo rectanguloApplication = new Rectangulo(5,6);
        
        // 3. Agregamos el JavaBean a algún alcance (request, session, application)
        if("agregarVariables".equals(accion)){
            // Alcance request
            request.setAttribute("rectanguloRequest", rectanguloRequest);
            // Alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", rectanguloSession);
            // Alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", rectanguloApplication);
            
            // Agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            // 4. Redireccionamos al jsp de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
