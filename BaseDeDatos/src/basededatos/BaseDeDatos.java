
package basededatos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class BaseDeDatos {

    public static void main(String[] args) {
        
        boolean ok;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("No se ha encontrado el driver");
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/prueba";
            String usuario = "root";
            String password = "luis";
            
            Connection connection = DriverManager.getConnection(url,usuario,password);
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM personas");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha = rs.getDate("fecha");
                
                System.out.println(String.format("%d, %s %s, %s",id,nombre,apellido,fecha));
            }
            
            ok = statement.execute("insert into personas (nombre,apellido,fecha) values ('Luis','Perez','1997-07-21');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM personas");
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha = rs.getDate("fecha");
                
                System.out.println(String.format("%d, %s %s, %s",id,nombre,apellido,fecha));
            }
            rs.close();
            statement.close();
            connection.close();  
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}