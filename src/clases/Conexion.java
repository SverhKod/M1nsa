package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
   public static Connection conectar() {
        // URL de conexión a la base de datos
        String url = "jdbc:mysql://yamanote.proxy.rlwy.net:12801/railway";
        String usuario = "root";
        String contraseña = "cMIdOMaKPWfPvIHZlWxcEpIwTWpNxRoi";

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
            return conn;

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
        return null;
    }
}
