/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllers.PagoAlDuenioController;
import Controllers.PagoAlquilerController;
import Modelo.Cliente;
import Modelo.TuplaDeudores;
import Modelo.TuplaInmProp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucho
 */
public class PagoAlDuenioPanel extends javax.swing.JPanel implements PagoAlDuenioView{
    private DefaultTableModel tabla;
    private HashMap<Integer,Cliente> mapC =null;
    private int duenioID;  
    private Cliente clienteSelec;
    private ArrayList<Integer> pagosArendir;
    
    public PagoAlDuenioPanel() {
         initComponents();
         (new PagoAlDuenioController(this)).llenarTabla(jTeBuscarPorNombre.getText());
    }
    public void habilitarBoton(){ 
            jButConfirmarPago.setEnabled(true);
    }
    public void deshabilitarBoton(){
            jButConfirmarPago.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jTeBuscarPorNombre = new javax.swing.JTextField();
        jYearC = new com.toedter.calendar.JYearChooser();
        jMonthC = new com.toedter.calendar.JMonthChooser();
        jButConfirmarPago = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInmuebleDueño = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTexEstadoPAgo = new javax.swing.JTextField();
        jLabelGanancia = new javax.swing.JLabel();
        jLabelTotalArendir = new javax.swing.JLabel();
        jLabelRendido = new javax.swing.JLabel();
        jLabelTotalNeto = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane42 = new javax.swing.JScrollPane();
        tablaDeudores = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true), "Busqueda de Dueño", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ingrese nombre :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 100, 30);

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "CUIT/DNI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 430, 94);

        jTeBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTeBuscarPorNombreKeyReleased(evt);
            }
        });
        jPanel1.add(jTeBuscarPorNombre);
        jTeBuscarPorNombre.setBounds(190, 20, 210, 30);

        jYearC.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearCPropertyChange(evt);
            }
        });
        jPanel1.add(jYearC);
        jYearC.setBounds(320, 190, 80, 30);

        jMonthC.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthCPropertyChange(evt);
            }
        });
        jPanel1.add(jMonthC);
        jMonthC.setBounds(200, 190, 120, 30);

        jButConfirmarPago.setText("Listar Propiedades Alquiladas");
        jButConfirmarPago.setEnabled(false);
        jButConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButConfirmarPagoActionPerformed(evt);
            }
        });
        jPanel1.add(jButConfirmarPago);
        jButConfirmarPago.setBounds(200, 240, 200, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Seleccione un mes a Pagar :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(21, 190, 170, 30);

        add(jPanel1);
        jPanel1.setBounds(800, 20, 470, 340);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)), "INMUEBLES ACTIVOS DEL PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 16), new java.awt.Color(255, 100, 0))); // NOI18N
        jPanel5.setLayout(null);

        tablaInmuebleDueño.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaInmuebleDueño.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Prop", "Nombre Inquilino", "Direccion", "Valor a rendir", "Valor Total", "Pagado", "Rendido al dueño"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInmuebleDueño.setAutoscrolls(false);
        jScrollPane2.setViewportView(tablaInmuebleDueño);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 30, 760, 200);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Total Neto :");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(220, 260, 90, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Rendido  :");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(20, 300, 70, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Total a rendir :");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(20, 260, 90, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("$");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(320, 300, 10, 30);

        jTexEstadoPAgo.setText("---------------------");
        jPanel5.add(jTexEstadoPAgo);
        jTexEstadoPAgo.setBounds(450, 300, 110, 30);

        jLabelGanancia.setText("--");
        jPanel5.add(jLabelGanancia);
        jLabelGanancia.setBounds(340, 300, 60, 30);

        jLabelTotalArendir.setText("--");
        jPanel5.add(jLabelTotalArendir);
        jLabelTotalArendir.setBounds(150, 260, 50, 30);

        jLabelRendido.setText("--");
        jPanel5.add(jLabelRendido);
        jLabelRendido.setBounds(150, 294, 50, 30);

        jLabelTotalNeto.setText("--");
        jPanel5.add(jLabelTotalNeto);
        jLabelTotalNeto.setBounds(340, 260, 60, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Ganancia :");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(220, 300, 70, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("$");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(130, 300, 10, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("$");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(130, 260, 10, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("$");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(320, 260, 10, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Estado del Pago");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(450, 260, 110, 30);

        jButton1.setText("Rendir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(650, 300, 120, 30);

        add(jPanel5);
        jPanel5.setBounds(10, 20, 780, 340);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)), "Lista de Deudores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 16), new java.awt.Color(255, 100, 0))); // NOI18N
        jPanel6.setLayout(null);

        tablaDeudores.setAutoCreateRowSorter(true);
        tablaDeudores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "ID inmueble", "Nombre", "Telefono", "Valor de la deuda", "Cantidad de meses que debe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeudores.setToolTipText("");
        tablaDeudores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaDeudores.setFocusable(false);
        tablaDeudores.setGridColor(new java.awt.Color(204, 204, 204));
        tablaDeudores.setMaximumSize(new java.awt.Dimension(375, 0));
        tablaDeudores.setMinimumSize(new java.awt.Dimension(375, 0));
        tablaDeudores.setRowHeight(20);
        tablaDeudores.setShowVerticalLines(false);
        tablaDeudores.getTableHeader().setResizingAllowed(false);
        tablaDeudores.getTableHeader().setReorderingAllowed(false);
        jScrollPane42.setViewportView(tablaDeudores);
        if (tablaDeudores.getColumnModel().getColumnCount() > 0) {
            tablaDeudores.getColumnModel().getColumn(0).setMinWidth(75);
            tablaDeudores.getColumnModel().getColumn(0).setMaxWidth(75);
            tablaDeudores.getColumnModel().getColumn(1).setMinWidth(75);
            tablaDeudores.getColumnModel().getColumn(1).setMaxWidth(75);
        }

        jPanel6.add(jScrollPane42);
        jScrollPane42.setBounds(20, 40, 1220, 230);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("No hay deudores este mes.");
        jLabel14.setVisible(false);
        jPanel6.add(jLabel14);
        jLabel14.setBounds(20, 270, 170, 30);

        add(jPanel6);
        jPanel6.setBounds(10, 370, 1260, 310);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        PagoAlDuenioController padc = new PagoAlDuenioController(this);
        duenioID = (int) tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0); 
        habilitarBoton(); 
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void jTeBuscarPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTeBuscarPorNombreKeyReleased
        PagoAlDuenioController padc = new PagoAlDuenioController(this);
        deshabilitarBoton();
        padc.llenarTabla(jTeBuscarPorNombre.getText());
       // pos = (int) tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0);
    }//GEN-LAST:event_jTeBuscarPorNombreKeyReleased

    private void jMonthCPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthCPropertyChange
  //      if(contratoSelec!=null){
     //       jVencPago.setDate(new Date((jYearC.getYear()-1900), jMonthC.getMonth(), contratoSelec.getDiaVen()));
    //    }
    }//GEN-LAST:event_jMonthCPropertyChange

    private void jYearCPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearCPropertyChange
  //      if(contratoSelec!=null){
      //      jVencPago.setDate(new Date((jYearC.getYear()-1900), jMonthC.getMonth(), contratoSelec.getDiaVen()));
       // }
    }//GEN-LAST:event_jYearCPropertyChange

    private void jButConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButConfirmarPagoActionPerformed
    //  if(controlCampos()){
            jLabel14.setVisible(false);
            cargarTablaInmuebles();
      //} 
    }//GEN-LAST:event_jButConfirmarPagoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTexEstadoPAgo.getText().equals("COMPLETADO"))
            rendirPagosDisponibles();
        else
            JOptionPane.showMessageDialog(null,"El pago de este mes ya esta completamente rendido.");

    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButConfirmarPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelGanancia;
    private javax.swing.JLabel jLabelRendido;
    private javax.swing.JLabel jLabelTotalArendir;
    private javax.swing.JLabel jLabelTotalNeto;
    private com.toedter.calendar.JMonthChooser jMonthC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JTextField jTeBuscarPorNombre;
    private javax.swing.JTextField jTexEstadoPAgo;
    private com.toedter.calendar.JYearChooser jYearC;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaDeudores;
    private javax.swing.JTable tablaInmuebleDueño;
    // End of variables declaration//GEN-END:variables
    //-----------------------------METODOS LOCALES LLAMADAS A CONTROLLER--------
    private void limpiarCampos(){
       cargarTablaInmuebles();  
    }
    
    private void calcularLabels(float totalArendir,float totalRendido,float totalNeto,boolean completado){
        jLabelTotalNeto.setText(""+totalNeto);
        jLabelTotalArendir.setText(""+totalArendir);
        jLabelRendido.setText(""+totalRendido);
        jLabelGanancia.setText(""+(totalNeto-totalArendir));
        if(completado)
            jTexEstadoPAgo.setText("COMPLETADO");
        else
            jTexEstadoPAgo.setText("PENDIENTE");
    }
    
    public void cargarTablaInmuebles(){
        duenioID = (int) tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0);  
        PagoAlDuenioController padc = new PagoAlDuenioController(this);
        (new PagoAlDuenioController(this)).llenarTablaInmueblesDuenio(duenioID, this.jMonthC.getMonth(), this.jYearC.getYear());
        (new PagoAlDuenioController(this)).llenarTablaDeudores(duenioID, this.jMonthC.getMonth(), this.jYearC.getYear());
    }
    
    public void rendirPagosDisponibles(){
        if(pagosArendir.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay pagos disponibles a rendir.");
        }else{
            (new PagoAlDuenioController(this)).settearPagoRendido(pagosArendir);
        }
    }
    
    //--------------------------------METODOS DEL VIEW -------------------------
    /**
     * Carga la tabla de los dueños que estan siendo administrados
     * @param ctes 
     */
    @Override
    public void llenarTablaC(ArrayList<Cliente> ctes) {
        int fila = 0; 
        mapC= new HashMap<>(); 
        tabla = (DefaultTableModel)tablaCliente.getModel();
        tabla.setNumRows(0);
        for(Cliente cl : ctes){
            tabla.addRow(new Object [3]);
            tablaCliente.setValueAt(cl.getId(), fila, 0);
            tablaCliente.setValueAt(cl.getNombre(), fila, 1);
            tablaCliente.setValueAt(cl.getDocumento(), fila, 2);
            mapC.put(cl.getId(),cl);
            fila++;
        }
    }
    
    /**
     * Carga la tabla de los inmuebles
     * @param tupla 
     */
    @Override
    public void llenarTablaInmueblesDuenio(ArrayList<TuplaInmProp> tupla){
        int fila = 0;
        boolean completado=true;
        float totalArendir=0f,totalRendido=0f,totalNeto=0f;
        tabla = (DefaultTableModel)tablaInmuebleDueño.getModel();
        tabla.setNumRows(0);
        pagosArendir = new ArrayList<>();
        for(TuplaInmProp cl : tupla){
            totalArendir+=cl.getValRendir();
            totalNeto+=cl.getValTotal();
            tabla.addRow(new Object [7]);
            tablaInmuebleDueño.setValueAt(cl.getIdProp(), fila, 0);
            tablaInmuebleDueño.setValueAt(cl.getNombreInq(), fila, 1);
            tablaInmuebleDueño.setValueAt(cl.getDireccion(), fila, 2);
            tablaInmuebleDueño.setValueAt(cl.getValRendir(), fila, 3); 
            tablaInmuebleDueño.setValueAt(cl.getValTotal(), fila, 4);
            if(cl.getPagado()==0){
                tablaInmuebleDueño.setValueAt("NO PAGADO", fila, 5); 
            }else{
                tablaInmuebleDueño.setValueAt("PAGADO", fila, 5); 
            }
            if(cl.getRendido()==1){
                tablaInmuebleDueño.setValueAt("RENDIDO", fila, 6); 
                totalRendido+=cl.getValRendir();
            }else{
                tablaInmuebleDueño.setValueAt("NO RENDIDO", fila, 6);
                completado=false;
            } 
            if(cl.getPagado()==1 && cl.getRendido()==0)
                pagosArendir.add(cl.getIdPago()); 
            fila++;
        }
        calcularLabels(totalArendir,totalRendido,totalNeto,completado); 
    }
    
    @Override
    public void llenarTablaDeudores(ArrayList<TuplaDeudores> ctes){
        int fila = 0; 
        tabla = (DefaultTableModel)tablaDeudores.getModel();
        tabla.setNumRows(0);
        if(!ctes.isEmpty()){
            for(TuplaDeudores cl : ctes){
                tabla.addRow(new Object [6]);
                tablaDeudores.setValueAt(cl.getClienteID(), fila, 0);
                tablaDeudores.setValueAt(cl.getInmuebleID(), fila, 1);
                tablaDeudores.setValueAt(cl.getNombreCliente(), fila, 2);
                tablaDeudores.setValueAt(cl.getTelCliente(), fila, 3);
                tablaDeudores.setValueAt(cl.getDeuda(), fila, 4);
                tablaDeudores.setValueAt(cl.getCantMeses(), fila, 5);
                fila++;
            }
        }else{
            jLabel14.setVisible(true);
        }    
    }
    
    @Override 
    public void resultadoAltaPago(boolean exito){
        if(exito){
            JOptionPane.showMessageDialog(null,"Se han rendido los pagos con exito.");
            limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(null, "No se han podido rendir los pagos.","Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
}