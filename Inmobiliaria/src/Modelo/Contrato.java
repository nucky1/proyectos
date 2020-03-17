/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lucho
 */
public class Contrato {
    private int id;
    private Date fecha;
    private float comision;
    private String observaciones;
    private int clienteID;
    private int inmuebleID;
    private int duenoID;
    private int asesorID;
    private int tipo; // alquiler 1, venta 2, administracion 3
    private boolean adminPremium;
    private float adminPorcentajeAlq;
    private float alqAumento;
    private Date alqFechaFin;
    private int diaVen;
    private Date fechaInicio;
    private DateFormat fmtSQL = new SimpleDateFormat("yyyy-MM-dd");

    public Contrato(int id, Date fecha, float comision,String observaciones, int clienteID, int inmuebleID, int duenoID, int acesorID, int tipo, boolean adminPremium, float adminPorcentajeAlq, float alqAumento, Date alqFechaFin, int diaVen, Date fechaInicio) {
        this.id = id;
        this.fecha = fecha;
        this.comision = comision;
        this.observaciones = observaciones;
        this.clienteID = clienteID;
        this.inmuebleID = inmuebleID;
        this.duenoID = duenoID;
        this.asesorID = acesorID;
        this.tipo = tipo;
        this.adminPremium = adminPremium;
        this.adminPorcentajeAlq = adminPorcentajeAlq;
        this.alqAumento = alqAumento;
        this.alqFechaFin = alqFechaFin;
        this.diaVen = diaVen;
        this.fechaInicio = fechaInicio;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public String getFechaSQL() {
        return fmtSQL.format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public int getDuenoID() {
        return duenoID;
    }

    public void setDuenoID(int duenoID) {
        this.duenoID = duenoID;
    }

    public int getAcesorID() {
        return asesorID;
    }

    public void setAcesorID(int acesorID) {
        this.asesorID = acesorID;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isAdminPremium() {
        return adminPremium;
    }

    public void setAdminPremium(boolean adminPremium) {
        this.adminPremium = adminPremium;
    }

    public float getAdminPorcentajeAlq() {
        return adminPorcentajeAlq;
    }

    public void setAdminPorcentajeAlq(float adminPorcentajeAlq) {
        this.adminPorcentajeAlq = adminPorcentajeAlq;
    }

    public float getAlqAumento() {
        return alqAumento;
    }

    public void setAlqAumento(float alqAumento) {
        this.alqAumento = alqAumento;
    }

    public Date getAlqFechaFin() {
        return alqFechaFin;
    }
    
     public String getAlqFechaFinSQL() {
        return fmtSQL.format(this.alqFechaFin);
    }

    public void setAlqFechaFin(Date alqFechaFin) {
        this.alqFechaFin = alqFechaFin;
    }

    public int getDiaVen() {
        return diaVen;
    }

    public void setDiaVen(int diaVen) {
        this.diaVen = diaVen;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public String getFechaInicioSQL() {
        return fmtSQL.format(this.fechaInicio);
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public DateFormat getFmtSQL() {
        return fmtSQL;
    }

    public void setFmtSQL(DateFormat fmtSQL) {
        this.fmtSQL = fmtSQL;
    }

  
    
    
    
}
