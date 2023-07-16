/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vistas;

import com.mycompany.controlador.*;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Date;
import static java.time.temporal.ChronoUnit.DAYS;
import javax.swing.ImageIcon;
//import static java.util.concurrent.TimeUnit.DAYS;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class PaqueteViajes extends javax.swing.JFrame {
    private ImagenFondo fondo=new ImagenFondo();
    private ControladorClienteEmp controlador = new ControladorClienteEmp();
    private DefaultTableModel modelo = new DefaultTableModel();
    private static final double PAQUETE_GALAPAGOS = 400; //Alojamiento por 4 DIAS incluye lugar recreacionales
    private static final double PAQUETE_CARTAGENA = 300; //Alojamiento por 4 DIAS incluye lugar recreacionales
    private static final double PAQUETE_PANAMA = 500; //Alojamiento por 4 dias incluye lugar recreacional
    private static final double PAQUETE_LIMA = 350; //Alojamiento por 4 DIAS incluye lugar recreacionales
    private static final double PAQUETE_ORLANDO = 750; //Alojamiento por 4 DIAS 

    public PaqueteViajes() {
        this.setContentPane( fondo);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        jTableClientes.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CORREO");
        modelo.addColumn("CEDULA");
        modelo.addColumn("DESTINO");
        modelo.addColumn("FECHA_SALIDA");
        modelo.addColumn("FECHA_REGRESO");
        modelo.addColumn("TRANSPORTE_APROX");
        modelo.addColumn("NUM_ADULTOS");
        modelo.addColumn("NUM_NIÑOS");
        modelo.addColumn("NUM_MAYORES");
        modelo.addColumn("HOTEL");
        modelo.addColumn("ALIMENTACION");
        modelo.addColumn("TRANSPORTE_LOCAL");
        modelo.addColumn("GUIA");
        modelo.addColumn("LUGARES_RECREACION");
        modelo.addColumn("PRECIO");
        listarClientes();
    }

    public void listarClientes() {
        controlador.listarClientes(modelo);

    }

    public void limpiarTabla() {

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;

        }
    }

    public void limpiarCampos() {
        jTxtFieldNombre.setText("");
        jTxtFieldApellido.setText("");
        jTxtFieldCorreo.setText("");
        jTxtFieldCedula.setText("");
        jComboBDestinos.setSelectedIndex(0);
        jComboBTransporteAprox.setSelectedIndex(0);
        jComboBHotel.setSelectedIndex(0);
        jSpinnerAdultos.setValue(0);
        jSpinnerNiños.setValue(0);
        jSpinnerMayores.setValue(0);
        jCheckBTranporteLocal.setSelected(false);
        jCheckBGuia.setSelected(false);
        jCheckBAlimentacion.setSelected(false);
        jDateFechaSalida.setDate(null);
        jDateFechaRegreso.setDate(null);

    }

    public double calculodePrecios(long numberofDAYS) {
        double preciototal = 0;
        double cargoDias = 0;
        double cargoTransporteAprox = 0;
        double cargoHotel = 0;
        double cargoGuia = 0;
        double cargoAlimentacion = 0;
        double transporteLocal = 0;
        double totalAdultos;
        double totalKids;  //10% de descuento
        double totalMayores; //10% de descuento
        double cargoLugaresR = 0;

        //Precios Galapagos 
        if (jComboBDestinos.getSelectedItem().equals("Galapagos")) {
            if (numberofDAYS > 4) {
                cargoDias = (numberofDAYS - 4) * 45;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Avion")) {
                cargoTransporteAprox = 580;
            }

            if (jComboBHotel.getSelectedItem().equals("Marriot") || jComboBHotel.getSelectedItem().equals("Hilton")) {
                cargoHotel = 80;
            }
            if (jCheckBGuia.isSelected()) {
                cargoGuia = 20;
            }
            if (jCheckBAlimentacion.isSelected()) {
                cargoAlimentacion = 20;
            }
            if (jCheckBTranporteLocal.isSelected()) {
                transporteLocal = 20;
            }

            //total por calisificaion de edad
            totalAdultos = (PAQUETE_GALAPAGOS + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerAdultos.getValue();
            totalKids = ((PAQUETE_GALAPAGOS * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerNiños.getValue();
            totalMayores = ((PAQUETE_GALAPAGOS * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerMayores.getValue();
            preciototal = totalAdultos + totalKids + totalMayores;

        }

        //Precios Cartagena 
        if (jComboBDestinos.getSelectedItem().equals("Cartagena")) {
            if (numberofDAYS > 4) {
                cargoDias = (numberofDAYS - 4) * 45;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Avion")) {
                cargoTransporteAprox = 210;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Bus")) {
                cargoTransporteAprox = 95;
            }

            if (jComboBHotel.getSelectedItem().equals("Marriot") || jComboBHotel.getSelectedItem().equals("Hilton")) {
                cargoHotel = 80;
            }
            if (jCheckBGuia.isSelected()) {
                cargoGuia = 20;
            }
            if (jCheckBAlimentacion.isSelected()) {
                cargoAlimentacion = 20;
            }
            if (jCheckBTranporteLocal.isSelected()) {
                transporteLocal = 20;
            }

            //total por calisificaion de edad
            totalAdultos = (PAQUETE_CARTAGENA + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerAdultos.getValue();
            totalKids = ((PAQUETE_CARTAGENA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerNiños.getValue();
            totalMayores = ((PAQUETE_CARTAGENA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerMayores.getValue();
            preciototal = totalAdultos + totalKids + totalMayores;

        }

        //Precios Panama
        if (jComboBDestinos.getSelectedItem().equals("Panama")) {
            if (numberofDAYS > 4) {
                cargoDias = (numberofDAYS - 4) * 50;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Avion")) {
                cargoTransporteAprox = 490;
            }

            if (jComboBHotel.getSelectedItem().equals("Marriot") || jComboBHotel.getSelectedItem().equals("Hilton")) {
                cargoHotel = 80;
            }
            if (jCheckBGuia.isSelected()) {
                cargoGuia = 20;
            }
            if (jCheckBAlimentacion.isSelected()) {
                cargoAlimentacion = 20;
            }
            if (jCheckBTranporteLocal.isSelected()) {
                transporteLocal = 20;
            }

            //total por calisificaion de edad
            totalAdultos = (PAQUETE_PANAMA + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerAdultos.getValue();
            totalKids = ((PAQUETE_PANAMA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerNiños.getValue();
            totalMayores = ((PAQUETE_PANAMA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerMayores.getValue();
            preciototal = totalAdultos + totalKids + totalMayores;

        }

        //Precios Lima
        if (jComboBDestinos.getSelectedItem().equals("Lima")) {
            if (numberofDAYS > 4) {
                cargoDias = (numberofDAYS - 4) * 50;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Avion")) {
                cargoTransporteAprox = 250;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Bus")) {
                cargoTransporteAprox = 55;
            }

            if (jComboBHotel.getSelectedItem().equals("Marriot") || jComboBHotel.getSelectedItem().equals("Hilton")) {
                cargoHotel = 80;
            }
            if (jCheckBGuia.isSelected()) {
                cargoGuia = 20;
            }
            if (jCheckBAlimentacion.isSelected()) {
                cargoAlimentacion = 20;
            }
            if (jCheckBTranporteLocal.isSelected()) {
                transporteLocal = 20;
            }

            //total por calisificaion de edad
            totalAdultos = (PAQUETE_LIMA + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerAdultos.getValue();
            totalKids = ((PAQUETE_LIMA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerNiños.getValue();
            totalMayores = ((PAQUETE_LIMA * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal) * (int) jSpinnerMayores.getValue();
            preciototal = totalAdultos + totalKids + totalMayores;

        }
        //Precios Orlando
        if (jComboBDestinos.getSelectedItem().equals("Orlando")) {
            if (numberofDAYS > 4) {
                cargoDias = (numberofDAYS - 4) * 50;
            }
            if (jComboBTransporteAprox.getSelectedItem().equals("Avion")) {
                cargoTransporteAprox = 690;
            }

            if (jComboBTransporteAprox.getSelectedItem().equals("Crucero")) {
                cargoTransporteAprox = 1300;
            }

            if (jComboBHotel.getSelectedItem().equals("Marriot") || jComboBHotel.getSelectedItem().equals("Hilton")) {
                cargoHotel = 100;
            }
            if (jCheckBGuia.isSelected()) {
                cargoGuia = 20;
            }
            if (jCheckBTranporteLocal.isSelected()) {
                transporteLocal = 40;
            }
            if (jComboBRecreacion.getSelectedItem().equals("Universal")) {
                cargoLugaresR = 120;

            }
            if (jComboBRecreacion.getSelectedItem().equals("DisneyWorld")) {
                cargoLugaresR = 135;

            }
            if (jComboBRecreacion.getSelectedItem().equals("Ninguno")) {
                cargoLugaresR = 0;

            }

            //total por calisificaion de edad
            totalAdultos = (PAQUETE_ORLANDO + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal + cargoLugaresR) * (int) jSpinnerAdultos.getValue();
            totalKids = ((PAQUETE_ORLANDO * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal + cargoLugaresR) * (int) jSpinnerNiños.getValue();
            totalMayores = ((PAQUETE_ORLANDO * 0.9) + cargoDias + cargoTransporteAprox + cargoHotel + cargoGuia + cargoAlimentacion + transporteLocal + cargoLugaresR) * (int) jSpinnerMayores.getValue();
            preciototal = totalAdultos + totalKids + totalMayores;

        }

        return preciototal;
    }

    public boolean verificarInformacion(long numberOFDays) {
//        

        if (jTxtFieldNombre.getText().equals("")
                || jTxtFieldApellido.getText().equals("")
                || jTxtFieldCorreo.getText().equals("")
                || jTxtFieldCedula.getText().equals("")
                || jComboBDestinos.getSelectedIndex() == 0
                || ((int) jSpinnerAdultos.getValue() == 0 && (int) jSpinnerNiños.getValue() == 0 && (int) jSpinnerMayores.getValue() == 0)
                || jComboBHotel.getSelectedIndex() == 0
                || jComboBTransporteAprox.getSelectedIndex() == 0
                || jComboBRecreacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "CAMPOS INCOMPLETOS");
            return false;
        } else if (numberOFDays < 4 || numberOFDays > 7) {
            JOptionPane.showMessageDialog(null, "ESCOJA UNA FECHA VALIDA MAYOR A 3 DIAS E INFERIOR A 8 DIAS");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new ImagenFondo();
        jPanel3 = new ImagenFondo();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTxtFieldCedula = new javax.swing.JTextField();
        jTxtFieldCorreo = new javax.swing.JTextField();
        jTxtFieldApellido = new javax.swing.JTextField();
        jTxtFieldNombre = new javax.swing.JTextField();
        jBtnAgregar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jSpinnerAdultos = new javax.swing.JSpinner();
        jSpinnerNiños = new javax.swing.JSpinner();
        jSpinnerMayores = new javax.swing.JSpinner();
        jDateFechaSalida = new com.toedter.calendar.JDateChooser();
        jDateFechaRegreso = new com.toedter.calendar.JDateChooser();
        jCheckBGuia = new javax.swing.JCheckBox();
        jCheckBAlimentacion = new javax.swing.JCheckBox();
        jCheckBTranporteLocal = new javax.swing.JCheckBox();
        jComboBRecreacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jBtnFacturar = new javax.swing.JButton();
        jComboBDestinos = new javax.swing.JComboBox<>();
        jComboBTransporteAprox = new javax.swing.JComboBox<>();
        jComboBHotel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Nombre :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Apellido :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Correo Electrónico :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Cédula :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Lugar de Destino :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Fecha de Salida :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Fecha de Regreso :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Transporte de Aproximación :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Número de Adultos :");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Número de Niños :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Adultos Tercera Edad :");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Hotel :");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Alimentación :");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Transporte Local :");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Guía :");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Lugares de Recreación :");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Stencil", 2, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 204, 204));
        jLabel36.setText("Paquete de Viajes");

        jTxtFieldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFieldCedulaKeyTyped(evt);
            }
        });

        jTxtFieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFieldApellidoKeyTyped(evt);
            }
        });

        jTxtFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFieldNombreKeyTyped(evt);
            }
        });

        jBtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        jBtnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jBtnCancelar.setBackground(new java.awt.Color(102, 255, 102));
        jBtnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jSpinnerAdultos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jSpinnerNiños.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jSpinnerMayores.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jCheckBGuia.setText("Si");

        jCheckBAlimentacion.setText("Si");
        jCheckBAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBAlimentacionActionPerformed(evt);
            }
        });

        jCheckBTranporteLocal.setText("Si");
        jCheckBTranporteLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBTranporteLocalActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        jBtnFacturar.setBackground(new java.awt.Color(153, 153, 255));
        jBtnFacturar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jBtnFacturar.setText("Facturar");
        jBtnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFacturarActionPerformed(evt);
            }
        });

        jComboBDestinos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Galapagos", "Cartagena", "Panama", "Lima", "Orlando" }));
        jComboBDestinos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBDestinosItemStateChanged(evt);
            }
        });

        jComboBHotel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "HolidayInn", "Marriot", "HardRock Hotel", "Hilton" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBTransporteAprox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinnerNiños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinnerAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jSpinnerMayores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtFieldCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(jTxtFieldApellido)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jDateFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBRecreacion, 0, 113, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jBtnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(231, 231, 231)
                                        .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(198, 198, 198)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBTranporteLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jTxtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jTxtFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTxtFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTxtFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jComboBDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jComboBTransporteAprox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jSpinnerAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jSpinnerMayores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jSpinnerNiños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jDateFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel26))
                            .addComponent(jDateFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jComboBHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jComboBRecreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jCheckBTranporteLocal)
                    .addComponent(jLabel34)
                    .addComponent(jCheckBGuia)
                    .addComponent(jLabel32)
                    .addComponent(jCheckBAlimentacion))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar)
                    .addComponent(jBtnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jBtnFacturar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBTranporteLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBTranporteLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBTranporteLocalActionPerformed

    private void jCheckBAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBAlimentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBAlimentacionActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFacturarActionPerformed
        // TODO add your handling code here:
        if (jTableClientes.getSelectedRow() >= 0) {
            int selectindex=jTableClientes.getSelectedRow();
            String [] paquete=new String[11];
            double subtotal=Double.parseDouble(String.valueOf(jTableClientes.getValueAt(selectindex, 17)));
            String nombre=String.valueOf(jTableClientes.getValueAt(selectindex, 1));
            String apellido=String.valueOf(jTableClientes.getValueAt(selectindex, 2));
            String cedula=String.valueOf(jTableClientes.getValueAt(selectindex, 4));
            paquete[0]=String.valueOf(jTableClientes.getValueAt(selectindex, 5));
            paquete[1]=String.valueOf(jTableClientes.getValueAt(selectindex, 6));
            paquete[2]=String.valueOf(jTableClientes.getValueAt(selectindex, 7));
            paquete[3]=String.valueOf(jTableClientes.getValueAt(selectindex, 8));
            paquete[4]=Integer.toString((int)jTableClientes.getValueAt(selectindex, 9)+(int)jTableClientes.getValueAt(selectindex, 10)+(int)jTableClientes.getValueAt(selectindex, 11));
            paquete[5]=String.valueOf(jTableClientes.getValueAt(selectindex, 12));
            paquete[6]=String.valueOf(jTableClientes.getValueAt(selectindex, 13));
            paquete[7]=String.valueOf(jTableClientes.getValueAt(selectindex, 14));
            paquete[8]=String.valueOf(jTableClientes.getValueAt(selectindex, 15));
            paquete[9]=String.valueOf(jTableClientes.getValueAt(selectindex, 16));
            paquete[10]=String.valueOf(jTableClientes.getValueAt(selectindex, 17));
            //instanciar clase
            Factura factura = new Factura();
            factura.obtenerDatos(paquete, subtotal, nombre, apellido, cedula);
            factura.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "ESCOJA UN PAQUETE A FACTURAR");
        }


    }//GEN-LAST:event_jBtnFacturarActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = jTxtFieldNombre.getText();
            String apellido = jTxtFieldApellido.getText();
            String correo = jTxtFieldCorreo.getText();
            String cedula = jTxtFieldCedula.getText();
            String destino = String.valueOf(jComboBDestinos.getSelectedItem());

            java.util.Date fechaSaliDa = jDateFechaSalida.getDate();
            //Transformar fecha
            long fechaSalidaTransformar = fechaSaliDa.getTime();
            Date fechaActualSalida = new Date(fechaSalidaTransformar);

            java.util.Date fechaRegreso = jDateFechaRegreso.getDate();
            long fechaRegresoTransformar = fechaRegreso.getTime();
            Date fechaActualRegreso = new Date(fechaRegresoTransformar);

            long numberOFDays = DAYS.between(fechaActualSalida.toLocalDate(), fechaActualRegreso.toLocalDate());

            String trasporteAprox = String.valueOf(jComboBTransporteAprox.getSelectedItem());
            int numAdultos = (int) jSpinnerAdultos.getValue();
            int numKids = (int) jSpinnerNiños.getValue();
            int numMayores = (int) jSpinnerMayores.getValue();
            String hotel = String.valueOf(jComboBHotel.getSelectedItem());
            boolean alimentacion = jCheckBAlimentacion.isSelected();
            boolean transporteLocal = jCheckBTranporteLocal.isSelected();
            boolean guia = jCheckBGuia.isSelected();
            String lugarRecreacion = String.valueOf(jComboBRecreacion.getSelectedItem());
            double precio = calculodePrecios(numberOFDays);

            //Enviar datos al controlador
            if (verificarInformacion(numberOFDays)) {
                int registros = controlador.insertarCliente(nombre, apellido, correo, cedula, destino, fechaActualSalida, fechaActualRegreso, trasporteAprox, numAdultos, numKids, numMayores, hotel, alimentacion, transporteLocal, guia, lugarRecreacion, precio);
                if (registros != 0) {
                    JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE");
                    limpiarTabla();
                    limpiarCampos();
                    listarClientes();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE INSERTO");
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Elija una fecha", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jTxtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFieldNombreKeyTyped
        // TODO add your handling code here:
        Validaciones validacion = new Validaciones();
        validacion.validarLetras(evt);

    }//GEN-LAST:event_jTxtFieldNombreKeyTyped

    private void jTxtFieldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFieldApellidoKeyTyped
        // TODO add your handling code here:
        Validaciones validacion = new Validaciones();
        validacion.validarLetras(evt);
    }//GEN-LAST:event_jTxtFieldApellidoKeyTyped

    private void jTxtFieldCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFieldCedulaKeyTyped
        // TODO add your handling code here:
        Validaciones validacion = new Validaciones();
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_jTxtFieldCedulaKeyTyped

    private void jComboBDestinosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBDestinosItemStateChanged
        // TODO add your handling code here:
        if (jComboBDestinos.getSelectedItem().equals("Galapagos")) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "IslaBaltra", "Tortuga Bay"}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Avion"}));
        }
        if (jComboBDestinos.getSelectedItem().equals("Cartagena")) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "ParquedelCentenario", "ParquedeBolivar"}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Avion", "Bus"}));

        }
        if (jComboBDestinos.getSelectedItem().equals("Panama")) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "CanaldePanama", "Cinta Costera"}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Avion"}));
        }
        if (jComboBDestinos.getSelectedItem().equals("Lima")) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Parque Sinchi", "Skate Park"}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Avion", "Bus"}));
        }
        if (jComboBDestinos.getSelectedItem().equals("Orlando")) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Ninguno", "Universal", "DisneyWorld"}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Seleccionar", "Avion", "Crucero"}));
        }
        if (jComboBDestinos.getSelectedIndex() == 0) {
            jComboBRecreacion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{""}));
            jComboBTransporteAprox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{""}));
        }

    }//GEN-LAST:event_jComboBDestinosItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaqueteViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaqueteViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaqueteViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaqueteViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaqueteViajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnFacturar;
    private javax.swing.JCheckBox jCheckBAlimentacion;
    private javax.swing.JCheckBox jCheckBGuia;
    private javax.swing.JCheckBox jCheckBTranporteLocal;
    private javax.swing.JComboBox<String> jComboBDestinos;
    private javax.swing.JComboBox<String> jComboBHotel;
    private javax.swing.JComboBox<String> jComboBRecreacion;
    private javax.swing.JComboBox<String> jComboBTransporteAprox;
    private com.toedter.calendar.JDateChooser jDateFechaRegreso;
    private com.toedter.calendar.JDateChooser jDateFechaSalida;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerAdultos;
    private javax.swing.JSpinner jSpinnerMayores;
    private javax.swing.JSpinner jSpinnerNiños;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTxtFieldApellido;
    private javax.swing.JTextField jTxtFieldCedula;
    private javax.swing.JTextField jTxtFieldCorreo;
    private javax.swing.JTextField jTxtFieldNombre;
    // End of variables declaration//GEN-END:variables

public class ImagenFondo extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon("src/main/java/Images/fondopaquete.jpg").getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}

}
