/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author demig
 */
public class StyleCSS {
    
    public static Border getBordePanel(String title){
        return javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 60, 0)), title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14));
    }
    
    public static void setPlaceHolder(JTextField field,String texto){
        TextPrompt placeholder = new TextPrompt(texto, field);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
    }
}
