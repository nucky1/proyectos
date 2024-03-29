/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllers.InmuebleController;
import Modelo.Inmueble;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario1
 */
public class InmueblePanel extends javax.swing.JPanel implements InmuebleView {
    
    private TestVista tv;
    private HashMap<Integer,Inmueble> mapI =null;
    private final HashMap<Integer,String> tipoInmueble;
    private final HashMap<Integer,String> operacion;
    private final HashMap<Integer,String> estado;
    /**
     * Creates new form NewJPanel
     */
    public InmueblePanel() {
        initComponents();
        SpinnerNumberModel smHasta = new SpinnerNumberModel();
        smHasta.setStepSize(100);
        smHasta.setValue(20000);
        SpinnerNumberModel smDesde = new SpinnerNumberModel();
        smDesde.setStepSize(100);
        smDesde.setValue(0);
        spinDesde.setModel(smDesde);
        spinHasta.setModel(smHasta);
        tipoInmueble = new HashMap<>();
        tipoInmueble.put(0,null);
        tipoInmueble.put(1,"Casa");
        tipoInmueble.put(2,"Departamento");
        tipoInmueble.put(3,"Local");
        tipoInmueble.put(4,"Terreno");
        operacion = new HashMap<>();
        operacion.put(0,null);
        operacion.put(1,"Vender");
        operacion.put(2,"Alquilar");
        estado = new HashMap<>();
        estado.put(0,null);
        estado.put(1,"Disponible");
        estado.put(2,"No Disponible");
        estado.put(3,"Reservado");
        estado.put(4,"Ocupado");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInmueble = new javax.swing.JTable();
        jcbEstado = new javax.swing.JComboBox<>();
        jcbHabitaciones = new javax.swing.JComboBox<>();
        botonListar = new javax.swing.JButton();
        jcbOperacion = new javax.swing.JComboBox<>();
        jcbTipoInmueble = new javax.swing.JComboBox<>();
        spinDesde = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spinHasta = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        botonAlquilar = new javax.swing.JButton();
        botonDetalles = new javax.swing.JButton();
        jcbZona = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonAlquilar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CapturaInfo.PNG"))); // NOI18N
        jLabel1.setText("INVERSIONES MERCEDES ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0), 2));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1260, 90);

        tablaInmueble.setBackground(new java.awt.Color(255, 204, 102));
        tablaInmueble.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaInmueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Direccion", "Zona", "Precio", "Tipo de Inmueble", "Operacion", "Estado", "Habitaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInmueble.setAutoscrolls(false);
        tablaInmueble.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaInmueble);
        if (tablaInmueble.getColumnModel().getColumnCount() > 0) {
            tablaInmueble.getColumnModel().getColumn(0).setMinWidth(50);
            tablaInmueble.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaInmueble.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaInmueble.getColumnModel().getColumn(1).setMinWidth(250);
            tablaInmueble.getColumnModel().getColumn(1).setMaxWidth(250);
            tablaInmueble.getColumnModel().getColumn(2).setMinWidth(120);
            tablaInmueble.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablaInmueble.getColumnModel().getColumn(4).setMinWidth(120);
            tablaInmueble.getColumnModel().getColumn(4).setPreferredWidth(120);
            tablaInmueble.getColumnModel().getColumn(5).setMinWidth(120);
            tablaInmueble.getColumnModel().getColumn(5).setPreferredWidth(120);
            tablaInmueble.getColumnModel().getColumn(6).setMinWidth(120);
            tablaInmueble.getColumnModel().getColumn(6).setPreferredWidth(120);
            tablaInmueble.getColumnModel().getColumn(7).setMinWidth(120);
            tablaInmueble.getColumnModel().getColumn(7).setPreferredWidth(120);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(200, 150, 1050, 410);

        jcbEstado.setBackground(new java.awt.Color(255, 200, 0));
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Disponible", "No disponible", "Reservado", "Ocupado" }));
        add(jcbEstado);
        jcbEstado.setBounds(80, 300, 110, 40);

        jcbHabitaciones.setBackground(new java.awt.Color(255, 200, 0));
        jcbHabitaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitaciones", "1 Habitacion", "2 Habitaciones", "3 Habitaciones", "4 Habitaciones", "5 o más Hab." }));
        add(jcbHabitaciones);
        jcbHabitaciones.setBounds(80, 360, 110, 40);

        botonListar.setBackground(new java.awt.Color(255, 200, 0));
        botonListar.setText("Buscar");
        botonListar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarActionPerformed(evt);
            }
        });
        add(botonListar);
        botonListar.setBounds(30, 560, 150, 50);

        jcbOperacion.setBackground(new java.awt.Color(255, 200, 0));
        jcbOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operacion", "Vender", "Alquilar", "Vender o Alquilar" }));
        jcbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOperacionActionPerformed(evt);
            }
        });
        add(jcbOperacion);
        jcbOperacion.setBounds(80, 240, 110, 40);

        jcbTipoInmueble.setBackground(new java.awt.Color(255, 200, 0));
        jcbTipoInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Inmueble", "Casa", "Departamento", "Local", "Terreno" }));
        jcbTipoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoInmuebleActionPerformed(evt);
            }
        });
        add(jcbTipoInmueble);
        jcbTipoInmueble.setBounds(80, 180, 110, 40);

        spinDesde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(spinDesde);
        spinDesde.setBounds(340, 110, 90, 30);

        jLabel2.setBackground(new java.awt.Color(255, 200, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("$");
        add(jLabel2);
        jLabel2.setBounds(480, 110, 20, 30);

        spinHasta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(spinHasta);
        spinHasta.setBounds(500, 110, 90, 30);

        jLabel3.setBackground(new java.awt.Color(255, 200, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CasitaLupa.PNG"))); // NOI18N
        jLabel3.setText("Filtros de Buscqueda");
        add(jLabel3);
        jLabel3.setBounds(10, 110, 180, 30);

        botonAlquilar.setBackground(new java.awt.Color(255, 100, 0));
        botonAlquilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CasitaAlquiler.PNG"))); // NOI18N
        botonAlquilar.setText("Alquilar");
        botonAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlquilarActionPerformed(evt);
            }
        });
        add(botonAlquilar);
        botonAlquilar.setBounds(900, 570, 140, 49);

        botonDetalles.setBackground(new java.awt.Color(255, 200, 0));
        botonDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CasaCaja.PNG"))); // NOI18N
        botonDetalles.setText("Informacion");
        botonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetallesActionPerformed(evt);
            }
        });
        add(botonDetalles);
        botonDetalles.setBounds(705, 570, 140, 50);

        jcbZona.setBackground(new java.awt.Color(255, 200, 0));
        jcbZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zona", "Centro", "Sur", "Norte", "Este", "Oeste", "Universitaria" }));
        jcbZona.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jcbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbZonaActionPerformed(evt);
            }
        });
        add(jcbZona);
        jcbZona.setBounds(80, 420, 110, 40);

        jLabel6.setBackground(new java.awt.Color(255, 200, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Ubicacion.PNG"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(10, 420, 60, 40);
        add(jSeparator1);
        jSeparator1.setBounds(10, 150, 180, 20);

        jLabel7.setBackground(new java.awt.Color(255, 200, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Casita$.PNG"))); // NOI18N
        jLabel7.setText("Precio");
        add(jLabel7);
        jLabel7.setBounds(200, 110, 110, 30);

        jLabel8.setBackground(new java.awt.Color(255, 200, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/TipoInmueble.PNG"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(10, 180, 60, 40);

        jLabel9.setBackground(new java.awt.Color(255, 200, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Operacion.PNG"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(10, 240, 60, 40);

        jLabel10.setBackground(new java.awt.Color(255, 200, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Llave.PNG"))); // NOI18N
        add(jLabel10);
        jLabel10.setBounds(10, 300, 60, 40);

        jLabel11.setBackground(new java.awt.Color(255, 200, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Camita.PNG"))); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(10, 360, 60, 40);

        botonAlquilar1.setBackground(new java.awt.Color(102, 102, 0));
        botonAlquilar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CasitaVenta.PNG"))); // NOI18N
        botonAlquilar1.setText("Vender");
        botonAlquilar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlquilar1ActionPerformed(evt);
            }
        });
        add(botonAlquilar1);
        botonAlquilar1.setBounds(1080, 570, 140, 50);

        jLabel5.setBackground(new java.awt.Color(255, 200, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<");
        add(jLabel5);
        jLabel5.setBounds(450, 110, 20, 30);

        jLabel12.setBackground(new java.awt.Color(255, 200, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("$");
        add(jLabel12);
        jLabel12.setBounds(320, 110, 20, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void botonListarAction(int desdite,int hastita, int zonita, int tipito, int operacioncita, int estadito, int habitacioncita){
        //String tipazo,operacionazo,estadazo;
        //tipazo=tipoInmueble.get(tipito);
        //estadazo=estado.get(estadito);
        InmuebleController ic = new InmuebleController(this);
        ic.cargarInmuebles(desdite,hastita,tipito,operacioncita,estadito,habitacioncita);
    }
    
    private void botonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarActionPerformed
        botonListarAction(Integer.valueOf(String.valueOf(spinDesde.getValue())),
        Integer.valueOf(String.valueOf(spinHasta.getValue())),
        jcbZona.getSelectedIndex(),jcbTipoInmueble.getSelectedIndex(),
        jcbOperacion.getSelectedIndex(),jcbEstado.getSelectedIndex(),
        jcbHabitaciones.getSelectedIndex());
    }//GEN-LAST:event_botonListarActionPerformed
        
    private void botonAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlquilarActionPerformed
        if(tablaInmueble.getSelectedRow()!=-1){
            Inmueble aux = mapI.get(tablaInmueble.getValueAt(tablaInmueble.getSelectedRow(), 0));
            if(aux.getOperacion()!=1){
                if(aux.getEstado()==1 && (new InmuebleController(this)).estaAdministrado(aux.getDuenoID())){
                    jDialog1 = new javax.swing.JDialog();
                    jDialog1.setSize(1125, 710);
                    jDialog1.setResizable(false);
                    jDialog1.setUndecorated(true);
                    jDialog1.setTitle("Cargar Contrato"); 
                    jDialog1.setBounds(90,10 , 1125, 720);
                    jDialog1.setModal(true); 
                    int clienteID = aux.getDuenoID();
                    int inmuebleID = aux.getId();
                    jDialog1.add(new HacerContratoPanel(clienteID,inmuebleID, aux.getPrecio()));
                    jDialog1.setVisible(true);
                    return;
                }
                if(aux.getEstado() == 1){
                    jDialog1 = new javax.swing.JDialog();
                    jDialog1.setSize(1450, 800);
                    jDialog1.setTitle("Cargar Contrato"); 
                    jDialog1.setLocationRelativeTo(this);
                    jDialog1.setResizable(false);
                    jDialog1.setUndecorated(true);
                    jDialog1.setBounds(90, 150, 1125, 385);
                    jDialog1.setModal(true);
                    jDialog1.setForeground(Color.black);
                    int clienteID = aux.getDuenoID();
                    int inmuebleID = aux.getId();
                    jDialog1.add(new HacerContratoSinADM(clienteID,inmuebleID,aux.getPrecio()));
                    jDialog1.setVisible(true);
                    return;
                }
            }
            else{JOptionPane.showMessageDialog(null, "El inmueble es unicamente para vender", "Error", JOptionPane.ERROR_MESSAGE);}
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un inmueble", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAlquilarActionPerformed

    private void botonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetallesActionPerformed
        if(tablaInmueble.getSelectedRow()!=-1){
            Inmueble inmInfo = mapI.get(tablaInmueble.getValueAt(tablaInmueble.getSelectedRow(), 0));
            jDialog2 = new javax.swing.JDialog();
            jDialog2.setSize(1450, 800);
            jDialog2.setTitle("Informacion completa del Inmueble."); 
            jDialog2.setBounds(25, 20, 1250, 1050);
            jDialog2.setModal(true); 
            jDialog2.add(new ABMInmueble(inmInfo,true));
            jDialog2.setVisible(true); 
        }
    }//GEN-LAST:event_botonDetallesActionPerformed

    private void jcbTipoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoInmuebleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoInmuebleActionPerformed

    private void jcbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbOperacionActionPerformed

    private void jcbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbZonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbZonaActionPerformed

    private void botonAlquilar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlquilar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAlquilar1ActionPerformed

    private DefaultTableModel tabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlquilar;
    private javax.swing.JButton botonAlquilar1;
    private javax.swing.JButton botonDetalles;
    private javax.swing.JButton botonListar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbHabitaciones;
    private javax.swing.JComboBox<String> jcbOperacion;
    private javax.swing.JComboBox<String> jcbTipoInmueble;
    private javax.swing.JComboBox<String> jcbZona;
    private javax.swing.JSpinner spinDesde;
    private javax.swing.JSpinner spinHasta;
    private javax.swing.JTable tablaInmueble;
    // End of variables declaration//GEN-END:variables

    @Override
    public void llenarTabla(ArrayList<Inmueble> listaI) {
        int fila = 0;
        mapI = new HashMap<>();
        tabla = (DefaultTableModel)tablaInmueble.getModel();
        tabla.setRowCount(0);
        for(Inmueble inm : listaI){
            mapI.put(inm.getId(), inm);
            tabla.addRow(new Object [8]);
            tablaInmueble.setValueAt(inm.getId(), fila, 0);             //ID
            tablaInmueble.setValueAt(inm.getDireccion(), fila, 1);      //Direccion
            tablaInmueble.setValueAt(inm.getBarrio(), fila, 2);//Zona
            tablaInmueble.setValueAt(inm.getPrecio(), fila, 3);         //Precio
            tablaInmueble.setValueAt(tipoInmueble.get(inm.getTipo()), fila, 4);//Tipo de Inmueble
            tablaInmueble.setValueAt(operacion.get(inm.getOperacion()), fila, 5);//Operacion
            tablaInmueble.setValueAt(estado.get(inm.getEstado()), fila, 6);    //Estado
            tablaInmueble.setValueAt(inm.getHabitaciones(), fila, 7);    //Habitaciones
            fila++;
        }
    }

    @Override
    public void detalles(Inmueble inm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void filtros(int estado, int tipo, int zona, int habitacion, int precio, ArrayList<Inmueble> listaI) {/*
        ArrayList<Inmueble> listaFiltrada = new ArrayList();
        for(Inmueble inm : listaI){
            if( (estado==inm.getEstado()) && (tipo==inm.getTipo()) && (habitacion==inm.getHabitaciones()) && (precio <= inm.getPrecio()))
                {listaFiltrada.add(inm);}
        }
        
        llenarTabla(listaFiltrada);*/
    }

    @Override
    public void borrarInmueble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevoInmueble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarInmueble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaAlta(boolean exito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaModificar(boolean exito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
