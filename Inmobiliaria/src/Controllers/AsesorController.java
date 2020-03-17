/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.EstadisticasAsesorDAO;
import Vistas.AsesorView;

/**
 *
 * @author fran_
 */
public class AsesorController {
    private AsesorView view=null;
    
    public AsesorController(AsesorView view){
        this.view=view;
    }
    public void listarTodo(int mesDesde, int mesHasta, int anioDesde, int anioHasta){
       view.llenarTabla((new EstadisticasAsesorDAO()).getEstadisticas(mesDesde, mesHasta, anioDesde, anioHasta));  
    }
    
}
