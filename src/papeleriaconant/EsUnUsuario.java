/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author paulo
 */
public class EsUnUsuario extends javax.swing.JDialog {
    ArrayList<Producto> listaPro = new ArrayList<Producto>();
    ArrayList<VentasProducidas> listaVentas = new ArrayList<VentasProducidas>();
    String ruta = "data/ventas.obj";


    public EsUnUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    public EsUnUsuario(java.awt.Frame parent, boolean modal,ArrayList<Producto> listaMetodo) {
        super(parent, modal);
        initComponents();
        setListaPro(listaMetodo);
    }

    public ArrayList<Producto> getListaPro() {
        return listaPro;
    }

    public void setListaPro(ArrayList<Producto> listaPro) {
        this.listaPro = listaPro;
    }

    public double cacularTotal(){
        double suma= 0;

        for (Producto Ps:listaPro){
            Ps.getCantidad();
            suma += (Ps.getCantidad()) * (Ps.getPrecioUnitario());
        }
        return suma;
    }
    public void escribirListaVentas() {
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream(ruta));
            escribiendoFichero.writeObject(listaVentas);
            escribiendoFichero.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void leerListaDeVentas() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(ruta));
//
            listaVentas = (ArrayList<VentasProducidas>) leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String nombreProductosVendidos(){
        String resultado = "";
        for (Producto pod:listaPro) {
            resultado +=" , " + pod.getNombreDelProducto();

        }
        return resultado;
    }
    public String numeroDePiezasVendidas(){
        String resultado = "";
        for (Producto pod:listaPro) {
            resultado +=" , " + String.valueOf(pod.getCantidad());

        }
        return resultado;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        siBtn = new javax.swing.JToggleButton();
        noBtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("¿Es un cliente registrado?");

        siBtn.setText("Si");
        siBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siBtnActionPerformed(evt);
            }
        });

        noBtn.setText("No");
        noBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(siBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(noBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siBtn)
                    .addComponent(noBtn))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siBtnActionPerformed
        // TODO add your handling code here:
        InserteUnUsuario iU = new InserteUnUsuario(listaPro);
        this.setVisible(false);
        iU.setVisible(true);

    }//GEN-LAST:event_siBtnActionPerformed

    private void noBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noBtnActionPerformed
        // TODO add your handling code here:
        leerListaDeVentas();
        Calendar cal = Calendar.getInstance();
        Date fechaActualDelNo = new Date();
        VentasProducidas ventaProducidaSinUsuario = new VentasProducidas(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,
                fechaActualDelNo.getYear(), fechaActualDelNo.getHours(),nombreProductosVendidos(), numeroDePiezasVendidas(),cacularTotal());
        listaVentas.add(ventaProducidaSinUsuario);
        escribirListaVentas();
        this.setVisible(false);
        JOptionPane.showMessageDialog(this, "Su compra se realizo con exito");
        Main abrirMain = new Main();
        abrirMain.setLocationRelativeTo(null);
        abrirMain.setVisible(true);
    }//GEN-LAST:event_noBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EsUnUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EsUnUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EsUnUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EsUnUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EsUnUsuario dialog = new EsUnUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton noBtn;
    private javax.swing.JToggleButton siBtn;
    // End of variables declaration//GEN-END:variables
}
