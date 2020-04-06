/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Asesor;
import Modelo.Usuario;
import Vistas.LoginMVP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author demig
 */
public class UsuarioDao implements LoginMVP.dao{
    private LoginMVP.controller mController;

    public UsuarioDao(LoginMVP.controller mController) {
        this.mController = mController;
    }
    
    @Override
    public void iniciarSesion(String user, String pass) {
        String SQL = "SELECT usuario, contraseña FROM usuario WHERE usuario = '"+user+"' AND contraseña = '"+pass+"'";
        ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
        try {
            if(rs.next())
                processResult(true, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
            processResult(false, rs);
        }
        
    }

    @Override
    public ArrayList<Usuario> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargar(ArrayList<Usuario> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alta(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean baja(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processResult(boolean todoOk, ResultSet res) {
        String error = "";
        //esto probablemente seria distinto para cada metodo que llamemos except
        //la parte del ex
        if(todoOk){
            mController.showResult(error, todoOk);
        }else{
            mController.showResult(error, todoOk);
        }
    }
    
}
