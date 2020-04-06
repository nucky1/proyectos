/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author fran_
 */
public interface CRUD <T>{
    ArrayList<T> listarTodo();
    abstract void cargar(ArrayList<T> t);
    abstract boolean alta(T t);
    abstract boolean baja(int ID);
    abstract boolean modificar(T t);
    abstract T buscar(int ID);
}
