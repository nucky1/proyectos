/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.UsuarioDao;
import Vistas.LoginMVP;

/**
 *
 * @author demig
 */
public class UsuarioController implements LoginMVP.controller{
    private LoginMVP.dao mdao = new UsuarioDao(this);
    private LoginMVP.view mview;

    public UsuarioController(LoginMVP.view mview) {
        this.mview = mview;
    }

    @Override
    public void probarInicio(String user, String pass) {
        mdao.iniciarSesion(user, pass);
    }

    @Override
    public void showResult(String error ,boolean result) {
        if(result){
            mview.showExit(1);
        }else{
            mview.showError(error);
        }
    }

    @Override
    public void salir() {
        boolean exito = true;
        // codigo para desactivar cosas de admin
        if(exito){
            mview.showExit(0);
        }else{
            mview.showError("No se pudo salir de la sesion");
        }
    }
}
