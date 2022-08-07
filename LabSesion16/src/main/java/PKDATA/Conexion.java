
package PKDATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bailon
 */
public class Conexion {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CRUDIDAT;encrypt=true;trustServerCertificate=true";

    private static final String USER = "sa";
    private static final String PAS = "admin123A";

    public static Connection getConexion() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PAS);
            System.out.println("OK");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }  
}


