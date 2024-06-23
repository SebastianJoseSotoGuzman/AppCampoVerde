package controladores;

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

@WebServlet(name = "RegistrarProveedor", urlPatterns = {"/RegistrarProveedor"})
public class RegistrarProveedor extends HttpServlet {

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
        String razon_social = request.getParameter("razon_social");
        String ruc = request.getParameter("ruc");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String servicio = request.getParameter("servicio");

        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();

        try {
            conn = conexionServlet.getConnection();
            String sql = "INSERT INTO proveedores(razon_social, ruc, telefono, correo, servicio) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, razon_social);
            stmt.setString(2, ruc);
            stmt.setString(3, telefono);
            stmt.setString(4, correo);
            stmt.setString(5, servicio);
            stmt.executeUpdate();
            request.setAttribute("message", "Proveedor registrado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al registrar Proveedor");
        } catch (ClassNotFoundException ex) {           
            Logger.getLogger(RegistrarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexionServlet.closeConnection(conn);
        }

        request.getRequestDispatcher("proveedores.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
