/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.AsesorDAO;
import DAOs.ClienteDAO;
import DAOs.InmuebleDAO;
import Modelo.Cliente;
import Vistas.ClienteView;

/**
 *
 * @author Lucho
 */
public class ClienteController  {
    private ClienteView view=null;
    private ClienteDAO daoCliente = null;
    private AsesorDAO daoAsesor = null;
    private InmuebleDAO daoInmueble= null;
    
    public ClienteController(ClienteView view){
        this.view=view;
        this.daoCliente = new ClienteDAO();
        this.daoAsesor = new AsesorDAO();
        this.daoInmueble = new InmuebleDAO();
    }
    
    public void llenarTabla(String texto){
        view.llenarTablaClientes((daoCliente).listarPorNombre(texto));
    } 
     
    public void altaCliente(Cliente nuevo){ 
        view.respuestaAltaCliente((daoCliente).alta(nuevo)); 
    }
    
    public void modificarCliente(Cliente actualizado){ 
        view.respuestaModifCliente((daoCliente).modificar(actualizado)); 
    }
    public void deleteCliente(int clienteID){ 
        view.respuestaDeleteCliente((daoCliente).baja(clienteID)); 
    }
    
    public void llenarComboBox(){
        view.llenarAsesores((daoAsesor).listarTodo());
    }

    public void llenarTablaInmuebles(int idCliente) {
        view.llenarTablaInmuebles(daoCliente.getInmueblesDueño(idCliente),daoCliente.getInmueblesAlquilando(idCliente));
    }

    public void deleteInmueble(int inmuebleID) {
        view.respuestaDeleteInmueble(daoInmueble.baja(inmuebleID));
    }
    
    public void getCliente(int idCliente){
        view.cargarDatosClientes(daoCliente.buscar(idCliente));
    }
    
}
