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
public class Cliente implements Comparable{
    private int id;
    private int asesorID;
    private String nombre;
    private int documento;
    private int tipoDoc;
    private long tel;
    private String contacto;

    public Cliente(int id,int asesorID, String nombre, int documento, int tipoDoc, long tel, String contacto){
        this.id=id;
        this.asesorID=asesorID;
        this.nombre=nombre;
        this.documento=documento;
        this.tipoDoc=tipoDoc;
        this.tel=tel;
        this.contacto=contacto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsesorID() {
        return asesorID;
    }

    public void setAsesorID(int acesorID) {
        this.asesorID = acesorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(int tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public int compareTo(Object o) {
        return (this.documento - ((Cliente)o).getDocumento());
    }
    
}
