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
public class TuplaInmProp {
    private int idProp;
    private String nombreInq;
    private String direccion;
    private float valRendir;
    private float valTotal;
    private int pagado;//si el inquilino pago
    private int rendido; //si le pagamos al dueño
    private int idPago;
    public TuplaInmProp(int idProp, String nombreInq, String direccion, float valRendir, float valTotal, int pagado, int rendido, int idPago) {
        this.idProp = idProp;
        this.nombreInq = nombreInq;
        this.direccion = direccion;
        this.valRendir = valRendir;
        this.valTotal = valTotal;
        this.pagado = pagado;
        this.rendido = rendido;
        this.idPago=idPago;
    }

    public int getRendido() {
        return rendido;
    }

    public void setRendido(int rendido) {
        this.rendido = rendido;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public String getNombreInq() {
        return nombreInq;
    }

    public void setNombreInq(String nombreInq) {
        this.nombreInq = nombreInq;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getValRendir() {
        return valRendir;
    }

    public void setValRendir(float valRendir) {
        this.valRendir = valRendir;
    }

    public float getValTotal() {
        return valTotal;
    }

    public void setValTotal(float valTotal) {
        this.valTotal = valTotal;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

}
