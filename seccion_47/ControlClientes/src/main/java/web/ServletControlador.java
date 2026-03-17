package web;

import datos.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import modelo.Cliente;

/**
 *
 * @author ubaldo
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

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
        String accion = Optional.ofNullable(request.getParameter("accion")).orElse("listar");
        switch(accion){
            case "listar" -> this.listarClientes(request, response);
            case "editar" -> this.editarCliente(request, response);
            case "eliminar" -> this.eliminarCliente(request, response);
            default -> this.listarClientes(request, response);
        }
    }
    
    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDAO().listar();
        System.out.println("clientes:" + clientes);
        // Obtenemos la sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        // Enviamos la respuesta al jsp de clientes
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
//        double saldoTotal = 0.0;
//        for(Cliente cliente: clientes){
//            saldoTotal += cliente.getSaldo();
//        }
//        return saldoTotal;
        
        return clientes.stream().mapToDouble(Cliente::getSaldo).sum();
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDAO().encontrarCliente(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        new ClienteDAO().eliminar(new Cliente(idCliente));
        // Listamos los clientes
        this.listarClientes(request, response);
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
        String accion = Optional.ofNullable(request.getParameter("accion")).orElse("listar");
        switch(accion){
            case "insertar" -> this.insertarCliente(request, response);
            case "modificar" -> this.modificarCliente(request, response);
            default -> this.listarClientes(request, response);
        }
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Procesamos los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        // Creamos un objeto de tipo cliente
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        new ClienteDAO().insertar(cliente);
        // Listamos los clientes
        this.listarClientes(request, response);
    }


    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        new ClienteDAO().actualizar(cliente);
        // Redirigimos al caso de listar
        this.listarClientes(request, response);
    }
    
    
}
