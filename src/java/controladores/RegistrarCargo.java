package controladores;



import controladores.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarEmpleado", urlPatterns = {"/RegistrarEmpleado"})
public class RegistrarCargo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");             
        int area_id = Integer.parseInt(request.getParameter("area_id"));
        int cargo_id = Integer.parseInt(request.getParameter("cargo_id"));
        String fecha_hora = request.getParameter("fecha_hora");
        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();

        try {
            conn = conexionServlet.getConnection();
            String sql = "INSERT INTO empleados(nombre, apellidos, dni, telefono, area_id,cargo_id ,fecha_hora) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, dni);
            stmt.setString(4, telefono);
            stmt.setInt(5, area_id);
            stmt.setInt(6, cargo_id);
            stmt.setString(7, fecha_hora);
            stmt.executeUpdate();
            request.setAttribute("message", "Empleado registrado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al registrar Empleado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarCargo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexionServlet.closeConnection(conn);
        }
        request.getRequestDispatcher("empleados.jsp").forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
