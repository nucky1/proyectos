/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.*;
import Modelo.Contrato;
import Modelo.Inmueble;
import Modelo.PagoAlquiler;
import Vistas.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fran_
 */
public class PagoAlquilerController {
    private PagoAlquilerView view = null;
    
    public PagoAlquilerController(PagoAlquilerView view){
        this.view=view;
    }
    
    /**
     * Setea la vista donde trabajara el controlador
     * @param vista 
     */
    public void setVista(PagoAlquilerView vista){ 
        this.view = vista;
    }
    
    /**
     * Recibe el nombre del cliente por parametro
     * Crea una lista de clientes con ese nombre
     * Le pasa esa lista al view para que llene la tabla de clientes
     * @param nombre 
     */
    public void llenarTabla(String nombre){
        view.llenarTabla((new ClienteDAO()).listarPorNombre(nombre)); 
    }
    
    /**
     * Recibe un ID de cliente por parametro
     * Crea una lista de contratos del cliente
     * Le pasa esa lista al view para que llene la tabla de contratos
     * @param idCliente 
     */
    public void llenarCamposContratos(int idCliente){
        ArrayList<Contrato> conts = (new ContratoDAO()).buscarPorCliente(idCliente,1);
        Inmueble inm = null;
        ArrayList<PagoAlquiler> pa = null;
        try{
            inm =(new InmuebleDAO()).buscar(conts.get(0).getInmuebleID());
            pa = (new PagoAlquilerDAO()).buscarPorContrato(conts.get(0).getId());
        }catch(IndexOutOfBoundsException ex){
            view.errorCargarContrato();
            return;
        }
        view.llenarCamposContrato(conts,inm.getDireccion(),inm.getPrecio(),pa);
    }
    
    /**
     * Recibe un ID de contrato por parametro
     * Crea una lista de pagos del contrato
     * Le pasa esa lista al view para que llene la tabla de pagos
     * @param idContrato 
     */
    public void llenarTablaPagos(int idContrato){
        view.llenarTablaPagos((new PagoAlquilerDAO()).buscarPorContrato(idContrato));
    }
    /**
     * Recibe los campos de la vista, llama al dao para insertar 
     */
    public void insertarPagoRealizado(Contrato cont,float valorAlq,float montoAPagar,int mesPago,int yearPago, Date fechaPago,float montoMes,float montoImp, float montoLuz,float montoLGas,float montoPunitorios,boolean completado){ 
        PagoAlquiler pa = new PagoAlquiler(0,cont.getId(),fechaPago,fechaPago,montoMes,montoLGas,montoLuz,montoPunitorios,montoImp,(montoAPagar+montoPunitorios+montoImp+montoLuz+montoLGas),(valorAlq+montoImp+montoLuz+montoLGas+montoPunitorios),completado);       
        view.resultadoAltaPago((new PagoAlquilerDAO()).insetarPagoAlq(pa,mesPago,yearPago));
    }
}
