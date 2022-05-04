package src.utils;
import src.utils.Pasajero;
import java.util.ArrayList;
import java.util.HashMap;

public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private String fecha;
    private Boolean esNacional;
    // Create an arraylist of pasajeros
    private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();

    public Vuelo(String codigo, String origen, String destino, String fecha, String hora, Boolean esNacional) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.esNacional = esNacional;
    }

    // Add a pasajero to the arraylist
    public void addPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getEsNacional() {
        return esNacional;
    }

}