/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

/**
 * @author paulo
 */
public class VentasFrame extends javax.swing.JFrame {
    public ArrayList<Producto> listaCatalogos = new ArrayList<Producto>();
    public ArrayList<Producto> listaCarrito = new ArrayList<Producto>();

    DefaultTableModel modeloProductosVenta = new DefaultTableModel();
    DefaultTableModel modeloCarrito = new DefaultTableModel();
    String ruta = "data/adhesivosProductos.obj";
    String rutaCarrito = "data/listaCarrito.obj";

    /**
     * Creates new form VentasFrame
     */
    public VentasFrame() {
        initComponents();
        setModelo();

    }


    private void setModelo() {
        String[] cabecera = {"Id", "Nombre", "Descripcion", "Piezas", "Precio Unitario"};
        modeloProductosVenta.setColumnIdentifiers(cabecera);
        modeloCarrito.setColumnIdentifiers(cabecera);

        productosVentaTbl.setModel(modeloProductosVenta);
        carritoTbl.setModel(modeloCarrito);
        leerlista();

    }

    //set datos a la tabla Productos A la venta
    private void setDatos(DefaultTableModel modelo, ArrayList<Producto> lista, JTable tabla) {
        Object[] datos = new Object[modelo.getColumnCount()];
        modelo.setRowCount(0);
        for (Producto theprod : lista) {
            datos[0] = theprod.getIdProducto();
            datos[1] = theprod.getNombreDelProducto();
            datos[2] = theprod.getDescripcion();
            datos[3] = theprod.getCantidad();
            datos[4] = theprod.getPrecioUnitario();
            modelo.addRow(datos);
        }
        tabla.setModel(modelo);

    }

    private void leerlista() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(ruta));
            listaCatalogos = (ArrayList<Producto>) leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Una excepcion de tiempo linea 72: la ruta es " + ruta);
        }
    }

    private void escribirLista(String ruta) {
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream(ruta));
            escribiendoFichero.writeObject(listaCatalogos);
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
        variableRuta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        carritoTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        regresaBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productosVentaTbl = new javax.swing.JTable();
        agregarAlCarritoBtn = new javax.swing.JButton();
        realizarCompraBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        variableRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Adhesivos", "Artes", "Escritura", "Generales", "Papeles", "Regalos"}));
        variableRuta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                variableRutaItemStateChanged(evt);
            }
        });
        variableRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                variableRutaActionPerformed(evt);
            }
        });

        carritoTbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane1.setViewportView(carritoTbl);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Carrito");

        regresaBtn.setText("Regresar");
        regresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresaBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Productos a la venta");

        productosVentaTbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane2.setViewportView(productosVentaTbl);

        agregarAlCarritoBtn.setText("Agregar al carrito");
        agregarAlCarritoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAlCarritoBtnActionPerformed(evt);
            }
        });

        realizarCompraBtn.setText("Realizar compra");
        realizarCompraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarCompraBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(variableRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(86, 86, 86))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(realizarCompraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(regresaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(55, 55, 55))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(agregarAlCarritoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(variableRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(realizarCompraBtn))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(agregarAlCarritoBtn))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(regresaBtn)))
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void agregarAlCarritoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAlCarritoBtnActionPerformed
        // TODO add your handling code here:
        if (productosVentaTbl.getSelectedRow() >= 0) {
            //creamos el JDialog para pregunatar al usuario cuantas piezas va comprar
            int enStock = listaCatalogos.get(productosVentaTbl.getSelectedRow()).getCantidad();
            if (enStock <= 0) {
                JOptionPane.showMessageDialog(this, "Ya no hay articulos en existencia");
            } else {
                Producto aux = listaCatalogos.get(productosVentaTbl.getSelectedRow());

                Piezas preguntarCuantasPiezas = new Piezas(this, true, aux);

                preguntarCuantasPiezas.setVisible(true);

                //lo agregamos a la lista correspondiente y ademas lo imprimimos a la tabla del carrito
                listaCarrito.add(preguntarCuantasPiezas.getProductoPiezaSeleccionada());
//                System.out.println("Cantidad que se tiene lista carrito line 263 " + listaCarrito.get(1).getCantidad()) ;
                setDatos(modeloCarrito, listaCarrito, carritoTbl);
//                escribirLista(rutaCarrito);
                this.repaint();


                //Eliminamos los productosSeleccionados de la lista del catalogo
                int resta = (enStock) - (aux.getCantidad());
                Producto productoReducidoPorElUSuario = listaCatalogos.get(productosVentaTbl.getSelectedRow());
                productoReducidoPorElUSuario.setCantidad(resta);
                listaCatalogos.set(productosVentaTbl.getSelectedRow(), productoReducidoPorElUSuario);
                escribirLista(ruta);
            }


        } else {
            JOptionPane.showMessageDialog(this, "Fila no seleccionada");
        }
    }//GEN-LAST:event_agregarAlCarritoBtnActionPerformed

    private void regresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresaBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Main regresarAlMain = new Main();
        regresarAlMain.setVisible(true);
    }//GEN-LAST:event_regresaBtnActionPerformed

    private void variableRutaActionPerformed(java.awt.event.ActionEvent event) {

    }

    private void variableRutaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_variableRutaItemStateChanged
        // TODO add your handling code here:
        switch (variableRuta.getSelectedIndex()) {
            case 0:
                ruta = "data/adhesivosProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
            case 1:
                ruta = "data/artesProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
            case 2:
                ruta = "data/escrituraProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
            case 3:
                ruta = "data/generalesProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
            case 4:
                ruta = "data/papelesProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
            case 5:
                ruta = "data/regalosProductos.obj";
                leerlista();
                setDatos(modeloProductosVenta, listaCatalogos, productosVentaTbl);
                this.repaint();
                break;
        }

    }//GEN-LAST:event_variableRutaItemStateChanged

    private void realizarCompraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarCompraBtnActionPerformed
        // TODO add your handling code here:
        if (listaCarrito.size() <= 0) {
            JOptionPane.showMessageDialog(this, "Debe de seleccionar al de la tabla Productos a la venta");
        } else {
            EsUnUsuario eUU = new EsUnUsuario(this, true,listaCarrito);
            eUU.setVisible(true);

        }
    }//GEN-LAST:event_realizarCompraBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarAlCarritoBtn;
    private javax.swing.JTable carritoTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productosVentaTbl;
    private javax.swing.JButton realizarCompraBtn;
    private javax.swing.JButton regresaBtn;
    private javax.swing.JComboBox<String> variableRuta;
    // End of variables declaration//GEN-END:variables
}
