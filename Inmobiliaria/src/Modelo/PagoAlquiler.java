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
public class PagoAlquiler {
    private int id;
    private int contratoID;
    private Date fechaPago;
    private Date fechaVenc;
    private float montoMes;
    private float montoGas;
    private float montoLuz;
    private float punitorios;
    private float montoImpuesto;
    private float montoTotal;
    private float montoPagado;
    private DateFormat fmtSQL = new SimpleDateFormat("yyyy-MM-dd");
    private boolean completo;

    public PagoAlquiler(int id, int contratoID, Date fechaPago, Date fechaVenc, float montoMes, float montoGas, float montoLuz, float punitorios, float montoImpuesto, float montoTotal, float montoPagado, boolean completo) {
        this.id = id;
        this.contratoID = contratoID;
        this.fechaPago = fechaPago;
        this.fechaVenc = fechaVenc;
        this.montoMes = montoMes;
        this.montoGas = montoGas;
        this.montoLuz = montoLuz;
        this.punitorios = punitorios;
        this.montoImpuesto = montoImpuesto;
        this.montoTotal = montoTotal;
        this.montoPagado = montoPagado;
        this.completo = completo;
    }

    public float getMontoMes() {
        return montoMes;
    }

    public void setMontoMes(float montoMes) {
        this.montoMes = montoMes;
    }

    public DateFormat getFmtSQL() {
        return fmtSQL;
    }

    public void setFmtSQL(DateFormat fmtSQL) {
        this.fmtSQL = fmtSQL;
    }

    

    public boolean isCompleto() {
        return completo;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContratoID() {
        return contratoID;
    }

    public void setContratoID(int contratoID) {
        this.contratoID = contratoID;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public String getFechaPagoSQL() {
        return fmtSQL.format(fechaPago);
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public float getMontoGas() {
        return montoGas;
    }

    public void setMontoGas(float montoGas) {
        this.montoGas = montoGas;
    }

    public float getMontoLuz() {
        return montoLuz;
    }

    public void setMontoLuz(float montoLuz) {
        this.montoLuz = montoLuz;
    }

    public float getPunitorios() {
        return punitorios;
    }

    public void setPunitorios(float punitorios) {
        this.punitorios = punitorios;
    }

    public float getMontoImpuesto() {
        return montoImpuesto;
    }

    public void setMontoImpuesto(float montoImpuesto) {
        this.montoImpuesto = montoImpuesto;
    }
            
}
