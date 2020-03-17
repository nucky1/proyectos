/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Asesor;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public interface AseDAO extends CRUD<Asesor> {
    ArrayList<Asesor> listarPorNombre(String nombre);
}

