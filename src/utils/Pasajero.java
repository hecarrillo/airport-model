package src.utils;
// NOMBRE
// NO. DE PASAPORTE
// NO. DE TELEFONO
// Correo electrónico
// Edad
// 
public class Pasajero {
    private String nombre;
    private String noPasaporte;
    private String noTelefono;
    private String correoElectronico;
    private final int edad;

    public Pasajero(String nombre, String noPasaporte, String noTelefono, String correoElectronico, int edad) {
        this.nombre = nombre;
        this.noPasaporte = noPasaporte;
        this.noTelefono = noTelefono;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(String noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        return edad;
    }
}


