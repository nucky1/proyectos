/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Controllers.ClienteController;
import Modelo.Cliente;
import Modelo.Inmueble;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author fran_
 */
public class ClienteDAO implements CteDAO{

    public ClienteDAO() {
        
    }

    @Override
    public ArrayList<Inmueble> getPropiedades(int clienteID) {
       String SQL="SELECT * FROM inmueble WHERE inm_dueño = "+clienteID; 
       ArrayList<Inmueble> inm = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Inmueble inmAux = new Inmueble(rs.getInt("inm_id"),rs.getInt("inm_dueñoID"),rs.getString("inm_direccion"),rs.getFloat("inm_precio"),rs.getInt("inm_tipo"));
                inmAux.setEstado(rs.getInt("inm_estado"));
                inmAux.setHabitaciones(rs.getInt("inm_habitaciones"));
                inmAux.setBano(rs.getInt("inm_baños"));
                inmAux.setPatio(rs.getBoolean("inm_patio"));
                inmAux.setCocina(rs.getBoolean("inm_cocina"));
                inmAux.setLiving(rs.getBoolean("inm_living"));
                inmAux.setComedor(rs.getBoolean("inm_comedor"));
                inmAux.setCocinaLiving(rs.getBoolean("inm_cocinaLiving"));
                inmAux.setCocinaComedor(rs.getBoolean("inm_cocinaComedor"));
                inmAux.setCocinaLivingComedor(rs.getBoolean("inm_cocinaLivingComedor"));
                inmAux.setMetros2(rs.getFloat("inm_MTS2"));
                inmAux.setFondo(rs.getFloat("inm_fondo"));
                inmAux.setBarrio(rs.getString("inm_barrio"));
                inmAux.setGarage(rs.getBoolean("inm_garage"));
                inmAux.setPlantaAlta(rs.getBoolean("inm_plantaAlta"));
                inmAux.setImpuestos(rs.getBoolean("inm_impuestos"));
                inmAux.setServicios(rs.getInt("inm_impuestos"));
                inmAux.setObservaciones(rs.getString("inm_observaciones"));
                inmAux.setOtros(rs.getString("inm_otros"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }
    
    @Override
    public ArrayList<Inmueble> getInmueblesDueño(int id) {
       String SQL="SELECT * FROM inmueble WHERE inm_dueñoID = "+id; 
       ArrayList<Inmueble> inm = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Inmueble inmAux = new Inmueble(rs.getInt("inm_id"),rs.getInt("inm_dueñoID"),rs.getString("inm_direccion"),rs.getFloat("inm_precio"),rs.getInt("inm_tipo"));
                inmAux.setEstado(rs.getInt("inm_estado"));
                inmAux.setHabitaciones(rs.getInt("inm_habitaciones"));
                inmAux.setBano(rs.getInt("inm_baños"));
                inmAux.setPatio(rs.getBoolean("inm_patio"));
                inmAux.setCocina(rs.getBoolean("inm_cocina"));
                inmAux.setLiving(rs.getBoolean("inm_living"));
                inmAux.setComedor(rs.getBoolean("inm_comedor"));
                inmAux.setCocinaLiving(rs.getBoolean("inm_cocinaLiving"));
                inmAux.setCocinaComedor(rs.getBoolean("inm_cocinaComedor"));
                inmAux.setCocinaLivingComedor(rs.getBoolean("inm_cocinaLivingComedor"));
                inmAux.setMetros2(rs.getFloat("inm_MTS2"));
                inmAux.setFondo(rs.getFloat("inm_fondo"));
                inmAux.setBarrio(rs.getString("inm_barrio"));
                inmAux.setGarage(rs.getBoolean("inm_garage"));
                inmAux.setPlantaAlta(rs.getBoolean("inm_plantaAlta"));
                inmAux.setImpuestos(rs.getBoolean("inm_impuestos"));
                inmAux.setServicios(rs.getInt("inm_impuestos"));
                inmAux.setObservaciones(rs.getString("inm_observaciones"));
                inmAux.setOtros(rs.getString("inm_otros"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }
    @Override
    public ArrayList<Inmueble> getInmueblesAlquilando(int id) {
       String SQL="SELECT inmueble.* FROM inmueble,infocontrato WHERE infoC_clienteID = "+id+" AND infoC_inmuebleID = inm_id"; 
       ArrayList<Inmueble> inm = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Inmueble inmAux = new Inmueble(rs.getInt("inm_id"),rs.getInt("inm_dueñoID"),rs.getString("inm_direccion"),rs.getFloat("inm_precio"),rs.getInt("inm_tipo"));
                inmAux.setEstado(rs.getInt("inm_estado"));
                inmAux.setHabitaciones(rs.getInt("inm_habitaciones"));
                inmAux.setBano(rs.getInt("inm_baños"));
                inmAux.setPatio(rs.getBoolean("inm_patio"));
                inmAux.setCocina(rs.getBoolean("inm_cocina"));
                inmAux.setLiving(rs.getBoolean("inm_living"));
                inmAux.setComedor(rs.getBoolean("inm_comedor"));
                inmAux.setCocinaLiving(rs.getBoolean("inm_cocinaLiving"));
                inmAux.setCocinaComedor(rs.getBoolean("inm_cocinaComedor"));
                inmAux.setCocinaLivingComedor(rs.getBoolean("inm_cocinaLivingComedor"));
                inmAux.setMetros2(rs.getFloat("inm_MTS2"));
                inmAux.setFondo(rs.getFloat("inm_fondo"));
                inmAux.setBarrio(rs.getString("inm_barrio"));
                inmAux.setGarage(rs.getBoolean("inm_garage"));
                inmAux.setPlantaAlta(rs.getBoolean("inm_plantaAlta"));
                inmAux.setImpuestos(rs.getBoolean("inm_impuestos"));
                inmAux.setServicios(rs.getInt("inm_impuestos"));
                inmAux.setObservaciones(rs.getString("inm_observaciones"));
                inmAux.setOtros(rs.getString("inm_otros"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }

    @Override
    public ArrayList<Inmueble> getAdministrando(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    /**
     * Recibe una lista de clientes nuevos
     * Los carga en la base de datos
     * @param nuevos
     */
    public void cargar(ArrayList<Cliente> nuevos) {
        String SQL = "INSERT INTO cliente (cte_id, cte_asesorID,  cte_nombre, cte_doc, cte_telefono, cte_contacto, cte_tipoDoc) VALUES ";
        for(int i=0; i<nuevos.size(); i++){
            SQL = SQL +"("+nuevos.get(i).getId()+","+nuevos.get(i).getAsesorID()+","+nuevos.get(i).getNombre()+","+nuevos.get(i).getDocumento()+","+nuevos.get(i).getTel()+","+ nuevos.get(i).getContacto()+","+nuevos.get(i).getTipoDoc()+")";
        }
        SQL = SQL.substring(0, SQL.length()-2);
        Main.Conexion.getInstance().EjecutarOperacion(SQL);        
    }

    /**
     * Recibe un cliente nuevo por parametro
     * Da de alta el ID en la base de datos
     * Retorna verdadero si el alta fue exitosa
     * @param nuevo
     * @return 
     */
    @Override
    public boolean alta(Cliente nuevo) {
        String SQL = "INSERT INTO cliente ( cte_asesorID,  cte_nombre, cte_tipoDoc, cte_doc, cte_telefono, cte_contacto,cte_fechaAlta) VALUES ("
        +nuevo.getAsesorID()+",'"+nuevo.getNombre()+"',"+nuevo.getTipoDoc()+","+nuevo.getDocumento()+","+nuevo.getTel()+",'"+nuevo.getContacto()+"',NOW())";
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>=1;
    }

    /**
     * Recibe un ID por parametro
     * Da de baja el cliente cuyo ID coincida con ID
     * Retorna verdadero si la baja fue exitosa
     * @param ID
     * @return 
     */
    @Override
    public boolean baja(int ID) {
        String SQL = "DELETE FROM cliente WHERE cte_id = "+ID;
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>=1;
    }

    /**
     * Recibe un cliente con nuevos datos por parametro
     * Actualiza el cliente en la base de datos cuyo ID coincida con el ingresado por parametro
     * @param actualizado
     * @return 
     */
    @Override
    public boolean modificar(Cliente actualizado) {
        String SQL = "UPDATE cliente SET cte_asesorID = "+actualizado.getAsesorID()+", cte_nombre = '"+actualizado.getNombre()+"', cte_doc = "+actualizado.getDocumento()+", cte_telefono = "+actualizado.getTel()+", cte_contacto ="+ actualizado.getContacto()+" WHERE cte_id = "+ actualizado.getId();
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>=1;
    }

    /**
     * Recibe un ID de cliente por parametro
     * Retorna el cliente con ese ID
     * @param ID
     * @return 
     */
    @Override
    public Cliente buscar(int ID) {
        String SQL = "SELECT * FROM cliente WHERE cte_id = "+ ID;
        Cliente cmAux=null;
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            if(rs.next())
            cmAux = new Cliente(rs.getInt("cte_id"), rs.getInt("cte_asesorID"), rs.getString("cte_nombre"),rs.getInt("cte_doc"),0,rs.getLong("cte_telefono"),rs.getString("cte_contacto"));            
        }catch(SQLException ex){ 
            System.out.println(ex.getMessage());
        }
        return cmAux;
    }    

    /**
     * Retorna la lista de todos los clientes
     * @return 
     */
    @Override
    public ArrayList<Cliente> listarTodo() {
        String SQL = "SELECT * FROM cliente";
        ArrayList<Cliente> client = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Cliente cmAux = new Cliente(rs.getInt("cte_id"), rs.getInt("cte_asesorID"), rs.getString("cte_nombre"),rs.getInt("cte_doc"),0,rs.getLong("cte_telefono"),rs.getString("cte_contacto"));
                client.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return client;
    }

    
    /**
     * Recibe un nombre de cliente por parametro
     * Devuelve una lista de clientes con ese nombre
     * @param dni
     * @return 
     */
    public ArrayList<Cliente> listarPorDNI(String dni) {
        String SQL = "SELECT * FROM cliente WHERE cte_nombre LIKE '"+dni+"%'";
        ArrayList<Cliente> client = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Cliente cmAux = new Cliente(rs.getInt("cte_id"), rs.getInt("cte_asesorID"), rs.getString("cte_nombre"),rs.getInt("cte_doc"),0,rs.getLong("cte_telefono"),rs.getString("cte_contacto"));
                client.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return client;
    }
    
    /**
     * Recibe un nombre de cliente por parametro
     * Devuelve una lista de clientes con ese nombre
     * @param nombre
     * @return 
     */
    @Override
    public ArrayList<Cliente> listarPorNombre(String nombre) {
        String SQL = "SELECT * FROM cliente WHERE cte_nombre LIKE '%"+nombre+"%'";
        ArrayList<Cliente> client = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Cliente cmAux = new Cliente(rs.getInt("cte_id"), rs.getInt("cte_asesorID"), rs.getString("cte_nombre"),rs.getInt("cte_doc"),0,rs.getLong("cte_telefono"),rs.getString("cte_contacto"));
                client.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return client;
    }
    /**
     * Esto solo trae la lista de dueños que tienen 1 contrato administrativo es decir infoC_tipo=3 
     * 
     * consulta que tiene que ir : "SELECT * FROM cliente WHERE cte_nombre LIKE '%"+nombre+"%' AND (0<>(SELECT COUNT(inm_id) FROM inmueble WHERE inm_dueñoID = cte_id))  AND (0<>(SELECT COUNT(infoC_id) FROM infocontrato WHERE infoC_tipo=3 AND infoC_dueñoID=cte_id))"
     * @param nombre
     * @return 
     */
    @Override
    public ArrayList<Cliente> listarDueniosPorNombre(String nombre) {
        String SQL = "SELECT * FROM cliente WHERE cte_nombre LIKE '%"+nombre+"%' AND (0<>(SELECT COUNT(inm_id) FROM inmueble WHERE inm_dueñoID = cte_id))  AND (0<>(SELECT COUNT(infoC_id) FROM infocontrato WHERE infoC_tipo=3 AND infoC_dueñoID=cte_id))";
        ArrayList<Cliente> client = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){
                Cliente cmAux = new Cliente(rs.getInt("cte_id"), rs.getInt("cte_asesorID"), rs.getString("cte_nombre"),rs.getInt("cte_doc"),0,rs.getLong("cte_telefono"),rs.getString("cte_contacto"));
                client.add(cmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return client;
    }
}
