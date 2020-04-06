/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
<<<<<<< HEAD
 * @author Lucho
=======
 * @author Pajin
>>>>>>> 9dd5224d855d80227af3a4c60c9a271ff856d76c
 */
public class Asesor {
    private int id;
    private String nombre;
    private long tel;

    public Asesor(int id, String nombre, long tel) {
        this.id=id;
        this.nombre=nombre;
        this.tel=tel;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
    
}
