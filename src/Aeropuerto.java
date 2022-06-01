//package TrabajoProgramacion.aereopuertoProyect.src;//package TrabajoProgramacion

//-model.src.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private String ciudad;
    private String pais;
    private String terminal;
    private int totalDeVuelos;

    private LinkedList<Vuelo> vuelos;
    private LinkedList<Vuelo> vuelosCancelados;
    private LinkedList<Vuelo> vuelosFinalizados;

    private HashMap<String, Integer> placesVisited;

    private static int numeroDeAeropuerto = 0;

    // Constructor without parameters to add the airport information with the setters
    public Aeropuerto() {
        this(null, null, null, null, null);
    }

    public Aeropuerto(String nombre, String codigo, String ciudad, String pais, String terminal) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.terminal = terminal;
        this.totalDeVuelos = 0;
        vuelos = new LinkedList<>();
        vuelosFinalizados = new LinkedList<>();
        vuelosCancelados = new LinkedList<>();
        placesVisited = new HashMap<>();
        numeroDeAeropuerto ++;
    }

    // Nuevo ____________________________________________________________________________________

    public boolean addVuelo(Vuelo vuelo) {
        if (findVuelo(vuelo.getCodigo()) == null) {
            vuelos.add(vuelo);
            return true;
        }
        return false;
    }

    public void iniciarVuelo(int index) {
        Vuelo vueloIniciado = vuelos.get(index);
        vuelosFinalizados.add(vueloIniciado);
        if (!placesVisited.containsKey(vueloIniciado.getDestino())) {
            placesVisited.put(vueloIniciado.getDestino(), 0);
        } else {
            placesVisited.put(vueloIniciado.getDestino(), placesVisited.get(vueloIniciado.getDestino()) + 1);
        }
        vuelos.remove(vueloIniciado);
    }

    public void cancelarVuelo(int index) {
        vuelosCancelados.add(vuelos.get(index));
        vuelos.remove(vuelos.get(index));
    }

    public Vuelo getVuelo(int index) {
        return vuelos.get(index);
    }

    public int getNumeroVuelosPendidentes() {
        return vuelos.size();
    }

    public int getNumeroVuelosFinalizados() {
        return vuelosFinalizados.size();
    }

    public int getNumeroVuelosCancelados() {
        return vuelosCancelados.size();
    }

    public boolean deleteVuelo(Vuelo vuelo) {
        Vuelo temp = findVuelo(vuelo.getCodigo());
        if (temp != null) {
            for (int i = 0; i < vuelos.size(); i++) {
                if (vuelos.get(i).getCodigo().compareTo(vuelo.getCodigo()) == 0) {
                    vuelos.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteVuelo(int index) {
        vuelos.remove(index);
    }

    public Vuelo findVuelo(String codigoVuelo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getCodigo().compareTo(codigoVuelo) == 0) {
                return vuelo;
            }
        }
        return null;
    }

    public void mostrarVuelos() {
        for (int i = 0; i < vuelos.size(); i++){
            System.out.println("Vuelo numero: " + (i+1));
            System.out.println(vuelos.get(i));
            System.out.println();
        }
    }

    public void mostrarVuelosFinalizados() {
        for (int i = 0; i < vuelosFinalizados.size(); i++){
            System.out.println(vuelosFinalizados.get(i));
            System.out.println();
        }
    }

    public void mostrarVuelosCancelados() {
        for (int i = 0; i < vuelosCancelados.size(); i++){
            System.out.println(vuelosCancelados.get(i));
            System.out.println();
        }
    }

    public String getLugarMasVisitado() {
        int max = 0;
        String lugar = "";
        for (Object key : placesVisited.keySet()) {
            if (placesVisited.get(key) > max) {
                max = placesVisited.get(key);
                lugar = (String) key;
            }
        }
        return lugar;
    }

    //___________________________________________________________________________________________


    // Predeterminado ________________________________________________________________________________________________

    // Create an arraylist of vuelos
    private ArrayList<Vuelo> vuelosPredeterminado = new ArrayList<Vuelo>();

    // Create a hashmap of vuelos with the key as destino and value as array of
    // vuelos
    private HashMap<String, ArrayList<Vuelo>> vuelosADestino = new HashMap<String, ArrayList<Vuelo>>();

    /**
     * Every time a vuelo is added, the total of vuelos is incremented and the vuelo
     * is added to the hashmap
     * 
     * @return
     */
    public void addUnVuelo(Vuelo vuelo) {
        this.totalDeVuelos++;
        this.vuelosPredeterminado.add(vuelo);
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


    //___________________________________________________________________________________________________________________




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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public static int getNumeroDeAeropuerto() {
        return numeroDeAeropuerto;
    }

    @Override
    public String toString() {
        String airportName = "Aereopuerto: " + nombre + "\n";
        airportName += "Ubicado en " + pais + " - " + ciudad + "\n";
        airportName += "Codigo: " + codigo;
        return airportName;
    }
}
