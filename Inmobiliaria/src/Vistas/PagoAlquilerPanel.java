/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllers.PagoAlquilerController;
import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.PagoAlquiler;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PagoAlquilerPanel extends javax.swing.JPanel implements PagoAlquilerView{

    private DefaultTableModel tabla;
    private HashMap<Integer,Cliente> mapC =null;
    private int clienteID; //idClienteseleccionado
    private Contrato contratoSelec;
    /**
     * Creates new form PanelPagoAlquiler
     */
    public PagoAlquilerPanel() {
        initComponents(); 
        PagoAlquilerController pac = new PagoAlquilerController(this); 
        pac.llenarTabla(jTeBuscarPorNombre.getText());
    }

    private void limpiarCampos(){
       ((DefaultTableModel)tablaPago.getModel()).setNumRows(0);
       textValorAlq.setText("");
       textDir.setText("");
       jButConfirmarPago.setEnabled(false);
       jTeMontoImp.setText("0");
       jTeMontoLuz.setText("0");
       jTeMontoGas.setText("0");
       jTePunitorios.setText("0");
       jCheckBox1.setSelected(false);
       texMontoPagar.setText("");
       jFechaPago.setDate(null);
       jVencPago.setDate(null);
    }
    private boolean controlCampos() { 
        try {
            Float.valueOf(texMontoPagar.getText());
            Float.valueOf(textValorAlq.getText());
            Integer.valueOf(jMonthC.getMonth());
            Integer.valueOf(jYearC.getYear());
            Float.valueOf(jTeMontoImp.getText());
            Float.valueOf(jTeMontoLuz.getText());
            Float.valueOf(jTeMontoGas.getText());
            Float.valueOf(jTePunitorios.getText());
        } catch (NumberFormatException  e) {
            JOptionPane.showMessageDialog(null, "El pago no ha sido insertado.\nPorfavor, ingrese numeros en los campos correspondientes.", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jFechaPago.getDate() == null) {
            JOptionPane.showMessageDialog(null, "El pago no ha sido insertado.\nPorfavor, ingrese una fecha valida.", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void cargarDatosPago(){
        // aca hay que cargar los datos de la tabla pero a la tabla le faltan datos como punitorios y impusestos discriminados
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jTeBuscarPorNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textDir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textValorAlq = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jMonthC = new com.toedter.calendar.JMonthChooser();
        jYearC = new com.toedter.calendar.JYearChooser();
        jLabel7 = new javax.swing.JLabel();
        jFechaPago = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jVencPago = new com.toedter.calendar.JDateChooser();
        jButConfirmarPago = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTeMontoGas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTeMontoImp = new javax.swing.JTextField();
        jTePunitorios = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTeMontoLuz = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        texMontoPagar = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPago = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1270, 680));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 1, true), "Busqueda de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N
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
        if (tablaCliente.getColumnModel().getColumnCount() > 0) {
            tablaCliente.getColumnModel().getColumn(0).setMinWidth(75);
            tablaCliente.getColumnModel().getColumn(0).setMaxWidth(75);
            tablaCliente.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 430, 94);

        jTeBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTeBuscarPorNombreKeyReleased(evt);
            }
        });
        jPanel1.add(jTeBuscarPorNombre);
        jTeBuscarPorNombre.setBounds(190, 20, 210, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Direccion  Inmueble:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 210, 130, 30);
        jPanel1.add(textDir);
        textDir.setBounds(200, 210, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Valor Alquiler:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 170, 91, 30);
        jPanel1.add(textValorAlq);
        textValorAlq.setBounds(200, 170, 200, 30);

        add(jPanel1);
        jPanel1.setBounds(780, 0, 470, 260);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Datos del Pago :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 16), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jMonthC.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthCPropertyChange(evt);
            }
        });
        jPanel2.add(jMonthC);
        jMonthC.setBounds(200, 70, 120, 30);

        jYearC.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearCPropertyChange(evt);
            }
        });
        jPanel2.add(jYearC);
        jYearC.setBounds(320, 70, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mes a Pagar :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 70, 91, 30);
        jPanel2.add(jFechaPago);
        jFechaPago.setBounds(200, 110, 200, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Fecha de Pago :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 110, 91, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Vencimiento :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(50, 150, 91, 30);

        jVencPago.setEnabled(false);
        jPanel2.add(jVencPago);
        jVencPago.setBounds(200, 150, 200, 30);

        jButConfirmarPago.setText("Confirmar Pago ");
        jButConfirmarPago.setEnabled(false);
        jButConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButConfirmarPagoActionPerformed(evt);
            }
        });
        jPanel2.add(jButConfirmarPago);
        jButConfirmarPago.setBounds(200, 350, 200, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Monto Impuestos :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(50, 190, 110, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("$");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(180, 190, 18, 30);

        jTeMontoGas.setText("0");
        jPanel2.add(jTeMontoGas);
        jTeMontoGas.setBounds(200, 270, 200, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("$");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(180, 270, 18, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Monto Gas:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(50, 270, 119, 30);

        jTeMontoImp.setText("0");
        jPanel2.add(jTeMontoImp);
        jTeMontoImp.setBounds(200, 190, 200, 30);

        jTePunitorios.setText("0");
        jPanel2.add(jTePunitorios);
        jTePunitorios.setBounds(200, 310, 200, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("$");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(180, 310, 18, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Punitorios :");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(50, 310, 119, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Monto Luz:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(50, 230, 119, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(180, 230, 18, 30);

        jTeMontoLuz.setText("0");
        jPanel2.add(jTeMontoLuz);
        jTeMontoLuz.setBounds(200, 230, 200, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Monto Alquiler:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(50, 30, 130, 30);

        texMontoPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                texMontoPagarMouseClicked(evt);
            }
        });
        jPanel2.add(texMontoPagar);
        texMontoPagar.setBounds(200, 30, 200, 30);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Marcar como Pagado.");
        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(40, 350, 140, 40);

        add(jPanel2);
        jPanel2.setBounds(780, 260, 470, 400);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)), "Calendario de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 1, 16), new java.awt.Color(255, 100, 0))); // NOI18N
        jPanel3.setLayout(null);

        tablaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Año-mes", "Fecha Vencimiento", "Monto Impuesto", "Fecha de Pago", "Monto Pagado", "Punitorios", "Valor Alquiler", "Monto Total", "Completado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaPago);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(10, 40, 750, 490);

        add(jPanel3);
        jPanel3.setBounds(0, 120, 770, 540);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CapturaInfo.PNG"))); // NOI18N
        jLabel1.setText("INVERSIONES MERCEDES ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 111);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        limpiarCampos();
        PagoAlquilerController pac = new PagoAlquilerController(this);
        clienteID = (int) tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0);
        pac.llenarCamposContratos(clienteID);        
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void jTeBuscarPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTeBuscarPorNombreKeyReleased
        PagoAlquilerController pac = new PagoAlquilerController(this);
        pac.llenarTabla(jTeBuscarPorNombre.getText());
    }//GEN-LAST:event_jTeBuscarPorNombreKeyReleased

    private void jButConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButConfirmarPagoActionPerformed
        PagoAlquilerController pac = new PagoAlquilerController(this);
        if(controlCampos()){
            pac.insertarPagoRealizado(contratoSelec, Float.valueOf(textValorAlq.getText()), Float.valueOf(texMontoPagar.getText()), (int) jMonthC.getMonth(), (int) jYearC.getYear(), (Date) jFechaPago.getDate(),0 ,Float.valueOf(jTeMontoImp.getText()), Float.valueOf(jTeMontoLuz.getText()), Float.valueOf(jTeMontoGas.getText()),Float.valueOf(jTePunitorios.getText()),jCheckBox1.isSelected());  
        }
         
    }//GEN-LAST:event_jButConfirmarPagoActionPerformed

    private void jMonthCPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthCPropertyChange
        if(contratoSelec!=null){  
            jVencPago.setDate(new Date((jYearC.getYear()-1900), jMonthC.getMonth(), contratoSelec.getDiaVen())); 
        }
    }//GEN-LAST:event_jMonthCPropertyChange

    private void jYearCPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearCPropertyChange
        if(contratoSelec!=null){
            jVencPago.setDate(new Date((jYearC.getYear()-1900), jMonthC.getMonth(), contratoSelec.getDiaVen()));
        }
    }//GEN-LAST:event_jYearCPropertyChange

    private void texMontoPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texMontoPagarMouseClicked
        if(contratoSelec!=null){ 
            jVencPago.setDate(new Date((jYearC.getYear()-1900), jMonthC.getMonth(), contratoSelec.getDiaVen()));
        }
    }//GEN-LAST:event_texMontoPagarMouseClicked

    private void tablaPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagoMouseClicked
        clienteID = (int) tablaCliente.getValueAt(tablaCliente.getSelectedRow(),0);
        if(clienteID!=-1){
            cargarDatosPago();
        }
    }//GEN-LAST:event_tablaPagoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButConfirmarPago;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTeBuscarPorNombre;
    private javax.swing.JTextField jTeMontoGas;
    private javax.swing.JTextField jTeMontoImp;
    private javax.swing.JTextField jTeMontoLuz;
    private javax.swing.JTextField jTePunitorios;
    private com.toedter.calendar.JDateChooser jVencPago;
    private com.toedter.calendar.JYearChooser jYearC;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaPago;
    private javax.swing.JTextField texMontoPagar;
    private javax.swing.JTextField textDir;
    private javax.swing.JTextField textValorAlq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void llenarTabla(ArrayList<Cliente> listaC) { 
        int fila = 0; 
        mapC= new HashMap<>(); 
        tabla = (DefaultTableModel)tablaCliente.getModel();
        tabla.setNumRows(0);
        for(Cliente cl : listaC){
            tabla.addRow(new Object [3]);
            tablaCliente.setValueAt(cl.getId(), fila, 0);
            tablaCliente.setValueAt(cl.getNombre(), fila, 1);
            tablaCliente.setValueAt(cl.getDocumento(), fila, 2);
            mapC.put(cl.getId(),cl);
            fila++;
        }
    }
    /**
     * Llena los labels del contrato y del inmueble...  Y la TABLA PAGOS 
     * @param listaCon 
     * @param Direc 
     * @param valorAlq 
     */
    @Override
    public void llenarCamposContrato(ArrayList<Contrato> listaCon,String Direc, float valorAlq,ArrayList<PagoAlquiler> pa) {  
        jButConfirmarPago.setEnabled(true);
        contratoSelec = listaCon.get(0);
        // PagoAlquilerController pac = new PagoAlquilerController(this);  
        textDir.setText(Direc); 
        textValorAlq.setText(""+valorAlq);  
        tabla = (DefaultTableModel)tablaPago.getModel();
        tabla.setNumRows(0);
            for(PagoAlquiler paga : pa){ // LLamar Tabla Pagos 
                Object[] fil = new Object [9];
                fil[0] = (1900+paga.getFechaVenc().getYear()+"-"+(paga.getFechaVenc().getMonth()+1));
                fil[1] = paga.getFechaVenc(); 
                fil[2] = paga.getMontoGas()+paga.getMontoLuz(); 
                fil[3] = paga.getFechaPago();
                fil[4] = paga.getMontoPagado();
                fil[6] = paga.getMontoMes();
                fil[7] = paga.getMontoTotal();
                if(paga.isCompleto())
                    fil[8] = "SI";
                else 
                    fil[8] = "NO PAGADO";
                tabla.addRow(fil);
            } 
    }
   
    @Override
    public void llenarTablaPagos(ArrayList<PagoAlquiler> listaA) {
        
    }
    @Override
    public void errorCargarContrato(){
        JOptionPane.showMessageDialog(null, "El cliente no esta alquilando ningun inmueble a administrar.","No se han podido cargar el calendario de Pago.", JOptionPane.ERROR_MESSAGE); 
    }
    @Override
    public void resultadoAltaPago(boolean exito) {
        if(exito){
            JOptionPane.showMessageDialog(null,"El pago se ha realizado con exito.");
            limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(null, "El pago no ha sido guardado. Es posible que haya seleccionado una fecha fuera del intervalo del contrato.","Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
 
