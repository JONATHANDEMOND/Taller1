/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Factura extends javax.swing.JFrame {
    private ImagenFondo fondo=new ImagenFondo();
    private DefaultTableModel modelo = new DefaultTableModel();
    public Factura() {
         this.setContentPane( fondo);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        jTableDetalleFactura.setModel(modelo);
        modelo.addColumn("DESTINO");
        modelo.addColumn("FECHA_SALIDA");
        modelo.addColumn("FECHA_REGRESO");
        modelo.addColumn("TRANSPORTE_APROX");
        modelo.addColumn("NUM_PERSONAS");
        modelo.addColumn("HOTEL");
        modelo.addColumn("ALIMENTACION");
        modelo.addColumn("TRANSPORTE_LOCAL");
        modelo.addColumn("GUIA");
        modelo.addColumn("LUGARES_RECREACION");
        modelo.addColumn("PRECIO");
    }
    
    public void obtenerDatos(String[] paquete, double subtotal, String nombre, String apellido, String cedula){
        modelo.addRow(paquete);
        jLNombreFactura.setText(nombre.toUpperCase());
        jLApellidoFactura.setText(apellido.toUpperCase());
        jLCedulaFactura.setText(cedula);
        jLSubtotal.setText(Double.toString(subtotal));
        jLIVAFactura.setText(Double.toString(Math.round(subtotal*0.12*100)/100.0));
        jLTotalPagar.setText(Double.toString(Math.round(subtotal*1.12*100)/100.0));
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new ImagenFondo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleFactura = new javax.swing.JTable();
        jLSubtotal = new javax.swing.JLabel();
        jLNombreCampo = new javax.swing.JLabel();
        jLNombreFactura = new javax.swing.JLabel();
        jLCedulaCampo = new javax.swing.JLabel();
        jLApellidoFactura = new javax.swing.JLabel();
        jLCelularCampo = new javax.swing.JLabel();
        jLCedulaFactura = new javax.swing.JLabel();
        jLIVACampo = new javax.swing.JLabel();
        jLSubtotalCampo = new javax.swing.JLabel();
        jLIVAFactura = new javax.swing.JLabel();
        jLTotalCampo = new javax.swing.JLabel();
        jLTotalPagar = new javax.swing.JLabel();
        jLDetalleCompra = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "FACTURA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jTableDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableDetalleFactura);

        jLSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLSubtotal.setText("jLabel7");

        jLNombreCampo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLNombreCampo.setForeground(new java.awt.Color(255, 51, 51));
        jLNombreCampo.setText("Nombre:");

        jLNombreFactura.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLNombreFactura.setText("jLabel7");

        jLCedulaCampo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLCedulaCampo.setForeground(new java.awt.Color(255, 51, 51));
        jLCedulaCampo.setText("Apellido");

        jLApellidoFactura.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLApellidoFactura.setText("jLabel7");

        jLCelularCampo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLCelularCampo.setForeground(new java.awt.Color(255, 51, 51));
        jLCelularCampo.setText("Cedula:");

        jLCedulaFactura.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLCedulaFactura.setText("jLabel7");

        jLIVACampo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLIVACampo.setForeground(new java.awt.Color(255, 51, 51));
        jLIVACampo.setText("I.V.A:");

        jLSubtotalCampo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLSubtotalCampo.setForeground(new java.awt.Color(255, 51, 51));
        jLSubtotalCampo.setText("SUBTOTAL:");

        jLIVAFactura.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLIVAFactura.setText("jLabel7");

        jLTotalCampo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLTotalCampo.setForeground(new java.awt.Color(153, 0, 204));
        jLTotalCampo.setText("TOTAL:");

        jLTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLTotalPagar.setForeground(new java.awt.Color(51, 204, 0));
        jLTotalPagar.setText("jLabel7");

        jLDetalleCompra.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLDetalleCompra.setForeground(new java.awt.Color(255, 153, 51));
        jLDetalleCompra.setText("DETALLE DE LA COMPRA");

        jBtnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jBtnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnAtras.setBackground(new java.awt.Color(102, 255, 102));
        jBtnAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnAtras.setText("ATRAS");
        jBtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLTotalCampo)
                            .addComponent(jLIVACampo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLSubtotalCampo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLIVAFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLDetalleCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCelularCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCedulaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCedulaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLApellidoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombreCampo)
                    .addComponent(jLNombreFactura)
                    .addComponent(jLCedulaCampo)
                    .addComponent(jLApellidoFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCelularCampo)
                    .addComponent(jLCedulaFactura))
                .addGap(72, 72, 72)
                .addComponent(jLDetalleCompra)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnCancelar)
                            .addComponent(jBtnAtras))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLSubtotal)
                            .addComponent(jLSubtotalCampo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLIVACampo)
                            .addComponent(jLIVAFactura))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLTotalCampo)
                            .addComponent(jLTotalPagar))
                        .addGap(76, 76, 76))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtrasActionPerformed
        // TODO add your handling code here:
        PaqueteViajes paqueteVentana=new PaqueteViajes();
        paqueteVentana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBtnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtras;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JLabel jLApellidoFactura;
    private javax.swing.JLabel jLCedulaCampo;
    private javax.swing.JLabel jLCedulaFactura;
    private javax.swing.JLabel jLCelularCampo;
    private javax.swing.JLabel jLDetalleCompra;
    private javax.swing.JLabel jLIVACampo;
    private javax.swing.JLabel jLIVAFactura;
    private javax.swing.JLabel jLNombreCampo;
    private javax.swing.JLabel jLNombreFactura;
    private javax.swing.JLabel jLSubtotal;
    private javax.swing.JLabel jLSubtotalCampo;
    private javax.swing.JLabel jLTotalCampo;
    private javax.swing.JLabel jLTotalPagar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalleFactura;
    // End of variables declaration//GEN-END:variables

public class ImagenFondo extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon("src/main/java/Images/fondofactura3.jpeg").getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}

}
