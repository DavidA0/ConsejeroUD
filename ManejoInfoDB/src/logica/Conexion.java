package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
       
    private static Connection conexion;
    
    public static boolean comprobar(String url,String password){
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, "postgres", password);
            if(conexion!=null){
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
        return false;
    }
    
    public static void establecerConexion(){
        String url = "jdbc:postgresql://localhost:5432/ConsejeroUD";
        String password = "postgres2018";
        
        if(conexion!=null){
            return;
        }
        
        if(comprobar(url,password)==true){
            System.out.println("Conexion establecida");
        }else{
            JOptionPane.showMessageDialog(null,"Problemas de conexion con la base de datos");
        }
    }

    public static void Desconectar(){
        conexion = null;
        System.out.println("Se ha desconectado ");
    }
    
    public static Connection getConexion() {
        return conexion;
    }
}
