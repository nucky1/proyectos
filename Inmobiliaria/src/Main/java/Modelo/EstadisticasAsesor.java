/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fran_
 */
public class EstadisticasAsesor {
    //private int idAsesor;
    private String nombre;
    private float comision;
    private int cantInmuebles;
    private int cantInquilinos;
    private int cantCapto;

    public EstadisticasAsesor(String nombre, float comision, int cantInmuebles, int cantInquilinos,int cantCapto) {
        this.nombre = nombre;
        this.comision = comision;
        this.cantInmuebles = cantInmuebles;
        this.cantInquilinos = cantInquilinos;
        this.cantCapto=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getCantInmuebles() {
        return cantInmuebles;
    }

    public void setCantInmuebles(int cantInmuebles) {
        this.cantInmuebles = cantInmuebles;
    }

    public int getCantInquilinos() {
        return cantInquilinos;
    }

    public void setCantInquilinos(int cantInquilinos) {
        this.cantInquilinos = cantInquilinos;
    }
    
    public int getCantCapto() {
        return cantCapto;
    }

    public void setCantCapto(int cantInquilinos) {
        this.cantCapto = cantInquilinos;
    }

    @Override
    public String toString() {
        return "EstadisticasAsesor{" + "nombre=" + nombre + ", comision=" + comision + ", cantInmuebles=" + cantInmuebles + ", cantInquilinos=" + cantInquilinos + ", cantCapto=" + cantCapto + '}';
    }
    
    
    
}
