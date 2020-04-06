/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.*;
import Vistas.*;
import java.util.ArrayList;
/**
 *
 * @author Lucho
 */
public class PagoAlDuenioController {
    PagoAlDuenioView view =null;
    
    public PagoAlDuenioController(PagoAlDuenioView view){
        this.view=view;
    }
    /**
     * Llena la tabla del buscar dueño
     * @param nombre 
     */
    public void llenarTabla(String nombre){
        view.llenarTablaC((new ClienteDAO()).listarDueniosPorNombre(nombre)); 
    }
    /**
     * get del porcentaje a rendir de
     */


    
    /**
     * Llena la tabla de los inmuebles del dueño teniendo en cuenta el mes seleccionado
     * @param clienteID
     * @param mes
     * @param anio 
     */
    public void llenarTablaInmueblesDuenio(int clienteID,int mes,int anio){ 
        view.llenarTablaInmueblesDuenio((new ContratoDAO()).listarInmueblesDuenio(clienteID,mes,anio));
    }
    /**
     * Llena la tabla de deudores teniendo en cuenta el dueño y el mes y año seleccionado.
     * @param clienteID
     * @param mes
     * @param anio 
     */
    public void llenarTablaDeudores(int clienteID,int mes,int anio){
        view.llenarTablaDeudores((new ContratoDAO()).listarDeudores(clienteID));
    }
    
    public void settearPagoRendido(ArrayList<Integer> idPagos){
        view.resultadoAltaPago((new PagoAlquilerDAO()).marcarPagoRendido(idPagos));
    }
    
}
