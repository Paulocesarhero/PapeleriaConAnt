package papeleriaconant;
import java.io.*;


public class VentasProducidas implements Serializable {
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private String nombreProductosVendidos;
    private String numeroDePiezasDeProductosVendidos;
    private double totalDeVenta;

    public VentasProducidas(int dia, int mes, int anio, int hora, String nombreProductosVendidos, String numeroDePiezasDeProductosVendidos, double totalDeVenta) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.nombreProductosVendidos = nombreProductosVendidos;
        this.numeroDePiezasDeProductosVendidos = numeroDePiezasDeProductosVendidos;
        this.totalDeVenta = totalDeVenta;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getNombreProductosVendidos() {
        return nombreProductosVendidos;
    }

    public void setNombreProductosVendidos(String nombreProductosVendidos) {
        this.nombreProductosVendidos = nombreProductosVendidos;
    }

    public String getNumeroDePiezasDeProductosVendidos() {
        return numeroDePiezasDeProductosVendidos;
    }

    public void setNumeroDePiezasDeProductosVendidos(String numeroDePiezasDeProductosVendidos) {
        this.numeroDePiezasDeProductosVendidos = numeroDePiezasDeProductosVendidos;
    }

    public double getTotalDeVenta() {
        return totalDeVenta;
    }

    public void setTotalDeVenta(double totalDeVenta) {
        this.totalDeVenta = totalDeVenta;
    }
}
