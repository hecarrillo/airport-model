package src.utils;

import src.utils.Vuelo;
import java.util.ArrayList;
import java.util.HashMap;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private String ciudad;
    private String pais;
    private String terminal;
    private int totalDeVuelos;

    // Create an arraylist of vuelos
    private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

    // Create a hashmap of vuelos with the key as destino and value as array of
    // vuelos
    private HashMap<String, ArrayList<Vuelo>> vuelosADestino = new HashMap<String, ArrayList<Vuelo>>();

    public Aeropuerto(String nombre, String codigo, String ciudad, String pais, String terminal) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.terminal = terminal;
        this.totalDeVuelos = 0;
    }

    /**
     * Every time a vuelo is added, the total of vuelos is incremented and the vuelo
     * is added to the hashmap
     * 
     * @return
     */
    public void addVuelo(Vuelo vuelo) {
        this.totalDeVuelos++;
        this.vuelos.add(vuelo);
        // Checamos si el destino ya existe en vuelosADestino
        if (this.vuelosADestino.containsKey(vuelo.getDestino())) {
            // Si existe, agregamos el vuelo al array de vuelos a ese destino
            this.vuelosADestino.get(vuelo.getDestino()).add(vuelo);
        } else {
            // Si no existe, creamos un array de vuelos y agregamos el destino a
            // vuelosADestino
            ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
            vuelos.add(vuelo);
            this.vuelosADestino.put(vuelo.getDestino(), vuelos);
        }
    }

    /**
     * Get the most pupular destination of the airport
     * 
     * @return
     */

    // public String getDestinoMasPopular() {
    //     String destino;
    //     int maximaCantidadDeVuelos = 0;
    //     for (Entry<String, ArrayList<Vuelo>> destinoAVuelo : vuelosADestino.entrySet()) {
    //         if (destinoAVuelo.)
    //     }
    // }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getTerminal() {
        return terminal;
    }
}
