//package TrabajoProgramacion.aereopuertoProyect.src;//package src.utils;

import java.util.LinkedList;

public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private String fecha;
    private Boolean esNacional;
    // Create an arraylist of pasajeros
    //private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();

    private LinkedList<PasajeroVip> pasajerosVIP;
    private LinkedList<PasajeroRegular> pasajerosRegulares;
    private LinkedList<Integer> asientos;

    public Vuelo() {
        this(null, null, null, null, null, null);
    }

    public Vuelo(String codigo, String origen, String destino, String fecha, String hora, Boolean esNacional) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.esNacional = esNacional;
        pasajerosVIP = new LinkedList<>();
        pasajerosRegulares = new LinkedList<>();
        asientos = new LinkedList<>();
    }

    // Add a pasajero to the arraylist
    /*
    public void addPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }
    */

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

    public void setEsNacional(boolean esNacional) {
        this.esNacional = esNacional;
    }

    // ___________________
    public void addPasajero(PasajeroRegular pasajero) {
        pasajerosRegulares.add(pasajero);
    }

    public void addPasajero(PasajeroVip pasajero) {
        pasajerosVIP.add(pasajero);
    }
    //_______________

    public void eliminarPasajeroVIP(int index) {
        pasajerosVIP.remove(index);
    }

    public void eliminarPasajeroRegular(int index) {
        pasajerosRegulares.remove(index);
    }

    public int getNumeroPasajerosVIP() {
        return pasajerosVIP.size();
    }

    public int getNumeroPasajerosRegulares() {
        return pasajerosRegulares.size();
    }

    public boolean asientoEstaOcupado(int asiento) {
        for (PasajeroVip pasajeroVip : pasajerosVIP) {
            if (pasajeroVip.getNoAsiento() == asiento) {
                return true;
            }
        }
        for (PasajeroRegular pasajeroRegular : pasajerosRegulares) {
            if (pasajeroRegular.getNoAsiento() == asiento) {
                return true;
            }
        }
        return false;
    }

    public boolean existePasajeroVIP(PasajeroVip pasajero) {
        return findPasajeroVIP(pasajero.getNoPasaporte()) != null;
    }

    public boolean existePasajeroRegular(PasajeroRegular pasajeroRegular) {
        return findPasajeroRegular(pasajeroRegular.getNoPasaporte()) != null;
    }

    public PasajeroVip findPasajeroVIP(String noPasaporte) {
        for (PasajeroVip pasajeroVip : pasajerosVIP) {
            if (pasajeroVip.getNoPasaporte().compareTo(noPasaporte) == 0) {
                return pasajeroVip;
            }
        }
        return null;
    }

    public PasajeroRegular findPasajeroRegular(String noPasaporte) {
        for (PasajeroRegular pasajeroRegular : pasajerosRegulares) {
            if (pasajeroRegular.getNoPasaporte().compareTo(noPasaporte) == 0) {
                return pasajeroRegular;
            }
        }
        return null;
    }

    public void mostrarPasajerosVIP() {
        int numero = 1;
        for (PasajeroVip pasajeroVip : pasajerosVIP) {
            System.out.println("Pasajero: " + numero);
            System.out.println(pasajeroVip.mostrarPasajero());
            System.out.println();
            numero ++;
        }
    }

    public void mostrarPasajerosRegulares() {
        int numero = 1;
        for (PasajeroRegular pasajeroRegular : pasajerosRegulares) {
            System.out.println("Pasajero: " + numero);
            System.out.println(pasajeroRegular.mostrarPasajero());
            System.out.println();
        }
    }

    public void mostrarTodosLosPasajeros() {
        for (PasajeroVip pasajeroVip : pasajerosVIP) {
            System.out.println(pasajeroVip.mostrarPasajero());
            System.out.println();
        }
        for (PasajeroRegular pasajeroRegular : pasajerosRegulares) {
            System.out.println(pasajeroRegular.mostrarPasajero());
            System.out.println();
        }
    }

    public int getNumeroDePasajeros() {
        return pasajerosRegulares.size() + pasajerosVIP.size();
    }

    @Override
    public String toString() {
        String vuelo = "Vuelo: " + codigo + "\n";
        vuelo += "Origen: " + origen + " - Destino: " + destino + "\n";
        vuelo += "Es nacional: " + esNacional;
        return vuelo;
    }

}