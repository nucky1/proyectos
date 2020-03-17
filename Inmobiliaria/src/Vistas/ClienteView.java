/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Asesor;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Lucho
 */
public interface ClienteView {
    public void cargarClientes(ArrayList a);    
    public void llenarTabla(ArrayList<Cliente> listaC);
    public void llenarAsesores(ArrayList<Asesor> listaA); 
    public void respuestaAltaCliente(boolean exito);
}
