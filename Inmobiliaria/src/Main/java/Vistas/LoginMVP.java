/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import DAOs.CRUD;
import Modelo.Usuario;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author demig
 */
public interface LoginMVP {
    interface view{
        /**
         * operationType = 0 implica salida exitosa 
         * operationType = 1 implica login exitoso
         * @param operationType 
         */
        void showExit(int operationType);
        /**
         * imprime un cartel con el error enviado por string
         * @param error 
         */
        void showError(String error);
    }
    interface controller{
        void probarInicio(String user, String pass);
        /**
         * Realiza las activaciones necesarias si el result es true
         * caso contrario llama a showError de la view
         * puede ser que tengas otra forma de trabajar o distintos parametros
         * segun el problema
         * @param error
         * @param result 
         */
        void showResult(String error ,boolean result);
        /**
         * Realiza todas las desactivaciones necesarias por dejar de ser adm
         */
        void salir();
    }
    interface dao extends CRUD<Usuario>{
        /**
         * Consulta la bd y nada mas!
         * @param user
         * @param pass 
         */
        void iniciarSesion(String user, String pass);
        /**
         * Se encarga de resolver que metodo llamar desde el controller
         * en el caso de que tengas mas de un metodo poner un int en vez
         * de un boolean y switch segun el tipo de estructura que se
         * necesite llenar con los datos del rs por cada operacion.
         * @param res 
         * @param todoOk 
         */
        void processResult(boolean todoOk, ResultSet res);
    }
}
