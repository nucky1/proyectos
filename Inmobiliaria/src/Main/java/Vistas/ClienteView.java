/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Asesor;
import Modelo.Cliente;
import Modelo.Inmueble;
import java.util.ArrayList;

/**
 *
 * @author Lucho
 */
public interface ClienteView {
    public void cargarClientes(ArrayList a);    
    public void llenarTablaClientes(ArrayList<Cliente> listaC);
    public void llenarAsesores(ArrayList<Asesor> listaA); 
    public void respuestaAltaCliente(boolean exito);
    public void respuestaModifCliente(boolean exito);
    public void respuestaDeleteCliente(boolean exito);
    public void cargarDatosClientes(Cliente cte);
    public void llenarTablaInmuebles(ArrayList<Inmueble> inmueblesDueño, ArrayList<Inmueble> inmueblesAlquilando);

    public void respuestaDeleteInmueble(boolean baja);
}
