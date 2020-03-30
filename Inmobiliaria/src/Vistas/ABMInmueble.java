/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllers.ClienteController;
import Controllers.InmuebleController;
import Modelo.Asesor;
import Modelo.Cliente;
import Modelo.Inmueble;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lucho
 */
public class ABMInmueble extends javax.swing.JPanel implements InmuebleView,ClienteView{
    private InmuebleController ic = new InmuebleController(this);
    private ClienteController cc = new ClienteController(this);
    private Inmueble inmSelec;
    
    
    
    /**
     * 
     * @param inm INMUEBLE A MODIFICAR/MOSTRAR ----SI ES EL CASO DEL ALTA VIENE EN ID =-1 Y EL ID DEL DUEÑO.
     * @param noEdit FLAG QUE DESHABILITA LA EDICION DE LOS DATOS 
     */
    public ABMInmueble(Inmueble inm,boolean noEdit) { 
        initComponents();
        inmSelec=inm;
        if(inmSelec.getId()==-1){ // si es -1 entonces se agrega un inmueble nuevo
            //---------CSS STYLE
            this.setBorder(StyleCSS.getBordePanel("Cargar Datos del inmueble.")); 
            jPanel1.setBorder(StyleCSS.getBordePanel("Seleccione las características del inmueble."));
            jPanel2.setBorder(StyleCSS.getBordePanel("Seleccionar tipo de Inmueble."));
            StyleCSS.setPlaceHolder(textDireccion, "Direccion...");
            StyleCSS.setPlaceHolder(textPrecio, "precio...");    
            StyleCSS.setPlaceHolder(textBarrio, "Barrio/zona...");
            StyleCSS.setPlaceHolder(textExpensas, "Expensas...");
            StyleCSS.setPlaceHolderArea(areaObservacion, "Ovservaciones:");
            StyleCSS.setPlaceHolderArea(areaOtro, "Otros:");
            //---------FIN CSS STYLE
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jLabel14.setVisible(false);
            jLabel10.setVisible(false);  //Id del dueño
        }else{ 
            //---------CSS STYLE
            this.setBorder(StyleCSS.getBordePanel("Datos de la propiedad.")); 
            jPanel1.setBorder(StyleCSS.getBordePanel("Características del inmueble.")); 
            jPanel2.setBorder(StyleCSS.getBordePanel("Tipo de Inmueble."));                    
            //---------FIN CSS STYLE 
            if(noEdit){      //Si es true entonces lo llama desde el editar desde buscador de inmuebles  y  
                deshabilitarCampos();
                this.cargarDatosInmueble(inmSelec);
                cc.getCliente(inmSelec.getDuenoID());// Lo traigo desde la BD para poner el nombre del man
            }else{
                jLabel16.setVisible(false);
                jLabel17.setVisible(false);
                jLabel14.setVisible(false);
                jLabel10.setVisible(false);  
                this.cargarDatosInmueble(inmSelec);
            }  
        }    
    }

    ABMInmueble(int clienteID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deshabilitarCampos(){
        jLabel10.setEnabled(false);
        textBarrio.setEnabled(false);
        textPrecio.setEnabled(false);
        textDireccion.setEnabled(false);
        textExpensas.setEnabled(false); 
        jCheckVender.setEnabled(false);
        jCheckAlquilar.setEnabled(false); 
        jRadioBcasa.setEnabled(false);
        jRadioBuDepto.setEnabled(false);
        jRadioBuLocal.setEnabled(false);
        jRadioBuTerreno.setEnabled(false); 
        spinHabitacion1.setEnabled(false);
        spinBanio.setEnabled(false);
        spinMTS2.setEnabled(false);
        spinMFondo.setEnabled(false);
        jcBoxLiving.setEnabled(false);
        jcBoxCocina.setEnabled(false);
        jcBoxComedor.setEnabled(false); 
        jcBoxCocinaComedor.setEnabled(false);
        jcBoxCocinaLiving.setEnabled(false);
        jcBoxCocinaLivingComedor.setEnabled(false);
        jcBoxLavadero.setEnabled(false);
        jcBoxPatio.setEnabled(false);
        jcBoxCochera.setEnabled(false);
        jcBoxAmoblada.setEnabled(false);
        jcBoxPlantaAlta.setEnabled(false);
        jCheckAgua.setEnabled(false);
        jCheckLuz.setEnabled(false);
        jCheckGas.setEnabled(false);
        jCheckImpuestos.setEnabled(false);
        areaObservacion.setEditable(false);
        botonGuardar.setVisible(false);
    }
    
    public String controlCampos(){
        String error = ""; 
        if ( textDireccion.getText().isEmpty()) {
            error = error+ "-La direccion ingresada no es valida\n";  
        }  
        try {
            Float.parseFloat(this.textPrecio.getText());
        } catch (NumberFormatException e) {
            error = error+ "-El precio ingresado no es valido\n"; 
        }
        try {
            Float.parseFloat(this.textExpensas.getText());
        } catch (NumberFormatException e) {
            error = error+ "-El monto ingresado de las expensas no es valido.\n"; 
        } 
        if ( textBarrio.getText().isEmpty()) {
            error = error+ "-El barrio ingresado no es valido\n";  
        }
        if(!(jCheckVender.isSelected() || jCheckAlquilar.isSelected())){
            error = error+ "-Debe ingresar un tipo de operacion\n";  
        }
        if(!(jRadioBcasa.isSelected() || jRadioBuDepto.isSelected()|| jRadioBuLocal.isSelected()|| jRadioBuTerreno.isSelected())){
            error = error+ "-Debe ingresar un tipo de inmueble\n";  
        }   
        return error; 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObservacion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaOtro = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        textBarrio = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        spinMTS2 = new javax.swing.JSpinner();
        jCheckVender = new javax.swing.JCheckBox();
        jCheckAlquilar = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinHabitacion1 = new javax.swing.JSpinner();
        spinMFondo = new javax.swing.JSpinner();
        spinBanio = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jcBoxLiving = new javax.swing.JCheckBox();
        jcBoxCocina = new javax.swing.JCheckBox();
        jcBoxComedor = new javax.swing.JCheckBox();
        jcBoxCocinaComedor = new javax.swing.JCheckBox();
        jcBoxCocinaLiving = new javax.swing.JCheckBox();
        jcBoxCocinaLivingComedor = new javax.swing.JCheckBox();
        jcBoxLavadero = new javax.swing.JCheckBox();
        jcBoxPatio = new javax.swing.JCheckBox();
        jcBoxCochera = new javax.swing.JCheckBox();
        jcBoxAmoblada = new javax.swing.JCheckBox();
        jcBoxPlantaAlta = new javax.swing.JCheckBox();
        jCheckImpuestos = new javax.swing.JCheckBox();
        jCheckGas = new javax.swing.JCheckBox();
        jCheckLuz = new javax.swing.JCheckBox();
        jCheckAgua = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        textExpensas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        botonSalir1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioBuTerreno = new javax.swing.JRadioButton();
        jRadioBuLocal = new javax.swing.JRadioButton();
        jRadioBuDepto = new javax.swing.JRadioButton();
        jRadioBcasa = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Expensas");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel2);
        jLabel2.setBounds(160, 140, 110, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Barrio");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel1);
        jLabel1.setBounds(310, 80, 250, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Habitaciones");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel4);
        jLabel4.setBounds(20, 290, 120, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("-----");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel10);
        jLabel10.setBounds(380, 40, 30, 20);

        areaObservacion.setColumns(20);
        areaObservacion.setRows(5);
        areaObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        jScrollPane1.setViewportView(areaObservacion);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 560, 540, 60);

        areaOtro.setColumns(20);
        areaOtro.setRows(5);
        areaOtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        jScrollPane2.setViewportView(areaOtro);

        add(jScrollPane2);
        jScrollPane2.setBounds(570, 490, 540, 60);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Metros Cuadrados");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel12);
        jLabel12.setBounds(300, 290, 120, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Metros Fondo");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel13);
        jLabel13.setBounds(440, 290, 120, 50);
        add(textDireccion);
        textDireccion.setBounds(20, 100, 250, 30);

        textBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBarrioActionPerformed(evt);
            }
        });
        add(textBarrio);
        textBarrio.setBounds(310, 100, 250, 30);

        textPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecioActionPerformed(evt);
            }
        });
        add(textPrecio);
        textPrecio.setBounds(20, 160, 110, 30);

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        add(botonGuardar);
        botonGuardar.setBounds(210, 640, 170, 50);

        spinMTS2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinMTS2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spinMTS2KeyPressed(evt);
            }
        });
        add(spinMTS2);
        spinMTS2.setBounds(300, 310, 120, 30);

        jCheckVender.setText("Vender");
        add(jCheckVender);
        jCheckVender.setBounds(330, 160, 80, 23);

        jCheckAlquilar.setText("Alquilar");
        add(jCheckAlquilar);
        jCheckAlquilar.setBounds(460, 160, 90, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Baños");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel3);
        jLabel3.setBounds(160, 290, 120, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Operacion");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel5);
        jLabel5.setBounds(310, 140, 250, 50);

        spinHabitacion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(spinHabitacion1);
        spinHabitacion1.setBounds(20, 310, 120, 30);

        spinMFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(spinMFondo);
        spinMFondo.setBounds(440, 310, 120, 30);

        spinBanio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(spinBanio);
        spinBanio.setBounds(160, 310, 120, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jcBoxLiving.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxLiving.setText("Living");
        jcBoxLiving.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jcBoxLiving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBoxLivingActionPerformed(evt);
            }
        });
        jPanel1.add(jcBoxLiving);
        jcBoxLiving.setBounds(20, 10, 140, 30);

        jcBoxCocina.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxCocina.setText("Cocina");
        jPanel1.add(jcBoxCocina);
        jcBoxCocina.setBounds(20, 40, 140, 40);

        jcBoxComedor.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxComedor.setText("Comedor");
        jcBoxComedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBoxComedorActionPerformed(evt);
            }
        });
        jPanel1.add(jcBoxComedor);
        jcBoxComedor.setBounds(20, 70, 140, 40);

        jcBoxCocinaComedor.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxCocinaComedor.setText("Cocina-Comedor");
        jPanel1.add(jcBoxCocinaComedor);
        jcBoxCocinaComedor.setBounds(20, 100, 140, 40);

        jcBoxCocinaLiving.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxCocinaLiving.setText("Cocina-Living");
        jPanel1.add(jcBoxCocinaLiving);
        jcBoxCocinaLiving.setBounds(20, 130, 140, 40);

        jcBoxCocinaLivingComedor.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxCocinaLivingComedor.setText("Cocina-Living-Comedor");
        jPanel1.add(jcBoxCocinaLivingComedor);
        jcBoxCocinaLivingComedor.setBounds(20, 160, 140, 40);

        jcBoxLavadero.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxLavadero.setText("Lavadero");
        jPanel1.add(jcBoxLavadero);
        jcBoxLavadero.setBounds(210, 20, 140, 23);

        jcBoxPatio.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxPatio.setText("Patio");
        jcBoxPatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBoxPatioActionPerformed(evt);
            }
        });
        jPanel1.add(jcBoxPatio);
        jcBoxPatio.setBounds(210, 50, 140, 23);

        jcBoxCochera.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxCochera.setText("Cochera");
        jPanel1.add(jcBoxCochera);
        jcBoxCochera.setBounds(210, 80, 140, 23);

        jcBoxAmoblada.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxAmoblada.setText("Amoblada");
        jcBoxAmoblada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBoxAmobladaActionPerformed(evt);
            }
        });
        jPanel1.add(jcBoxAmoblada);
        jcBoxAmoblada.setBounds(210, 110, 140, 23);

        jcBoxPlantaAlta.setBackground(new java.awt.Color(255, 255, 255));
        jcBoxPlantaAlta.setText("Planta Alta");
        jPanel1.add(jcBoxPlantaAlta);
        jcBoxPlantaAlta.setBounds(210, 140, 140, 23);

        jCheckImpuestos.setBackground(new java.awt.Color(255, 255, 255));
        jCheckImpuestos.setText("Incluye impuestos");
        jCheckImpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckImpuestosActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckImpuestos);
        jCheckImpuestos.setBounds(400, 110, 120, 23);

        jCheckGas.setBackground(new java.awt.Color(255, 255, 255));
        jCheckGas.setText("Gas");
        jPanel1.add(jCheckGas);
        jCheckGas.setBounds(400, 80, 100, 23);

        jCheckLuz.setBackground(new java.awt.Color(255, 255, 255));
        jCheckLuz.setText("Luz");
        jPanel1.add(jCheckLuz);
        jCheckLuz.setBounds(400, 50, 100, 23);

        jCheckAgua.setBackground(new java.awt.Color(255, 255, 255));
        jCheckAgua.setText("Agua");
        jPanel1.add(jCheckAgua);
        jCheckAgua.setBounds(400, 20, 100, 23);

        add(jPanel1);
        jPanel1.setBounds(20, 350, 540, 200);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Direccion");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel11);
        jLabel11.setBounds(20, 80, 250, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Codigo:");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel14);
        jLabel14.setBounds(310, 40, 50, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Dueño del inmueble:");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel16);
        jLabel16.setBounds(20, 40, 120, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("--------------");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel17);
        jLabel17.setBounds(190, 40, 80, 20);

        jSeparator1.setForeground(new java.awt.Color(231, 60, 0));
        add(jSeparator1);
        jSeparator1.setBounds(20, 60, 540, 10);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Precio");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 100, 0)));
        add(jLabel6);
        jLabel6.setBounds(20, 140, 110, 50);

        textExpensas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textExpensasActionPerformed(evt);
            }
        });
        add(textExpensas);
        textExpensas.setBounds(160, 160, 110, 30);

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel8);
        jLabel8.setBounds(940, 150, 140, 20);

        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel19);
        jLabel19.setBounds(940, 180, 140, 20);

        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel22);
        jLabel22.setBounds(940, 210, 140, 20);

        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel25);
        jLabel25.setBounds(940, 240, 140, 20);

        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel29);
        jLabel29.setBounds(770, 270, 140, 20);

        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel26);
        jLabel26.setBounds(770, 240, 140, 20);

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel23);
        jLabel23.setBounds(770, 210, 140, 20);

        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel20);
        jLabel20.setBounds(770, 180, 140, 20);

        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel18);
        jLabel18.setBounds(770, 150, 140, 20);

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel9);
        jLabel9.setBounds(610, 270, 140, 20);

        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel30);
        jLabel30.setBounds(610, 120, 140, 20);

        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel21);
        jLabel21.setBounds(610, 150, 140, 20);

        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel24);
        jLabel24.setBounds(610, 180, 140, 20);

        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel27);
        jLabel27.setBounds(610, 210, 140, 20);

        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel28);
        jLabel28.setBounds(610, 240, 140, 20);

        botonSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CruzSalir.PNG"))); // NOI18N
        botonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir1ActionPerformed(evt);
            }
        });
        add(botonSalir1);
        botonSalir1.setBounds(530, 20, 30, 30);

        jPanel2.setLayout(null);

        buttonGroup1.add(jRadioBuTerreno);
        jRadioBuTerreno.setText("Terreno");
        jPanel2.add(jRadioBuTerreno);
        jRadioBuTerreno.setBounds(20, 20, 120, 30);

        buttonGroup1.add(jRadioBuLocal);
        jRadioBuLocal.setText("Local");
        jPanel2.add(jRadioBuLocal);
        jRadioBuLocal.setBounds(150, 10, 100, 40);

        buttonGroup1.add(jRadioBuDepto);
        jRadioBuDepto.setText("Departamento");
        jPanel2.add(jRadioBuDepto);
        jRadioBuDepto.setBounds(270, 10, 120, 40);

        buttonGroup1.add(jRadioBcasa);
        jRadioBcasa.setText("Casa");
        jPanel2.add(jRadioBcasa);
        jRadioBcasa.setBounds(440, 10, 90, 40);

        add(jPanel2);
        jPanel2.setBounds(20, 220, 540, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void jcBoxPatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBoxPatioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBoxPatioActionPerformed

    private void jcBoxAmobladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBoxAmobladaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBoxAmobladaActionPerformed

    private void jcBoxLivingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBoxLivingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBoxLivingActionPerformed

    private void jcBoxComedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBoxComedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcBoxComedorActionPerformed

    private void textPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecioActionPerformed

    private void textBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarrioActionPerformed
  
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
    if(controlCampos().isEmpty()){ 
        int operacion;
        if (jCheckVender.isSelected()){
            operacion = 1;
        }else{
            operacion = 2;
        }
        int tipo;
               if(jRadioBcasa.isSelected()){
            tipo=1;
        }else if(jRadioBuDepto.isSelected()){
            tipo=2;
        }else if (jRadioBuLocal.isSelected()){
            tipo = 3;
        }else{
            tipo = 4;
        }
        // el id del inmueble se calcula en la BD y el int servicios no se que onda  y el otros " "tmb 
        if(inmSelec.getId()==-1){
             Inmueble nuevoI = new Inmueble(-1,inmSelec.getDuenoID(),textDireccion.getText(),
                     Float.parseFloat(textPrecio.getText()),operacion, tipo, 1, 
                     textBarrio.getText(),Integer.valueOf(""+spinHabitacion1.getValue()),
                     Integer.valueOf(""+spinBanio.getValue()),jcBoxPatio.isSelected(), 
                     jcBoxAmoblada.isSelected(), jcBoxLavadero.isSelected(),jcBoxCocina.isSelected(),
                     jcBoxComedor.isSelected(), jcBoxLiving.isSelected(), jcBoxCocinaLiving.isSelected(), 
                     jcBoxCocinaComedor.isSelected(),jcBoxCocinaLivingComedor.isSelected(), 
                     Float.parseFloat(""+spinMTS2.getValue()), Float.parseFloat(""+spinMFondo.getValue()),
                     jcBoxCochera.isSelected(), jcBoxPlantaAlta.isSelected(),jCheckImpuestos.isSelected(),
                     -1, Double.parseDouble(textExpensas.getText()), areaObservacion.getText(), " ",
                     jCheckAgua.isSelected(), jCheckGas.isSelected(), jCheckLuz.isSelected());
            ic.alta(nuevoI);
        }else{ 
             Inmueble nuevoI = new Inmueble(inmSelec.getId(),inmSelec.getDuenoID(), textDireccion.getText(),
                     Float.parseFloat(textPrecio.getText()),operacion, tipo, 1,
                     textBarrio.getText(),Integer.valueOf(""+spinHabitacion1.getValue()),
                     Integer.valueOf(""+spinBanio.getValue()),jcBoxPatio.isSelected(),
                     jcBoxAmoblada.isSelected(), jcBoxLavadero.isSelected(),jcBoxCocina.isSelected(),
                     jcBoxComedor.isSelected(), jcBoxLiving.isSelected(), jcBoxCocinaLiving.isSelected(),
                     jcBoxCocinaComedor.isSelected(),jcBoxCocinaLivingComedor.isSelected(),
                     Float.parseFloat(""+spinMTS2.getValue()), Float.parseFloat(""+spinMFondo.getValue()),
                     jcBoxCochera.isSelected(), jcBoxPlantaAlta.isSelected(),jCheckImpuestos.isSelected(), -1,
                     Double.parseDouble(textExpensas.getText()), areaObservacion.getText(),
                     " ",jCheckAgua.isSelected(), jCheckGas.isSelected(), jCheckLuz.isSelected());
            ic.modificar(nuevoI);
        }
        
        
    }
        
        

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void jCheckImpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckImpuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckImpuestosActionPerformed

    private void textExpensasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textExpensasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textExpensasActionPerformed

    private void spinMTS2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinMTS2KeyPressed
        evt.setKeyChar(' ');
    }//GEN-LAST:event_spinMTS2KeyPressed

    private void botonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalir1ActionPerformed
        Window w = SwingUtilities.getWindowAncestor(this);
        w.dispose();
    }//GEN-LAST:event_botonSalir1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservacion;
    private javax.swing.JTextArea areaOtro;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckAgua;
    private javax.swing.JCheckBox jCheckAlquilar;
    private javax.swing.JCheckBox jCheckGas;
    private javax.swing.JCheckBox jCheckImpuestos;
    private javax.swing.JCheckBox jCheckLuz;
    private javax.swing.JCheckBox jCheckVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioBcasa;
    private javax.swing.JRadioButton jRadioBuDepto;
    private javax.swing.JRadioButton jRadioBuLocal;
    private javax.swing.JRadioButton jRadioBuTerreno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcBoxAmoblada;
    private javax.swing.JCheckBox jcBoxCochera;
    private javax.swing.JCheckBox jcBoxCocina;
    private javax.swing.JCheckBox jcBoxCocinaComedor;
    private javax.swing.JCheckBox jcBoxCocinaLiving;
    private javax.swing.JCheckBox jcBoxCocinaLivingComedor;
    private javax.swing.JCheckBox jcBoxComedor;
    private javax.swing.JCheckBox jcBoxLavadero;
    private javax.swing.JCheckBox jcBoxLiving;
    private javax.swing.JCheckBox jcBoxPatio;
    private javax.swing.JCheckBox jcBoxPlantaAlta;
    private javax.swing.JSpinner spinBanio;
    private javax.swing.JSpinner spinHabitacion1;
    private javax.swing.JSpinner spinMFondo;
    private javax.swing.JSpinner spinMTS2;
    private javax.swing.JTextField textBarrio;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textExpensas;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void llenarTabla(ArrayList<Inmueble> listaI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detalles(Inmueble inm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void filtros(int estado, int tipo, int zona, int habitacion, int precio, ArrayList<Inmueble> listaI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void cargarDatosInmueble(Inmueble inm) {
        // ACA TENGO QUE CARGAR LOS DATOS  
        jLabel10.setText(""+inm.getDuenoID());
        textBarrio.setText(inm.getBarrio());
        textPrecio.setText(""+inm.getPrecio());
        textDireccion.setText(""+inm.getDireccion()); 
        textExpensas.setText(""+inm.getExpensas());
        if(inm.getOperacion()==1){
            jCheckVender.setSelected(true);
        }else{
            jCheckAlquilar.setSelected(true);
        }
        switch(inm.getTipo()){
            case 1:{
                jRadioBcasa.setSelected(true);
                break;
            }
            case 2:{
                jRadioBuDepto.setSelected(true);
                break;
            }
            case 3:{
                jRadioBuLocal.setSelected(true);
                break;
            }
            case 4:{
                jRadioBuTerreno.setSelected(true);
                break;
            }
        }             
        spinHabitacion1.setValue(inm.getHabitaciones());
        spinBanio.setValue(inm.getBano()); 
        spinMTS2.setValue(inm.getMetros2()); 
        spinMFondo.setValue(inm.getFondo());
        jcBoxLiving.setSelected(inm.isLiving());
        jcBoxCocina.setSelected(inm.isCocina());
        jcBoxComedor.setSelected(inm.isComedor());  
        jcBoxCocinaComedor.setSelected(inm.isCocinaComedor());
        jcBoxCocinaLiving.setSelected(inm.isCocinaComedor());
        jcBoxCocinaLivingComedor.setSelected(inm.isCocinaLivingComedor());
        jcBoxLavadero.setSelected(inm.isLavadero());
        jcBoxPatio.setSelected(inm.isPatio());
        jcBoxCochera.setSelected(inm.isGarage());
        jcBoxAmoblada.setSelected(inm.isAmoblado());
        jcBoxPlantaAlta.setSelected(inm.isPlantaAlta());
        jCheckAgua.setSelected(inm.isAgua());  
        jCheckLuz.setSelected(inm.isLuz());
        jCheckGas.setSelected(inm.isGas());
        jCheckImpuestos.setSelected(inm.isImpuestos());
        areaObservacion.setText(inm.getObservaciones()); 
    }

    @Override
        public void cargarDatosClientes(Cliente cte){
            jLabel17.setText(cte.getNombre());
        }
    @Override
    public void cargarClientes(ArrayList a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void llenarTablaClientes(ArrayList<Cliente> listaC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void llenarAsesores(ArrayList<Asesor> listaA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaAltaCliente(boolean exito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaModifCliente(boolean exito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaDeleteCliente(boolean exito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void llenarTablaInmuebles(ArrayList<Inmueble> inmueblesDueño, ArrayList<Inmueble> inmueblesAlquilando) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaDeleteInmueble(boolean baja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void respuestaAlta(boolean exito) {
        if (exito){
            JOptionPane.showMessageDialog(this, "El inmueble se ha guardado  con éxito.", "Éxito.",1);
        }else{
            JOptionPane.showMessageDialog(this, "No se ha podido guardar el inmueble..", "Error.",2);
        }
    }

    @Override
    public void respuestaModificar(boolean exito) {
        if (exito){
            JOptionPane.showMessageDialog(this, "El inmueble se ha Modificado  con éxito.", "Éxito.",1);
        }else{
            JOptionPane.showMessageDialog(this, "No se ha podido Modificar el inmueble..", "Error.",2);
        }
    }
}
