
package basededatos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {


    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
        } catch (Exception ex) {
            System.out.println("No se ha encontrado el driver");
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/prueba";
            String usuario = "root";
            String password = "ausias2022";
            
            Connection connection = DriverManager.getConnection(url,usuario,password);
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM personas");
            
            while(rs.next()){
              
            }
           
        }
        
        catch (Exception e) {
            System.out.println(e);
        }

    }
    
}