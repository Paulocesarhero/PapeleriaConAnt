package papeleriaconant;

import java.io.Serializable;

public class Usuarios extends Persona implements Serializable {
    private String idCliente;
    private String numeroDeTelefono;
    private String correoElectronico;

    public Usuarios() {
    }

    public Usuarios(String idCliente, String numeroDeTelefono, String correoElectronico) {
        this.idCliente = idCliente;
        this.numeroDeTelefono = numeroDeTelefono;
        this.correoElectronico = correoElectronico;
    }

    public Usuarios(String nombre, String apellido, String direccion, int edad, String idCliente, String numeroDeTelefono, String correoElectronico) {
        super(nombre, apellido, direccion, edad);
        this.idCliente = idCliente;
        this.numeroDeTelefono = numeroDeTelefono;
        this.correoElectronico = correoElectronico;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
