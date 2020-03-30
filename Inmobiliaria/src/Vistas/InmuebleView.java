/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Inmueble;
import java.util.ArrayList;

/**
 *
 * @author Usuario1
 */
public interface InmuebleView {
    
    public void llenarTabla(ArrayList<Inmueble> listaI);
    
    public void detalles(Inmueble inm);
    
    public void filtros(int estado, int tipo, int zona, int habitacion, int precio, ArrayList<Inmueble> listaI);
    
    public void borrarInmueble();
    
    public void nuevoInmueble();
    
    public void modificarInmueble();
    
    public void cargarDatosInmueble(Inmueble inm);
    
    public void respuestaAlta(boolean exito);
}
