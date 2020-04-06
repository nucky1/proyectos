/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Cliente;
import Modelo.TuplaDeudores;
import Modelo.TuplaInmProp;
import java.util.ArrayList;

/**
 *
 * @author Lucho
 */
public interface PagoAlDuenioView {
     public void llenarTablaC(ArrayList<Cliente> ctes);
     public void llenarTablaDeudores(ArrayList<TuplaDeudores> ctes);
     public void llenarTablaInmueblesDuenio(ArrayList<TuplaInmProp> tupla);
     public void resultadoAltaPago(boolean exito);

}
