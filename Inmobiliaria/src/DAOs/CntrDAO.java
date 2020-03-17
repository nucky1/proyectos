/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Contrato;
import Modelo.TuplaDeudores;
import Modelo.TuplaInmProp;
import java.util.ArrayList;

/**
 *
 * @author Lucho
 */
public interface CntrDAO extends CRUD<Contrato>{
        public ArrayList<Contrato> buscarPorCliente(int ID,int tipo);
        public ArrayList<TuplaInmProp> listarInmueblesDuenio(int clienteID, int mes, int anio);
        public ArrayList<TuplaDeudores> listarDeudores(int duenioID);

}
