/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author paulo
 */
public class Ticket extends javax.swing.JFrame {
    private Usuarios persona = new Usuarios();
    private ArrayList<Producto> productosCompradosPorElUSuario = new ArrayList<Producto>();
    ArrayList<VentasProducidas> ventasProducidas = new ArrayList<VentasProducidas>();
    String ruta = "data/ventas.obj";


    public Usuarios getPersona() {
        return persona;
    }

    public void setPersona(Usuarios persona) {
        this.persona = persona;
    }

    public ArrayList<Producto> getProductosCompradosPorElUSuario() {
        return productosCompradosPorElUSuario;
    }

    public void setProductosCompradosPorElUSuario(ArrayList<Producto> productosCompradosPorElUSuario) {
        this.productosCompradosPorElUSuario = productosCompradosPorElUSuario;
    }

    /**
     * Creates new form SeleccionarUsuario
     */
    public Ticket() {
        initComponents();
    }

    public Ticket(Usuarios per, ArrayList<Producto> productosComprados){
        super("Ticket frame");
        initComponents();
        setPersona(per);
        setProductosCompradosPorElUSuario(productosComprados);
        imprimirElTicket();
        

    }
    public void imprimirElTicket(){
        String usuario,productos = "";
        for (Producto Ps: productosCompradosPorElUSuario) {
            productos += "\nNombre del Producto "+Ps.getNombreDelProducto()+ "\n Id " + Ps.getIdProducto() + "\n" + " \n Cantidad " + Ps.getCantidad() + "\n Precio unitario " + Ps.getPrecioUnitario() ;
        }
        usuario = "Persona "+persona.getNombre()+" "+persona.getApellido()+ " Id " +persona.getIdCliente();

        ticketTxt.setText(usuario+ "\n " +productos+ "\nTotal de compra " + cacularTotal());
    }
    public void leerListaDeVentas() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(ruta));
//
            ventasProducidas = (ArrayList<VentasProducidas>) leyendoFichero.readObject();
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
    public double cacularTotal(){
        double suma= 0;

        for (Producto Ps:productosCompradosPorElUSuario){
            Ps.getCantidad();
            suma += (Ps.getCantidad()) * (Ps.getPrecioUnitario());
        }
        return suma;
    }
    public void escribirListaVentas() {
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream(ruta));
            escribiendoFichero.writeObject(ventasProducidas);
            escribiendoFichero.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());

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
        ticketTxt = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ticketTxt.setColumns(20);
        ticketTxt.setRows(5);
        jScrollPane1.setViewportView(ticketTxt);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Su ticket");

        okBtn.setText("Ok");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(okBtn)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        leerListaDeVentas();
        Date fechaActualDelNo = new Date();
        Calendar cal = Calendar.getInstance();
        VentasProducidas vP = new VentasProducidas(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,
                fechaActualDelNo.getYear(), fechaActualDelNo.getHours(),nombreProductosVendidos(), numeroDePiezasVendidas(),cacularTotal());
        ventasProducidas.add(vP);
        escribirListaVentas();
        this.setVisible(false);
        Main menu = new Main();
        menu.setVisible(true);
    }//GEN-LAST:event_okBtnActionPerformed

    private String numeroDePiezasVendidas() {
        String resultado = "";
        for (Producto pod:productosCompradosPorElUSuario) {
            resultado +=" , " + String.valueOf(pod.getCantidad());

        }
        return resultado;
    }

    private String nombreProductosVendidos() {
        String resultado = "";
        for (Producto pod:productosCompradosPorElUSuario) {
            resultado +=" , " + pod.getNombreDelProducto();

        }
        return resultado;
    }

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
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextArea ticketTxt;
    // End of variables declaration//GEN-END:variables
}
