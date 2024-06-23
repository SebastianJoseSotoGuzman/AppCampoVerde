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

@WebServlet(name = "RegistrarProducto", urlPatterns = {"/RegistrarProducto"})
public class RegistrarProducto extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        float precio = Float.parseFloat(request.getParameter("precio"));
        String unidad_medida = request.getParameter("unidad_medida");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String descripcion = request.getParameter("descripcion");
        

        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();

        try {
            conn = conexionServlet.getConnection();
            String sql = "INSERT INTO productos(nombre,tipo, precio, unidad_medida,stock,descripcion) VALUES (?, ?, ?, ?, ?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.setFloat(3, precio);
            stmt.setString(4, unidad_medida);
            stmt.setInt(5, stock);
            stmt.setString(6, descripcion);
            stmt.executeUpdate();
            request.setAttribute("message", "Producto registrado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al registrar Producto");
        } catch (ClassNotFoundException ex) {           
            Logger.getLogger(RegistrarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexionServlet.closeConnection(conn);
        }

        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
