/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;
import Modelo.Contrato;
import Modelo.PagoAlquiler;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Lucho
 */
public interface PalqDAO extends CRUD<PagoAlquiler>{
    public ArrayList<PagoAlquiler> buscarPorContrato(int ID); 
    public boolean insetarPagoAlq(PagoAlquiler pa,int mes,int year);
    public boolean altaNpagos(Contrato nuevo, float senia, float precioInicial, int periodo);
    public boolean marcarPagoRendido(ArrayList<Integer> listaPagos);
}
