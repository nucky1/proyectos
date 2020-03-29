/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public interface CteDAO extends CRUD<Cliente> {
    ArrayList<Inmueble> getPropiedades(int id);
    ArrayList<Inmueble> getInmueblesDueño(int id);
    ArrayList<Inmueble> getAdministrando(int id);
    ArrayList<Cliente> listarPorNombre(String nombre);
    ArrayList<Cliente> listarDueniosPorNombre(String nombre);
    ArrayList<Inmueble> getInmueblesAlquilando(int id);
}
