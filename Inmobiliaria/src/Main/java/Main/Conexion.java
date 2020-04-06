/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucho
 */ 
  
public class Conexion {
    private Connection conexion;
    private ResultSet resultado;
    private Statement s;
    private static Conexion db;
    
    private Conexion(){
        resultado = null;
        s = null; 
        String url = "jdbc:mysql://localhost:3306/im-inmobiliaria"; // 127.0.0.1 tambien anda en vez de localhost
        String password = "";
        String user = "root";
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conexion = DriverManager.getConnection(url,user,password); 
            if(conexion == null)
            {
                System.out.println("no se conecto");
            }else{
                System.out.println("se conecto");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage()); 
            e.printStackTrace();
        }    
    }
    
    public static Conexion getInstance(){    
        if(db == null)
            db = new Conexion();
        return db;
    }
   
    public void Desconectar(){
        try{
            conexion.close();
            conexion= null;
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }
    
    public java.sql.ResultSet EjecutarConsultaSQL(String sql){        
        try {
            s = conexion.createStatement();
            this.resultado= s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int EjecutarOperacion(String sql){
        int respuesta = 0;
        try {
            //s = conexion.createStatement();
            respuesta = this.s.executeUpdate(sql);
                if(respuesta==1){
                         System.out.println("Registro Guardado");
                }
                else{
                         System.out.println("Ocurrio un problema al agregar el registro");
                }
            } catch(SQLException ex){
                // Mostramos toda la informacion sobre el error disponible
                System.out.println( "Error: SQLException" );
                while (ex != null) {
                    System.out.println ("SQLState: " + ex.getSQLState ());
                    System.out.println ("Mensaje:  " + ex.getMessage ());
                    System.out.println ("ErrorCode:   " + ex.getErrorCode ());
                    ex = ex.getNextException();
                }
            } catch(Exception e) {
                System.out.println("Se produjo un error inesperado:    "+e.getMessage());
            }
        return respuesta;
      }
        

           
}