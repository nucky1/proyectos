/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Contrato;
import Modelo.TuplaDeudores;
import Modelo.TuplaInmProp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lucho
 */
public class ContratoDAO implements CntrDAO {
    public String fechaSQL(Date fecha){
        DateFormat fmtSQL = new SimpleDateFormat("yyyy-MM-dd");  
        return fmtSQL.format(fecha);
    }
    @Override
    public ArrayList<Contrato> listarTodo() {
        String SQL="SELECT * FROM infocontrato";
        ArrayList<Contrato> cont = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){ 
                Contrato contAux = new Contrato(rs.getInt("infoC_id"),rs.getDate("infoC_fecha"),rs.getFloat("infoC_alq_comision"),rs.getString("infoC_observaciones"),rs.getInt("infoC_clienteID"),rs.getInt("infoC_inmuebleID"),rs.getInt("infoC_dueñoID"),rs.getInt("infoC_asesorID"),rs.getInt("infoC_tipo"),rs.getBoolean("infoC_adm_premium"),rs.getFloat("infoC_adm_porcentajeAlq"),rs.getFloat("infoC_alq_aumento"),rs.getDate("infoC_alq_fechaFin"),rs.getInt("infoC_diaVen"),rs.getDate("infoC_alq_fechaInicio")); 
                contAux.setTipo(rs.getInt("infoC_tipo"));     
                cont.add(contAux);
            } 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return cont;
    }

    @Override
    public void cargar(ArrayList<Contrato> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alta(Contrato c) {
        String SQL ="INSERT INTO infocontrato(infoC_fecha,infoC_alq_comision,infoC_observaciones,infoC_firma,infoC_clienteID,infoC_inmuebleID,infoC_dueñoID,infoC_asesorID,"
                + "infoC_tipo,infoC_adm_premium,infoC_adm_porcentajeAlq,infoC_alq_aumento,infoC_alq_fechafin,infoC_diaVen,infoC_alq_fechaInicio) VALUES("
               +"'"+c.getFechaSQL()+"',"
               +"'"+c.getComision()+"',"
               +"'"+c.getObservaciones()+"',"
               +"'"+"firma"+"',"+
               +c.getClienteID()+","
               +c.getInmuebleID()+","
               +c.getDuenoID()+","
               +c.getAcesorID()+","
               +c.getTipo()+","
               +c.isAdminPremium()+","
               +c.getAdminPorcentajeAlq()+","
               +c.getAlqAumento()+","
               +"'"+c.getAlqFechaFinSQL()+"',"
               +"'"+c.getDiaVen()+"',"
               +"'"+c.getFechaInicioSQL()+"')";
       return (Main.Conexion.getInstance().EjecutarOperacion(SQL) >= 1 );
    }

    @Override
    public boolean baja(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Contrato t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato buscar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    public boolean clienteTipoContrato(int ID, int tipo) {
        String SQL = "SELECT * FROM infocontrato WHERE IF("+tipo+" = 0, infoC_dueñoID = "+ID+", infoC_dueñoID = "+ID+" AND infoC_tipo = "+tipo+")" ;
        try{ 
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            return rs.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    /**
     * tipo 0 = todos los tipo.
     * @param ID
     * @param tipo
     * @return 
     */
    @Override
    public ArrayList<Contrato> buscarPorCliente(int ID, int tipo) {
        String SQL = "SELECT * FROM infocontrato WHERE IF("+tipo+" = 0, infoC_clienteID= "+ID+", infoC_clienteID = "+ID+" AND infoC_tipo = "+tipo+")" ; 
        System.out.println("SQL = " + SQL);
        ArrayList<Contrato> contratos = new ArrayList();
        try{ 
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){ 
                Contrato contAux = new Contrato(rs.getInt("infoC_id"),rs.getDate("infoC_fecha"),rs.getFloat("infoC_alq_comision"),rs.getString("infoC_observaciones"),rs.getInt("infoC_clienteID"),rs.getInt("infoC_inmuebleID"),rs.getInt("infoC_dueñoID"),rs.getInt("infoC_asesorID"),rs.getInt("infoC_tipo"),rs.getBoolean("infoC_adm_premium"),rs.getFloat("infoC_adm_porcentajeAlq"),rs.getFloat("infoC_alq_aumento"),rs.getDate("infoC_alq_fechaFin"),rs.getInt("infoC_diaVen"),rs.getDate("infoC_alq_fechaInicio")); 
                contAux.setTipo(rs.getInt("infoC_tipo")); 
                contratos.add(contAux); 
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        return contratos;
    }
    private float getPorcentajeDeGanancia(int duenioID){
        String SQL= "SELECT infoC_adm_porcentajeAlq FROM infocontrato WHERE infoC_tipo=3 AND infoC_dueñoID = "+duenioID;
        float porcentajeGanancia=-1f;
        try{ 
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            if(rs.next()){
                porcentajeGanancia= rs.getFloat("infoC_adm_porcentajeAlq");
            }
        }catch(SQLException e){
            System.out.println("Problema a traer el porcentaje de ganancia"+e.getMessage());
        }
        return porcentajeGanancia;
    }
    /**
     * 
     * @param clienteID
     * @param mes
     * @param anio
     * @return 
     */
    @Override
    public ArrayList<TuplaInmProp> listarInmueblesDuenio(int clienteID, int mes, int anio){
        float porcentajeGanancia= getPorcentajeDeGanancia(clienteID);
        String SQL= "SELECT infoC_inmuebleID,cte_nombre,inm_id,inm_direccion,pagoA_montoMes,pagoA_completado,infoC_adm_porcentajeAlq,pagoA_rendido,pagoA_id " +
                    " FROM infocontrato,inmueble,cliente,pagoalquiler WHERE infoC_tipo=1 " +
                    " AND infoC_dueñoID= " +clienteID +
                    " AND infoC_inmuebleID=inm_id " +
                    " AND infoC_clienteID=cte_id " +
                    " AND infoC_id=pagoA_contratoID " +
                    " AND (SELECT MONTH(pagoA_fechaVencimiento)= " +(mes+1)+
                    ") AND (SELECT YEAR(pagoA_fechaVencimiento)= " +anio+
                    ") AND infoC_alq_fechaFin> '"+fechaSQL(new Date(anio-1900,mes,1))+"'"; 
        ArrayList<TuplaInmProp> aux;
        aux = new ArrayList();
        try{ 
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){ 
                float valTotal=rs.getFloat("pagoA_montoMes"); 
                float valRendir = valTotal - valTotal*(porcentajeGanancia/100);
                
                TuplaInmProp contAux = new TuplaInmProp(rs.getInt("infoC_inmuebleID"),rs.getString("cte_nombre"),rs.getString("inm_direccion"),valRendir,valTotal,rs.getInt("pagoA_completado") ,rs.getInt("pagoA_rendido"),rs.getInt("pagoA_id"));
                aux.add(contAux); 
            }
            return aux;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    @Override
    public ArrayList<TuplaDeudores> listarDeudores(int duenioID){
        String SQL = "SELECT cte_nombre,cte_id,infoC_inmuebleID,inm_direccion,cte_telefono,sum(pagoA_montoTotal)AS deudaTot,count(pagoA_id)AS cantMeses FROM cliente,inmueble,pagoalquiler,infocontrato "
                + "WHERE infoC_dueñoID= "+duenioID
                + " AND infoC_clienteID=cte_id"
                + " AND infoC_inmuebleID=inm_id"
                + " AND pagoA_contratoID=infoC_id"
                + " AND pagoA_completado=0"
                + " AND pagoA_fechaVencimiento<NOW() ORDER BY deudaTot DESC";
        //System.out.println("SQL = " + SQL);
        ArrayList<TuplaDeudores> aux= new ArrayList();
        try{ 
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){  
                if(rs.getInt("cantMeses")!=0){
                    TuplaDeudores contAux = new TuplaDeudores(rs.getInt("cte_id"),rs.getInt("infoC_inmuebleID"),rs.getString("cte_nombre"),rs.getLong("cte_telefono"),rs.getFloat("deudaTot"),rs.getInt("cantMeses"));
                    aux.add(contAux); 
                }
            }
            return aux;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
