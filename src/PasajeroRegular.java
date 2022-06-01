//package TrabajoProgramacion.aereopuertoProyect.src;

public class PasajeroRegular extends Pasajero {
    private int noAsiento;


    public PasajeroRegular(String nombre, String noPasaporte, String noTelefono, String correoElectronico, int edad) {
        super(nombre, noPasaporte, noTelefono, correoElectronico, edad);
    }

    public int getNoAsiento() {
        return noAsiento;
    }

    public void setNoAsiento(int noAsiento) {
        this.noAsiento = noAsiento;
    }

    @Override
    public String mostrarPasajero() {
        String pasajero = "Tipo; Regular.\n";
        pasajero += "Nombre: " + getNombre() + ", Pasaporte: " + getNoPasaporte() + "\n";
        pasajero += "Correo: " + getCorreoElectronico() + " - Asiento: " + noAsiento;
        return pasajero;
    }
}
