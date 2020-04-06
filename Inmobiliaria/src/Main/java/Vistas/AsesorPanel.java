/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllers.AsesorController;
import Modelo.Asesor;
import Modelo.Contrato;
import Modelo.EstadisticasAsesor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author Usuario1
 */
public class AsesorPanel extends javax.swing.JPanel implements AsesorView {

             
    /**
     * Creates new form AsesorPanel
     */
    public AsesorPanel() {
        initComponents();
        mesDesde.setMonth(mesDesde.getMonth()-1);  
    }

    public void calcular(int mesDesde, int mesHasta, int anioDesde, int anioHasta){
        
        removeAll();
        initComponents();
        setPreferredSize(new java.awt.Dimension(1260, 1000));
        this.mesDesde.setMonth(this.mesDesde.getMonth()-1);
        AsesorController ac = new AsesorController(this);
        ac.listarTodo(mesDesde,mesHasta,anioDesde,anioHasta);
    }
    
   
    @Override
    public void llenarTabla(ArrayList<EstadisticasAsesor> lt){
        int j=0;
        float max1=1,max2=1,max3=1,max4=1,max5=0;
       
        for(EstadisticasAsesor l : lt){
            System.out.println(""+l);
            if(l.getComision()>max1){
                max1 = l.getComision();
            }
            if(l.getCantInquilinos()>max2){
                max2 = l.getCantInquilinos();
            }
            if(l.getCantInmuebles()>max3){
                max3 = l.getCantInmuebles();
            }
            if(l.getCantCapto()>max4){
                max4 = l.getCantCapto();
            }
        }
               
        for(EstadisticasAsesor i : lt){
            JLabel nombreAss = new JLabel();
            JLabel barra1 = new JLabel();
            JLabel barra2 = new JLabel();
            JLabel barra3 = new JLabel();
            JLabel barra4 = new JLabel();
            JLabel cant1 = new JLabel();
            JLabel cant2 = new JLabel();
            JLabel cant3 = new JLabel();
            JLabel cant4 = new JLabel();
            
            cant1.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
            cant1.setForeground(new java.awt.Color(255, 255, 255));
            cant1.setText(String.valueOf(i.getComision()));
            add(cant1);
            cant1.setBounds(170, 260+40*j, 90, 40);

            cant2.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
            cant2.setForeground(new java.awt.Color(255, 255, 255));
            cant2.setText(String.valueOf(i.getCantInquilinos()));
            add(cant2);
            cant2.setBounds(530, 260+40*j, 90, 40);

            cant3.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
            cant3.setForeground(new java.awt.Color(255, 255, 255));
            cant3.setText(String.valueOf(i.getCantInmuebles()));
            add(cant3);
            cant3.setBounds(780, 260+40*j, 90, 40);
            
            cant4.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
            cant4.setForeground(new java.awt.Color(255, 255, 255));
            cant4.setText(String.valueOf(i.getCantCapto()));
            add(cant4);
            cant4.setBounds(1030, 260+40*j, 90, 40);

            nombreAss.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
            nombreAss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            nombreAss.setText(i.getNombre());
            nombreAss.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            add(nombreAss);
            nombreAss.setBounds(0, 260+40*j, 150, 40);

            if(j%2 == 0){
                barra1.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(255, 120, 0)));
                barra2.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(255, 120, 0)));
                barra3.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(255, 120, 0)));
                barra4.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(255, 120, 0)));
            }
            else{
                barra1.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(160, 160, 160)));
                barra2.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(160, 160, 160)));
                barra3.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(160, 160, 160)));
                barra4.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 1, 1, 1, new java.awt.Color(160, 160, 160)));
                
            }
            add(barra1);
            barra1.setBounds(160, 260+40*j, (int)(50+(290*(i.getComision()/max1))), 40);
            add(barra2);
            barra2.setBounds(520, 260+40*j, (int)(50+(180*(i.getCantInquilinos()/max2))), 40);
            add(barra3);
            barra3.setBounds(770, 260+40*j, (int)(50+(180*(i.getCantInmuebles()/max3))), 40);
            add(barra4);
            barra4.setBounds(1020, 260+40*j, (int)(50+(180*(i.getCantCapto()/max4))), 40);
            
            if(max5<(i.getComision()/max1)+(i.getCantInquilinos()/max2)+(i.getCantInmuebles()/max3)+(i.getCantCapto()/max4)){
                labelDestacado.setText("DESTACADO: "+i.getNombre());
                max5=(i.getComision()/max1)+(i.getCantInquilinos()/max2)+(i.getCantInmuebles()/max3)+(i.getCantCapto()/max4);
            }
            
            labelAsesor.setBounds(0, 220, 150, 120+40*j);
            labelGanancia.setBounds(150, 220, 360, 120+40*j);
            labelAlquiler.setBounds(510, 220, 250, 120+40*j);
            labelVenta1.setBounds(760, 220, 250, 120+40*j);
            labelVenta.setBounds(1010, 220, 250, 120+40*j);
        
            setPreferredSize(new java.awt.Dimension(1260, 300+j*40));
            
            j++;
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelAsesor = new javax.swing.JLabel();
        labelVenta = new javax.swing.JLabel();
        labelGanancia = new javax.swing.JLabel();
        labelAlquiler = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mesDesde = new com.toedter.calendar.JMonthChooser();
        anioDesde = new com.toedter.calendar.JYearChooser();
        mesHasta = new com.toedter.calendar.JMonthChooser();
        anioHasta = new com.toedter.calendar.JYearChooser();
        botonCalcular = new javax.swing.JButton();
        labelDesde = new javax.swing.JLabel();
        labelHasta = new javax.swing.JLabel();
        labelVenta1 = new javax.swing.JLabel();
        labelDestacado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Tabla De Estadisticas");
        labelTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0), 2));
        add(labelTitulo);
        labelTitulo.setBounds(0, 100, 1260, 50);

        labelAsesor.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelAsesor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAsesor.setText("Asesor");
        labelAsesor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAsesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(labelAsesor);
        labelAsesor.setBounds(0, 220, 150, 80);

        labelVenta.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVenta.setText("Clientes Captados");
        labelVenta.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(labelVenta);
        labelVenta.setBounds(1010, 220, 250, 80);

        labelGanancia.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelGanancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGanancia.setText("Total de Ganancias");
        labelGanancia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelGanancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(labelGanancia);
        labelGanancia.setBounds(150, 220, 360, 80);

        labelAlquiler.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelAlquiler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAlquiler.setText("Alquileres Realizados");
        labelAlquiler.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAlquiler.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(labelAlquiler);
        labelAlquiler.setBounds(510, 220, 250, 80);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CapturaInfo.PNG"))); // NOI18N
        jLabel1.setText("INVERSIONES MERCEDES ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0), 2));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1260, 100);
        add(mesDesde);
        mesDesde.setBounds(100, 160, 120, 50);
        add(anioDesde);
        anioDesde.setBounds(230, 160, 120, 50);
        add(mesHasta);
        mesHasta.setBounds(470, 160, 120, 50);
        add(anioHasta);
        anioHasta.setBounds(600, 160, 120, 50);

        botonCalcular.setText("CALCULAR");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        add(botonCalcular);
        botonCalcular.setBounds(760, 160, 160, 50);

        labelDesde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDesde.setText("DESDE");
        labelDesde.setAutoscrolls(true);
        add(labelDesde);
        labelDesde.setBounds(0, 160, 100, 50);

        labelHasta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHasta.setText("HASTA");
        add(labelHasta);
        labelHasta.setBounds(370, 160, 100, 50);

        labelVenta1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelVenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVenta1.setText("Ventas Realizadas");
        labelVenta1.setToolTipText("");
        labelVenta1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelVenta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(labelVenta1);
        labelVenta1.setBounds(760, 220, 250, 80);

        labelDestacado.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        labelDestacado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDestacado.setText("DESTACADO: ");
        add(labelDestacado);
        labelDestacado.setBounds(1010, 160, 250, 50);
    }// </editor-fold>//GEN-END:initComponents
    

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        calcular(mesDesde.getMonth(),mesHasta.getMonth(),anioDesde.getYear(),anioHasta.getYear());
    }//GEN-LAST:event_botonCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser anioDesde;
    private com.toedter.calendar.JYearChooser anioHasta;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAlquiler;
    private javax.swing.JLabel labelAsesor;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelDestacado;
    private javax.swing.JLabel labelGanancia;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVenta;
    private javax.swing.JLabel labelVenta1;
    private com.toedter.calendar.JMonthChooser mesDesde;
    private com.toedter.calendar.JMonthChooser mesHasta;
    // End of variables declaration//GEN-END:variables
}
