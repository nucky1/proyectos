/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lucho
 */
public class Inmueble {
    private int id;
    private int duenoID;
    private String direccion;
    private float precio; 
    private int tipo;
    private int estado;
    private String barrio; 
    
    private int habitaciones;
    private int bano;
    private boolean patio;

    private boolean cocina;
    private boolean comedor;
    private boolean living;
    private boolean cocinaLiving;
    private boolean cocinaComedor;
    private boolean cocinaLivingComedor;
    private float metros2;
    private float fondo;
    private boolean garage;
    
    private boolean plantaAlta;
    private boolean impuestos;
    private int servicios; /////cambia acaa, ninguno, solo luz, solo gas, ambas
    private double expensas; ////////este es nuevooooooooo
    private String observaciones;
    private String otros;
    private boolean lavadero;  
    private int operacion; // Vender, Alquilar
    private boolean amoblado;
    //AGREGADOS QUE FALTAN EN LA BD 
    private boolean agua;
    private boolean gas;
    private boolean luz;
    
    public Inmueble(){}
    
    public Inmueble(int id, int duenoID, String direccion, float precio, int tipo){
        this.id = id;
        this.duenoID = duenoID;
        this.direccion = direccion;
        this.precio = precio;
        this.tipo = tipo;
    }    

    public Inmueble(int id, int duenoID, String direccion, float precio, int operacion, int tipo, int estado, String barrio, int habitaciones, int bano, boolean patio, boolean amoblado, boolean lavadero, boolean cocina, boolean comedor, boolean living, boolean cocinaLiving, boolean cocinaComedor, boolean cocinaLivingComedor, float metros2, float fondo, boolean garage, boolean plantaAlta, boolean impuestos, int servicios, double expensas, String observaciones, String otros, boolean agua, boolean gas, boolean luz) {
        this.id = id;
        this.duenoID = duenoID;
        this.direccion = direccion;
        this.precio = precio;
        this.operacion = operacion;
        this.tipo = tipo;
        this.estado = estado;
        this.barrio = barrio;
        this.habitaciones = habitaciones;
        this.bano = bano;
        this.patio = patio;
        this.amoblado = amoblado;
        this.lavadero = lavadero;
        this.cocina = cocina;
        this.comedor = comedor;
        this.living = living;
        this.cocinaLiving = cocinaLiving;
        this.cocinaComedor = cocinaComedor;
        this.cocinaLivingComedor = cocinaLivingComedor;
        this.metros2 = metros2;
        this.fondo = fondo;
        this.garage = garage;
        this.plantaAlta = plantaAlta;
        this.impuestos = impuestos;
        this.servicios = servicios;
        this.expensas = expensas;
        this.observaciones = observaciones;
        this.otros = otros;
        this.agua = agua;
        this.gas = gas;
        this.luz = luz;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuenoID() {
        return duenoID;
    }

    public void setDuenoID(int duenoID) {
        this.duenoID = duenoID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBano() {
        return bano;
    }

    public void setBano(int bano) {
        this.bano = bano;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public boolean isAmoblado() {
        return amoblado;
    }

    public void setAmoblado(boolean amoblado) {
        this.amoblado = amoblado;
    }

    public boolean isLavadero() {
        return lavadero;
    }

    public void setLavadero(boolean lavadero) {
        this.lavadero = lavadero;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public boolean isComedor() {
        return comedor;
    }

    public void setComedor(boolean comedor) {
        this.comedor = comedor;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isCocinaLiving() {
        return cocinaLiving;
    }

    public void setCocinaLiving(boolean cocinaLiving) {
        this.cocinaLiving = cocinaLiving;
    }

    public boolean isCocinaComedor() {
        return cocinaComedor;
    }

    public void setCocinaComedor(boolean cocinaComedor) {
        this.cocinaComedor = cocinaComedor;
    }

    public boolean isCocinaLivingComedor() {
        return cocinaLivingComedor;
    }

    public void setCocinaLivingComedor(boolean cocinaLivingComedor) {
        this.cocinaLivingComedor = cocinaLivingComedor;
    }

    public float getMetros2() {
        return metros2;
    }

    public void setMetros2(float metros2) {
        this.metros2 = metros2;
    }

    public float getFondo() {
        return fondo;
    }

    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isPlantaAlta() {
        return plantaAlta;
    }

    public void setPlantaAlta(boolean plantaAlta) {
        this.plantaAlta = plantaAlta;
    }

    public boolean isImpuestos() {
        return impuestos;
    }

    public void setImpuestos(boolean impuestos) {
        this.impuestos = impuestos;
    }

    public int getServicios() {
        return servicios;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public double getExpensas() {
        return expensas;
    }

    public void setExpensas(double expensas) {
        this.expensas = expensas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public boolean isAgua() {
        return agua;
    }

    public boolean isGas() {
        return gas;
    }

    public boolean isLuz() {
        return luz;
    }
    
    
    public String toString(){
        return this.getId()+","+this.getDuenoID()+","+this.getDireccion()+","+this.getPrecio()+","+this.getTipo()+","+this.getEstado()+","+this.getHabitaciones()
                +","+this.getBano()+","+this.isPatio()+","+this.isCocina()+","+this.isLiving()+","+this.isComedor()+","+this.isCocinaLiving()+","+this.isCocinaComedor()
                +","+this.isCocinaLivingComedor()+","+this.getMetros2()+","+this.getFondo()+","+this.getBarrio()+","+this.isGarage()+","+this.isPlantaAlta()+","+this.isImpuestos()
                +","+this.getServicios()+","+this.getObservaciones()+","+this.getOtros();
    }
    
    
}
