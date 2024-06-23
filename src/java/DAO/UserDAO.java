package DAO;

import controladores.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String SELECT_USER = "SELECT * FROM usuarios WHERE usuario = ? and contraseña = ?";

    public boolean validate(String username, String password) throws ClassNotFoundException {
        boolean status = false;
        //Connection conn = null;
        //PreparedStatement stmt = null;
        //ConexionDB conexionServlet = new ConexionDB();

        try (Connection connection = ConexionDB.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
