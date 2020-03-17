/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import Modelo.PagoAlquiler;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public interface PagoAlquilerView {
     public void llenarTabla(ArrayList<Cliente> listaC);
     public void llenarCamposContrato(ArrayList<Contrato> listaCon,String Direc, float valorAlq,ArrayList<PagoAlquiler> pa);
     public void llenarTablaPagos(ArrayList<PagoAlquiler> listaA);
     public void resultadoAltaPago(boolean exito);
     public void errorCargarContrato();
}
