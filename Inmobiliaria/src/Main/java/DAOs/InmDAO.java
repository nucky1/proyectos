/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author fran_
 */
public interface InmDAO extends CRUD<Inmueble>{
    Cliente getDuenio();
    Cliente getInquilino();
    void actualizarCliente(Cliente cliente);
    public ArrayList<Inmueble> listarInmueblesFiltros(float pDesde, float pHasta, int estado, int tipo, int operacion, int habitaciones);
    boolean setEstado(int id,int e);
    public ArrayList<Inmueble> buscarPorDuenio(int duenioID);

}
