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
 * @author fran_
 */
public interface HacerContratoView {
    
    public void llenarTablaClientes(ArrayList<Cliente> listaI);
    
    public void llenarCliente(Cliente inm);
    
    public void nuevoCliente();
    
    public void nuevoContratoAlquiler();
    
    public void llenarAsesores(ArrayList<Asesor> listaA);
    
    public void respuestaAlta(int alta);
    
}
