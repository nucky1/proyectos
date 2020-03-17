/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Asesor;
import Modelo.EstadisticasAsesor;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fran_
 */
public interface EstadisticasAseDAO {
    public ArrayList<EstadisticasAsesor> getEstadisticas(int mesDesde, int mesHasta, int anioDesde, int anioHasta);
   // public ArrayList<EstadisticasAsesor> listarPorFechas(Date inicio, Date fin);
}
