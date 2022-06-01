
import java.util.ArrayList;

public class PasajeroVip extends Pasajero {

    private int noAsiento;
    private ArrayList<String> comodidades;

    public PasajeroVip(String nombre, String noPasaporte, String noTelefono, String correoElectronico, int edad) {
        super(nombre, noPasaporte, noTelefono, correoElectronico, edad);
        comodidades = new ArrayList<>();
    }

    public int getNoAsiento() {
        return noAsiento;
    }

    public void setNoAsiento(int noAsiento) {
        this.noAsiento = noAsiento;
    }

    public void addComodidad(String comodidad) {
        comodidades.add(comodidad);
    }

    @Override
    public String mostrarPasajero() {
        String pasajero = "Tipo: VIP.\n";
        pasajero += "Nombre: " + getNombre() + ", Pasaporte: " + getNoPasaporte() + "\n";
        pasajero += "Correo: " + getCorreoElectronico() + " - Asiento: " + noAsiento + "\n";
        pasajero += "Comodidades: " + "\n-------------\n";
        for (String comodidad : comodidades) {
            pasajero += comodidad + "\n";
        }
        pasajero += "-------------";
        return pasajero;
    }
}
