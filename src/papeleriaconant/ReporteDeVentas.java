/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class ReporteDeVentas extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<VentasProducidas> listaVentas = new ArrayList<VentasProducidas>();
    private VentasProducidas objVentasProducidas;

    public ArrayList<VentasProducidas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<VentasProducidas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public ReporteDeVentas() {
        super("Reporte de ventas");
        initComponents();
        leerArchivo();
        setModelo();
        setDatos();
    }
    public void setModelo() {
        String[] cabecera = {"Dia","Mes","hora", "Nombre del producto Vendido ", "numero de piezas vendidas", "total"};
        modelo.setColumnIdentifiers(cabecera);
        tblReporte.setModel(modelo);
    }
    private void setDatos() {
        Object[] datos = new Object[modelo.getColumnCount()];
        modelo.setRowCount(0);
        for (VentasProducidas theprod : listaVentas) {
            datos[0] = theprod.getDia();
            datos[1] = theprod.getMes();
            datos[2] = theprod.getHora();
            datos[3] = theprod.getNombreProductosVendidos();
            datos[4] = theprod.getNumeroDePiezasDeProductosVendidos();
            datos[5] = theprod.getTotalDeVenta();
            modelo.addRow(datos);
        }
        tblReporte.setModel(modelo);

    }
    public void leerArchivo(){
        ArrayList<VentasProducidas> vP = new ArrayList<VentasProducidas>();
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("data/ventas.obj"));
            objVentasProducidas = (VentasProducidas) leyendoFichero.readObject();
            listaVentas.add(objVentasProducidas);
            leyendoFichero.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Una excepcion de tiempo linea 72: la ruta es " + "data/ventas.obj");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        diaBtn = new javax.swing.JButton();
        mesBtn = new javax.swing.JButton();
        semanaBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblReporte);

        diaBtn.setText("Dia");
        diaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaBtnActionPerformed(evt);
            }
        });

        mesBtn.setText("Mes");
        mesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesBtnActionPerformed(evt);
            }
        });

        semanaBtn.setText("Semana");
        semanaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanaBtnActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(diaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(semanaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(mesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaBtn)
                    .addComponent(semanaBtn)
                    .addComponent(mesBtn))
                .addGap(61, 61, 61)
                .addComponent(jButton4)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaBtnActionPerformed

    private void semanaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semanaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semanaBtnActionPerformed

    private void mesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteDeVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton diaBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mesBtn;
    private javax.swing.JButton semanaBtn;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}