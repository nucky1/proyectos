/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.AsesorDAO;
import DAOs.ClienteDAO;
import Modelo.Cliente;
import Vistas.ClienteView;

/**
 *
 * @author Lucho
 */
public class ClienteController  {
    private ClienteView view=null;
    
    public ClienteController(ClienteView view){
        this.view=view;
    }
    
    public void llenarTabla(String texto){
        view.llenarTabla((new ClienteDAO()).listarPorNombre(texto));
    } 
     
    public void altaCliente(Cliente nuevo){ 
        view.respuestaAltaCliente((new ClienteDAO()).alta(nuevo)); 
    }
    
    public void llenarComboBox(){
        view.llenarAsesores((new AsesorDAO()).listarTodo());
    }
    
}
