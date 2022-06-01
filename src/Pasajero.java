//package TrabajoProgramacion.aereopuertoProyect.src;

//package src.utils;
// NOMBRE
// NO. DE PASAPORTE
// NO. DE TELEFONO
// Correo electrónico
// Edad
// 
public class Pasajero extends Persona{
    private String noPasaporte;

    public Pasajero(String nombre, String noPasaporte, String noTelefono, String correoElectronico, int edad) {
        super(nombre, noTelefono, correoElectronico, edad);
        this.noPasaporte = noPasaporte;
    }

    protected String getNoPasaporte() {
        return noPasaporte;
    }

    protected void setNoPasaporte(String noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    protected String mostrarPasajero() {
        String pasajero = "Nombre: " + getNombre() + ", Pasaporte: " + getNoPasaporte() + "\n";
        pasajero += "Correo: " + getCorreoElectronico() + " - Numero: " + getNoTelefono();
        return mostrarPasajero();
    }

}


