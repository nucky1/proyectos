/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Asesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public class AsesorDAO implements AseDAO {

    /**
     * Recibe una lista de asesores nuevos
     * Los carga en la base de datos
     * @param nuevos
     */
    public void cargar(ArrayList<Asesor> nuevos) {
        String SQL = "INSERT INTO asesor (ase_id, ase_nombre, ase_telefono) VALUES ";
        for(int i=0; i<nuevos.size(); i++){
            SQL = SQL +"("+nuevos.get(i).getId()+","+nuevos.get(i).getNombre()+","+nuevos.get(i).getTel()+")";
        }
        SQL = SQL.substring(0, SQL.length()-2);
        Main.Conexion.getInstance().EjecutarOperacion(SQL);        
    }

    /**
     * Recibe un asesor nuevo por parametro
     * Da de alta el ID en la base de datos
     * Retorna verdadero si el alta fue exitosa
     * @param nuevo
     * @return 
     */
    @Override
    public boolean alta(Asesor nuevo) {
        String SQL = "INSERT INTO asesor (ase_id, ase_nombre, ase_telefono) VALUES ("+ nuevo.getId()+","+nuevo.getNombre()+","+nuevo.getTel()+")";
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>1;
    }

    /**
     * Recibe un ID por parametro
     * Da de baja el asesor cuyo ID coincida con ID
     * Retorna verdadero si la baja fue exitosa
     * @param ID
     * @return 
     */
    @Override
    public boolean baja(int ID) {
        String SQL = "DELETE FROM asesor WHERE ase_id = "+ID;
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>1;
    }

    /**
     * Recibe un asesor con nuevos datos por parametro
     * Actualiza el asesor en la base de datos cuyo ID coincida con el ingresado por parametro
     * @param actualizado
     * @return 
     */
    public boolean modificar(Asesor actualizado) {
        String SQL = "UPDATE asesor SET ase_nombre = "+actualizado.getNombre()+", ase_telefono = "+actualizado.getTel()+ " WHERE ase_id = "+ actualizado.getId();
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>1;
    }

    /**
     * Recibe un ID de asesor por parametro
     * Retorna el asesor con ese ID
     * @param ID
     * @return 
     */
    public Asesor buscar(int ID) {
        String SQL = "SELECT * FROM asesor WHERE ase_id = "+ ID;
        Asesor aseAux=null;
        try{            
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            if(rs.next())
            aseAux = new Asesor(rs.getInt("ase_id"), rs.getString("ase_nombre"),rs.getLong("ase_telefono"));            
        }catch(SQLException ex){ 
            System.out.println(ex.getMessage());
        }
        return aseAux;
    }    

    /**
     * Retorna la lista de todos los asesors
     * @return 
     */
    public ArrayList<Asesor> listarTodo(){
        String SQL = "SELECT * FROM asesor";
        ArrayList<Asesor> ase = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Asesor cmAux = new Asesor(rs.getInt("ase_id"), rs.getString("ase_nombre"),rs.getLong("ase_telefono"));
                ase.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ase;
    }
    
    /**
     * Recibe un nombre de asesor por parametro
     * Devuelve una lista de asesores con ese nombre
     * @param nombre
     * @return 
     */
    @Override
    public ArrayList<Asesor> listarPorNombre(String nombre) {
        String SQL = "SELECT * FROM asesor WHERE ase_nombre LIKE '%"+nombre+"%'";
        ArrayList<Asesor> ase = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Asesor cmAux = new Asesor(rs.getInt("ase_id"), rs.getString("ase_nombre"),rs.getLong("ase_telefono"));
                ase.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ase;
    }
}
