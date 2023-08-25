
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private final String base = "proyecto_java";
    private final String user = "root";
    private final String password = "123456789";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion() {
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e) {
            System.err.println(e);
        }
        return con;
        
    }
    
}
