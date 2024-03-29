/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Usuario1
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private ClientePanel cp;
    private PagoAlquilerPanel ppa;
    private InmueblePanel ip;
    private JTabbedPane miTab;
    private Login miPanel;
    private AsesorPanel ap;
    private JScrollPane miOtroScroll;    
    private JScrollPane miOtroScrol2;   
    private JScrollPane miOtroScrol3;
    private JScrollPane miOtroScrol4;
    private JScrollPane miScroll;
    private PagoAlDuenioPanel pdp;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        //initComponents();
        setTitle("IM Inmobiliaria");
        setSize(1280,720);
        setLocationRelativeTo(null);
        init2();               
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(780, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void init2(){       
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         
        
        ip = new InmueblePanel();
        ip.setLayout(null);
        ip.setPreferredSize(new Dimension(1260,660));
        
        miOtroScroll = new JScrollPane();
        miOtroScroll.setBounds(5, 10, 380, 150);
        miOtroScroll.setViewportView(ip);
        
        cp = new ClientePanel();
        cp.setLayout(null);
        cp.setPreferredSize(new Dimension(1260,660));
        
        miOtroScrol2 = new JScrollPane();
        miOtroScrol2.setBounds(5, 10, 380, 150);
        miOtroScrol2.setViewportView(cp);
        
        ppa = new PagoAlquilerPanel();
        ppa.setLayout(null);
        ppa.setPreferredSize(new Dimension(1260,660));
        
        pdp = new PagoAlDuenioPanel();
        pdp.setLayout(null);
        pdp.setPreferredSize(new Dimension(1260,660));
        
       
        miOtroScrol3 = new JScrollPane();
        miOtroScrol3.setBounds(5, 10, 380, 150);
        miOtroScrol3.setViewportView(ppa);
        
        ap = new AsesorPanel();
        ap.setLayout(null);
        
        miOtroScrol4 = new JScrollPane();
        miOtroScrol4.setBounds(5, 10, 380, 150);
        miOtroScrol4.setViewportView(ap);
        
        miPanel = new Login(cp);
        miPanel.setLayout(null);
        miPanel.setPreferredSize(new Dimension(1260,660));
        
        miScroll = new JScrollPane();
        miScroll.setBounds(5, 10, 380, 150);
        miScroll.setViewportView(miPanel);
        miTab = new JTabbedPane();
        miTab.addTab("Principal", miScroll);
        miTab.addTab("Inmueble", miOtroScroll);
        miTab.addTab("Cliente", miOtroScrol2);
        miTab.addTab("Pago Alquiler", miOtroScrol3);
        miTab.addTab("Estadisticas de Asesores", miOtroScrol4);
        miTab.addTab("Rendir Pagos al dueño", pdp);
        //miTab.setBackground(Color.WHITE);
        //jTabbedPane1.addTab("tab2", jPanel2);
        
        add(miTab);
        
        pack();
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
