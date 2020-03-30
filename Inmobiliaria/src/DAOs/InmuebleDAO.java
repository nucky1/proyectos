/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Cliente;
import Modelo.Inmueble;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author fran_
 */
public class InmuebleDAO implements InmDAO {
    ArrayList<Inmueble> datos;
    
    public InmuebleDAO(){
        this.datos = new ArrayList<Inmueble>();
    }
    
    @Override
    public boolean alta(Inmueble t) {
       String SQL ="INSERT INTO inmueble(inm_dueñoID,inm_direccion,inm_precio,inm_tipo,inm_estado,inm_habitaciones,inm_baños,inm_patio,inm_cocina,"
               + "inm_living,inm_comedor,inm_cocinaLiving,inm_cocinaComedor,inm_cocinaLivingComedor,inm_MTS2,inm_fondo,inm_barrio,inm_garage,"
               + "inm_plantaAlta,inm_impuestos,inm_servicios,inm_observaciones,inm_otros,inm_operacion,inm_lavadero,inm_amoblado,inm_expensas,inm_luz,inm_gas,inm_agua) VALUES("
               +t.getDuenoID()+","
               +"'"+t.getDireccion()+"',"
               +t.getPrecio()+","
               +t.getTipo()+","
               +t.getEstado()+","
               +t.getHabitaciones()+","
               +t.getBano()+","
               +t.isPatio()+","
               +t.isCocina()+","
               +t.isLiving()+","
               +t.isComedor()+","
               +t.isCocinaLiving()+","
               +t.isCocinaComedor()+","
               +t.isCocinaLivingComedor()+","
               +t.getMetros2()+","
               +t.getFondo()+","
               +"'"+t.getBarrio()+"',"
               +t.isGarage()+","
               +t.isPlantaAlta()+","
               +t.isImpuestos()+","
               +t.getServicios()+","
               +"'"+t.getObservaciones()+"',"
               +"'"+t.getOtros()+"',"
               +t.getOperacion()+","
               +t.isLavadero()+","
               +t.isAmoblado()+","
               +t.getExpensas()+","
               +t.isLuz()+","
               +t.isGas()+","
               +t.isAgua()+" )"; 
        System.out.println("SQL = " + SQL);
       return (Main.Conexion.getInstance().EjecutarOperacion(SQL) >= 1 );
    }

    @Override
    public boolean baja(int ID) {
        return false;
    }
    @Override
    public boolean setEstado(int id, int e) {
        String SQL = "UPDATE inmueble SET inm_estado ="+e+" WHERE inm_id = "+id;
        return Main.Conexion.getInstance().EjecutarOperacion(SQL)>1; 
    }    
    @Override
    public boolean modificar(Inmueble t) {
        return false;
    }
    
    @Override
    public Inmueble buscar(int ID) {
        String SQL="SELECT * FROM inmueble WHERE inm_id = "+ID; 
        ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
        Inmueble inmAux = null;
        try {
            if(rs.next()){
                inmAux = new Inmueble(rs.getInt("inm_id"),rs.getInt("inm_dueñoID"),rs.getString("inm_direccion"),rs.getFloat("inm_precio"),rs.getInt("inm_tipo")); 
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
                inmAux.setOperacion(rs.getInt("inm_operacion"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inmAux;
    }

    @Override
    public ArrayList<Inmueble> listarTodo() {
       String SQL="SELECT * FROM inmueble"; 
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
                inmAux.setOperacion(rs.getInt("inm_operacion"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }
    /**
     * IF (condicion,true , else ) 
     * En el caso que no se haya elejido un filtro tendrian que pasarle un valor por defecto a los campos, 
     * por ejemplo si el tipo no se selecciono, tiene que venir en -1 el valor del parametro. 
     *  IF (tipo = -1 , inm_tipo , inm_tipo = tipo ) " 
     *     si es -1   , traigo todos (se puede reemplazar por inm_tipo = "inm_tipo" si no anda), sino los que sean del tipo seleccionado 
     *  
     * 
     * @param pDesde
     * @param pHasta
     * @param estado
     * @param tipo
     * @param operacion
     * @param habitaciones
     * @return 
     */
    @Override
    public ArrayList<Inmueble> listarInmueblesFiltros(float pDesde, float pHasta, int estado, int tipo, int operacion, int habitaciones) {
        String SQL = "SELECT * FROM  inmueble "
                + "	 WHERE inm_precio BETWEEN " +pDesde+ " AND "+pHasta
                + "	 AND IF ("+estado+" = -1 ,inm_estado,inm_estado="+estado+" ) "
                + "	 AND IF ('"+tipo+"' = -1 ,inm_tipo , inm_tipo = '"+tipo+"' ) " 
                + "	 AND IF ('"+operacion+"' =-1,inm_operacion ,inm_operacion= '"+operacion+"' ) " 
                + "	 AND IF ("+habitaciones+" =-1,inm_habitaciones, inm_habitaciones = "+habitaciones +" )";
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
                inmAux.setOperacion(rs.getInt("inm_operacion"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }

    @Override
    public void cargar(ArrayList<Inmueble> t) {
        this.datos=(ArrayList<Inmueble>) t.clone();
    }
    
    @Override
    public ArrayList<Inmueble> buscarPorDuenio(int duenioID) {
        String SQL = "SELECT * FROM  inmueble "
                + "	 WHERE inm_dueñoID = " +duenioID;
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
                inmAux.setOperacion(rs.getInt("inm_operacion"));
                inm.add(inmAux);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
       return  inm;
    }
    @Override
    public Cliente getDuenio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente getInquilino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
