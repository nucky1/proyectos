/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.UsuarioDao;
import Vistas.ClientePanel;
import Vistas.LoginMVP;
import java.util.Observable;
import javafx.beans.InvalidationListener;

/**
 *
 * @author demig
 */
public class UsuarioController extends Observable implements LoginMVP.controller{
    private LoginMVP.dao mdao = new UsuarioDao(this);
    private LoginMVP.view mview;
    private boolean logueado = false;

    public UsuarioController( LoginMVP.view mview,ClientePanel observer) {
        this.mview = mview;
        this.addObserver(observer);
    }

    @Override
    public void probarInicio(String user, String pass) {
        mdao.iniciarSesion(user, pass);
    }

    @Override
    public void showResult(String error ,boolean result) {
        if(result){
            logueado = true;
            mview.showExit(1);
            setChanged();
            notifyObservers(logueado);
        }else{
            mview.showError(error);
        }
    }

    @Override
    public void salir() {
        logueado = false;
        mview.showExit(0);
        setChanged();
        notifyObservers(logueado);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
