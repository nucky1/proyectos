 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Contrato;
import Modelo.PagoAlquiler;
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
public class PagoAlquilerDAO implements PalqDAO {
    
    @Override
    public ArrayList<PagoAlquiler> buscarPorContrato(int ID) {
        String SQL = "SELECT * FROM pagoalquiler WHERE pagoA_contratoID = " + ID +" ORDER BY pagoA_fechaVencimiento ASC";
        //System.out.println("SQL  que dira este 28= " + SQL);
        ArrayList<PagoAlquiler> pagos = new ArrayList();
        try{
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            while(rs.next()){                
                PagoAlquiler contAux = new PagoAlquiler(rs.getInt("pagoA_id"),ID,rs.getDate("pagoA_fechaPago"),rs.getDate("pagoA_fechaVencimiento"),rs.getFloat("pagoA_montoMes"),rs.getFloat("pagoA_montoGas"),rs.getFloat("pagoA_montoLuz"),rs.getFloat("pagoA_punitorios"),rs.getFloat("pagoA_montoImp"),rs.getFloat("pagoA_montoTotal"),rs.getFloat("pagoA_montoPago"),rs.getBoolean("pagoA_completado")); 
                pagos.add(contAux); 
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return pagos;
    }

    @Override
    public ArrayList<PagoAlquiler> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargar(ArrayList<PagoAlquiler> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alta(PagoAlquiler t) {
        return true;
    }
    
    public String fechaSQL(Date fecha){
        DateFormat fmtSQL = new SimpleDateFormat("yyyy-MM-dd");  
        return fmtSQL.format(fecha);
    }
    
    @Override
    public boolean altaNpagos(Contrato nuevo, float senia, float precioInicial,int periodo){   
        boolean bien = true;
        boolean esPrimero = true;
        Date fechaI = nuevo.getFechaInicio();
        Date fechaF = nuevo.getAlqFechaFin(); 
        String fechaInicio = nuevo.getFechaInicioSQL();
        String fechaFin = nuevo.getAlqFechaFinSQL();
        String SQL ="";
        fechaSQL(fechaI);
        
        float aumentoMes = precioInicial;
        float porcentajeAumentoMes = nuevo.getAdminPorcentajeAlq();
        
        int cont = 0;
        
        while(fechaI.before(fechaF)){
            Date fechaVen= new Date(fechaI.getYear(),fechaI.getMonth(),nuevo.getDiaVen());
            cont++;
            if(esPrimero){
                SQL = "INSERT INTO pagoalquiler(pagoA_contratoID,pagoA_fechaPago,pagoA_fechaVencimiento,pagoA_punitorios,pagoA_montoMes,pagoA_montoLuz,pagoA_montoGas,pagoA_montoImp,pagoA_montoTotal,pagoA_montoPago) "
                        + "VALUES((SELECT MAX(infoC_id) FROM infocontrato),'"+fechaSQL(fechaI)+"','"+fechaSQL(fechaVen)+"',0,"+precioInicial+",0,0,0,"+precioInicial+","+senia+")";
                esPrimero = false;
            }
            else{
                SQL = "INSERT INTO pagoalquiler(pagoA_contratoID,pagoA_fechaPago,pagoA_fechaVencimiento,pagoA_punitorios,pagoA_montoMes,pagoA_montoLuz,pagoA_montoGas,pagoA_montoImp,pagoA_montoTotal,pagoA_montoPago) "
                        + "VALUES((SELECT MAX(infoC_id) FROM infocontrato),'"+fechaSQL(fechaI)+"','"+fechaSQL(fechaVen)+"',0,"+aumentoMes+",0,0,0,"+aumentoMes+",0)";
                if(cont == periodo){
                    aumentoMes += porcentajeAumentoMes*aumentoMes/100;
                    aumentoMes /=50;
                    aumentoMes = (float) Math.ceil(aumentoMes);
                    aumentoMes *=50;
                    cont = 0;
                }
            }
            if(Main.Conexion.getInstance().EjecutarOperacion(SQL) >= 1){
                if((fechaI.getMonth()+1)==12){
                    fechaI.setMonth(0);
                    fechaI.setYear(fechaI.getYear()+1);
                }else{
                    fechaI.setMonth(fechaI.getMonth()+1);
                }
            }else{
                bien=false;
                return bien;
            }
        }
        return bien;
    }
    
    
    @Override
    public boolean baja(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(PagoAlquiler t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PagoAlquiler buscar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insetarPagoAlq(PagoAlquiler pa,int mes,int year) {
        String SQL = "UPDATE pagoalquiler SET "+
                " pagoA_fechaPago = '"+pa.getFechaPagoSQL()+"',"+
                " pagoA_punitorios = "+pa.getPunitorios()+","+
                " pagoA_montoLuz = "+pa.getMontoLuz()+","+
                " pagoA_montoGas = "+pa.getMontoGas()+","+
                " pagoA_montoImp = "+pa.getMontoImpuesto()+","+
                " pagoA_montoTotal = "+pa.getMontoTotal()+","+
                " pagoA_montoPago = "+pa.getMontoPagado()+","+
                " pagoA_completado = "+pa.isCompleto()+ 
                " WHERE pagoA_contratoID= "+pa.getContratoID()+" AND (SELECT MONTH(pagoA_fechaVencimiento)="+(mes+1)+") AND (SELECT YEAR(pagoA_fechaVencimiento)="+year+")";
    //    System.out.println("SQL = " + SQL);
       return (Main.Conexion.getInstance().EjecutarOperacion(SQL) >= 1 ); 
    }
    /**
     * recibe los id de los pagos rendidos
     * @param listaPagos
     * @return 
     */
    @Override
    public boolean marcarPagoRendido(ArrayList<Integer> listaPagos) {
        boolean bien = true;
        for(Integer i: listaPagos){
            String SQL = "UPDATE pagoalquiler SET pagoA_rendido=1 WHERE pagoA_id= "+i; 
            if(!(Main.Conexion.getInstance().EjecutarOperacion(SQL) >= 1)){
                bien=false;
            }
        }
        return bien;
    }
    
    
    
}
