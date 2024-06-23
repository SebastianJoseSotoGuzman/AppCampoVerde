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
import java.util.Random;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {

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

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("pass");
        // int empleado_id = Integer.parseInt(request.getParameter("empleado"));

        String hashedPass = encryptPassword(contraseña);

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionDB.getConnection();
            conn.createStatement();
            // String sql = "INSERT INTO usuarios(usuario,contraseña) VALUES ('" + usuario + "','" + hashedPass + "')";
            String sql = "INSERT INTO usuarios(usuario,contraseña) VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, hashedPass);

            // stmt.setInt(3, empleado_id);
            stmt.executeUpdate();
            request.setAttribute("message", "Usuario registrado exitosamente");
        } catch (SQLException e) {
            request.setAttribute("error", "Error al registrar Usuario");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionDB.closeConnection(conn);
        }
        request.getRequestDispatcher("usuario.jsp").forward(request, response);
    }

    private static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
