/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Asesor;
import Modelo.Contrato;
import Modelo.EstadisticasAsesor;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public interface AsesorView {
    public void llenarTabla(ArrayList<EstadisticasAsesor> lt); 
}
