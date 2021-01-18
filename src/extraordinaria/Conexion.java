
package extraordinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String url = "jdbc:mysql://localhost/damm03uf6final";
    private String user = "root";
    private String pass = "";
    
    
    public Connection conn() throws SQLException{
        
        Connection co = null;
        try{
          co = DriverManager.getConnection(url,user,pass);
        } catch(SQLException ex){
             ex.printStackTrace();
        }
        
        return co;
    }
}
