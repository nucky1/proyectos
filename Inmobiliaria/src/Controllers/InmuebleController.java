/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.ContratoDAO;
import DAOs.InmuebleDAO;
import Modelo.Inmueble;
import java.util.ArrayList;
import Vistas.InmuebleView;
/**
 *
 * @author fran_
 */
public class InmuebleController {
    private InmuebleView view = null;
    
    public InmuebleController(InmuebleView view){
        this.view=view;
    }
    
    /**
     * Setea la vista donde trabajara el controller
     * @param vista 
     */
    public void setVista(InmuebleView vista){ 
        this.view = vista;
    }
    
    /**
     * Crea una lista de inmuebles desde la base de datos
     * Le pasa la lista al view para que llene la tabla de inmuebles
     */
    public void cargarInmuebles(int desdite, int hastita, int tipito, int operacioncita, int estadito, int habitacioncita){
        ArrayList<Inmueble> listarTodo = (new InmuebleDAO()).listarTodo();
        ArrayList<Inmueble> listarTodito = new ArrayList<>();
        listarTodo.stream().filter((inm) -> ((tipito==0 || tipito==inm.getTipo()) && (operacioncita==0 || inm.getOperacion() ==3  || operacioncita==inm.getOperacion()) && (estadito==0 || estadito==inm.getEstado()))).filter((inm) -> ((desdite<inm.getPrecio() && inm.getPrecio()<hastita) && (habitacioncita==0 || habitacioncita*inm.getHabitaciones()>25 || habitacioncita==inm.getHabitaciones()))).forEachOrdered((inm) -> {
            listarTodito.add(inm);
        });
         view.llenarTabla(listarTodito);
    }
    
    public void setReservado(int id){
        (new InmuebleDAO()).setEstado(id,3);
    }
    
    /**
     * Recibe un Inmueble por parametro y lo da de alta en la base de datos
     * Retorna verdadero si el alta tuvo exito
     * @param nuevo
     * @return 
     */
    public boolean alta(Inmueble nuevo){
        return (new InmuebleDAO()).alta(nuevo);
    }
    
    /**
     * Recibe un inmueble modificado y lo actualiza en la base de datos
     * Retorna verdadero si la modificacion tuvo exito
     * @param nuevo
     * @return 
     */
    public boolean modificar(Inmueble nuevo){
        return (new InmuebleDAO()).modificar(nuevo);
    }
    
    
    public boolean estaAdministrado(int clienteID){
        return (new ContratoDAO()).clienteTipoContrato(clienteID, 3);
    }
    
}
