/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.ContratoDAO;
import Modelo.Contrato;
import Vistas.ContratoView;

/**
 *
 * @author fran_
 */
public class ContratoController {
    private ContratoView view = null;
    
    public ContratoController(ContratoView vista){ 
        this.view=vista;
    }
    /**
     * Setea la vista donde trabajara el Controller
     * @param vista 
     */
    public void setVista(ContratoView vista){ 
        this.view = vista;
    }
    
    /**
     * Crea una lista de contratos desde la base de datos
     * Le pasa la lista por parametros al view para que llene la lista de contratos
     */
    public void cargarContratos(){
        view.llenarTabla((new ContratoDAO()).listarTodo());
    }
    public boolean alta(Contrato nuevo){
        return (new ContratoDAO()).alta(nuevo);
    }
    
    public boolean modificar(Contrato nuevo){
        return (new ContratoDAO()).modificar(nuevo);
    }
}
