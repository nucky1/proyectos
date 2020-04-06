/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Inmueble;
import java.util.ArrayList;

/**
 *
 * @author Usuario1
 */
public class TestVista {
    
    private ArrayList<Inmueble> lista;
    private Inmueble inm;
    
    public TestVista(){
        lista = new ArrayList<Inmueble>();
        inm = new Inmueble(123,321,"asd",123,3210);
        lista.add(inm);
        inm = new Inmueble(231,213,"sda",231,2130);
        lista.add(inm);
        inm = new Inmueble(132,312,"ads",132,312);
        lista.add(inm);
        inm = new Inmueble(1234,4321,"fasd",4123,4321);
        lista.add(inm);
        inm = new Inmueble(5555,6666,"fran",4444,4444);
        lista.add(inm);
        
    }
    
    public ArrayList<Inmueble> getLista(){
        return this.lista;
    }
    
    
    
}
