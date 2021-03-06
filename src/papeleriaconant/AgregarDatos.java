/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import java.io.*;
import java.util.ArrayList;

/**
 * @author paulo
 */
public class AgregarDatos extends javax.swing.JInternalFrame {
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    int definiendoConstructor;
    int colSeleccionada;
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Creates new form AgregarDetos
     */

    public AgregarDatos(){
        initComponents();
        definiendoConstructor = 1;
    }
    public AgregarDatos(String rutaDelMain) {
        ruta = rutaDelMain;
        definiendoConstructor = 1;
        initComponents();
    }

    //constructor para modificar datos
    public AgregarDatos(int indiceDelaColumnaSeleccionada,String rutaDelMain) {
        initComponents();
        colSeleccionada = indiceDelaColumnaSeleccionada;
        ruta = rutaDelMain;
        definiendoConstructor = 0;
        this.repaint();
        this.setResizable(true);

    }

    public String getStringIdTxt() {
        return idTxt.getText();
    }

    public String getStringNombreDeCatalogo() {
        return catalogoTxt.getText();
    }

    public String getStringNombreProducto() {
        return nombreTxt.getText();
    }

    public String getStringDescripcion() {
        return descripcionTxt.getText();
    }

    public int getIntCantidad() {
        return Integer.parseInt(cantidadTxt.getText());
    }

    public double getDoublePrecioUnitario() {
        return Double.parseDouble(precioUnitarioTxt.getText());
    }

    //Lee lo que escribio el usuario y los introduce a la lista
    private void llenarLista() {
        String catalogo = getStringNombreDeCatalogo();
        String id = getStringIdTxt();
        String nombreDelProducto = getStringNombreProducto();
        String descripcion = getStringDescripcion();
        int cantidad = getIntCantidad();
        double precioUnitario = getDoublePrecioUnitario();
        Producto product = new Producto(catalogo, nombreDelProducto, id, descripcion, cantidad, precioUnitario);
        listaProductos.add(product);
    }

        //llenar la lista con un indice de la lista para la opcion de modificat
    private void llenarLista(int indiceDeLaLista) {

        String catalogo = getStringNombreDeCatalogo();
        String id = getStringIdTxt();
        String nombreDelProducto = getStringNombreProducto();
        String descripcion = getStringDescripcion();
        int cantidad = getIntCantidad();
        double precioUnitario = getDoublePrecioUnitario();
        Producto product = new Producto(catalogo, nombreDelProducto, id, descripcion, cantidad, precioUnitario);
        listaProductos.set(indiceDeLaLista, product);


    }

    //Aqui recibe lo que tenga el archivo y lo mete a una listaProductos
    private void leerlista() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(ruta));
            System.out.println("Esta es la ruta en el try" + ruta);
            listaProductos = (ArrayList<Producto>) leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("Esta es la ruta en el catch" + ruta);
        }
    }

    //escribe el fichero con los datos que estan en la lista
    private void outProductos() {
        try {
            System.out.println("Esta es la ruta"+ruta);
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream(ruta));
            escribiendoFichero.writeObject(listaProductos);
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

        jLabel1 = new javax.swing.JLabel();
        catalogoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        descripcionTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cantidadTxt = new javax.swing.JTextField();
        agregarBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        precioUnitarioTxt = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setText("Nombre de catalogo");

        jLabel2.setText("ID producto");

        jLabel3.setText("Nombre del producto");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Cantidad");

        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio unitario");

        precioUnitarioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioUnitarioTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(precioUnitarioTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(catalogoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcionTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidadTxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(38, 38, 38)
                        .addComponent(agregarBtn)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catalogoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioUnitarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        if (definiendoConstructor == 0) {
            leerlista();
            llenarLista(colSeleccionada);
            outProductos();
            this.setVisible(false);
        } else {
            leerlista();
            llenarLista();
            outProductos();
            this.setVisible(false);
        }
//      this.setVisible(false);
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void precioUnitarioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioUnitarioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioUnitarioTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JTextField catalogoTxt;
    private javax.swing.JTextField descripcionTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField precioUnitarioTxt;
    // End of variables declaration//GEN-END:variables
}
