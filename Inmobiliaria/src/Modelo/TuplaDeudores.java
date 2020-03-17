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
public class TuplaDeudores {
    private int clienteID;
    private int inmuebleID;
    private String nombreCliente;
    private long telCliente;
    private float deuda;
    private int cantMeses;

    public TuplaDeudores(int clienteID, int inmuebleID, String nombreCliente, long telCliente, float deuda, int cantMeses) {
        this.clienteID = clienteID;
        this.inmuebleID = inmuebleID;
        this.nombreCliente = nombreCliente;
        this.telCliente = telCliente;
        this.deuda = deuda;
        this.cantMeses = cantMeses;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getInmuebleID() {
        return inmuebleID;
    }

    public void setInmuebleID(int inmuebleID) {
        this.inmuebleID = inmuebleID;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public long getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(long telCliente) {
        this.telCliente = telCliente;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public int getCantMeses() {
        return cantMeses;
    }

    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }    
}
