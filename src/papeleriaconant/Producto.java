/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleriaconant;

import java.io.Serializable;

/**
 *
 * @author paulo
 */
public class Producto implements Serializable{
    private String nombreDelCatalogo;
    private String nombreDelProducto;
    private String idProducto;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;


    public Producto(String nombreDelCatalogo, String nombreDelProducto, String idProducto, String descripcion, int cantidad, double precioUnitario) {
        this.nombreDelCatalogo = nombreDelCatalogo;
        this.nombreDelProducto = nombreDelProducto;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
//    public Producto getCloneInstance(){
//        Producto p = new Producto(this.nombreDelCatalogo,this.nombreDelProducto,this.idProducto,this.descripcion,this.cantidad,this.precioUnitario);
//        return p;
//    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }


    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }



    public String getNombreDelCatalogo() {
        return nombreDelCatalogo;
    }

    public void setNombreDelCatalogo(String nombreDelCatalogo) {
        this.nombreDelCatalogo = nombreDelCatalogo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
