
import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;


public class AereopuertoAministracion {
    Scanner scanner;
    private LinkedList<Aeropuerto> aeropuertos;

    public AereopuertoAministracion() {
        scanner = new Scanner(System.in);
        aeropuertos = new LinkedList<>();
        startMenu();
    }

    public void startMenu() {
        int option = 0;
        int codigo = 0;
        String airportCode = "";
        Aeropuerto aeropuertoTmp = null;
        do {
            System.out.println(
                    "\tMenu\n"
                    + "1.- Ver aereopuertos.\n"
                    + "2.- Agregar aereopuerto.\n"
                    + "3.- Eliminar aereopuerto.\n"
                    + "4.- Administrar aereopuerto.\n"
                    + "5.- Salir."
            );
            System.out.print("Opcion: ");
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida!!");
                scanner.nextLine();
                continue;

            }
            scanner.nextLine();
            switch (option) {
                case 1:
                    if (aeropuertos.size() == 0) {
                        System.out.println("Aun no hay aereopuertos registrados!\n");
                        break;
                    }
                    int num = 1;
                    System.out.println("Numero de aeropuertos: " + Aeropuerto.getNumeroDeAeropuerto());
                    for (Aeropuerto aeropuerto : aeropuertos) {
                        System.out.println("Aereopuerto " + num);
                        System.out.println(aeropuerto + "\n");
                        num++;
                    }
                    break;
                case 2:
                    if (crearAereopuerto()) {
                        System.out.println("Aereopuerto agregado!\n");
                    } else {
                        System.out.println("Error al agregar aereopuerto!\n");
                    }
                    break;
                case 3:
                    if (aeropuertos.size() == 0) {
                        System.out.println("Aun no hay aeropuertos registrados!\n");
                        break;
                    }
                    System.out.print("Ingrese el codigo del aeropuerto: ");
                    airportCode = scanner.nextLine();
                    aeropuertoTmp = findAirport(airportCode);
                    if (aeropuertoTmp != null) {
                        System.out.println("Aereopuerto " + aeropuertoTmp.getNombre() + " (codigo: " + aeropuertoTmp.getCodigo() + ") eliminado!\n");
                        aeropuertos.remove(aeropuertoTmp);
                    } else {
                        System.out.println("El codigo del aeropuerto no esta registrado!\n");
                    }
                    break;
                case 4:
                    if (aeropuertos.size() == 0) {
                        System.out.println("Aun no hay aeropuertos registrados!\n");
                        break;
                    }
                    System.out.print("Ingrese el codigo del aeropuerto: ");
                    airportCode = scanner.nextLine();
                    aeropuertoTmp = findAirport(airportCode);
                    if (aeropuertoTmp != null) {
                        airportMenu(aeropuertoTmp);
                    } else {
                        System.out.println("Aereopuerto con codigo " + airportCode + " no registrado!!\n");
                    }
                    break;
                case 5:
                    System.out.println("bye!\n");
                    break;
                default:
                    System.out.println("Opcion invalida!\n");
                    break;
            }
        } while (option != 5);
    }

    private boolean crearAereopuerto() {
        Aeropuerto aeropuertoTmp = new Aeropuerto();
        String airportCode = "";
        try {
            System.out.print("Ingrese el nombre del aeropuerto: ");
            aeropuertoTmp.setNombre(scanner.nextLine());
            System.out.print("Ingrese el codigo del aeropuerto: ");
            airportCode = scanner.nextLine();
            if (airportExists(airportCode)) {
                System.out.println("El codigo del aeropuerto ya a sido registrado!\n");
                return false;
            }
            aeropuertoTmp.setCodigo(airportCode);
            System.out.print("Ingrese el pais donde esta el aeropuerto: ");
            aeropuertoTmp.setPais(scanner.nextLine());
            System.out.print("Ingrese la Ciudad donde esta el aeropuerto: ");
            aeropuertoTmp.setCiudad(scanner.nextLine());
            System.out.print("Ingrese la terminal del aeropuerto: ");
            aeropuertoTmp.setTerminal(scanner.nextLine());
        } catch (Exception exception) {
            System.out.println("Datos invalidos!");
            return false;
        }
        aeropuertos.add(aeropuertoTmp);
        return true;
    }

    private boolean airportExists(String code) {
        return findAirport(code) != null;
    }

    private Aeropuerto findAirport(String code) {
        for (Aeropuerto aeropuerto : aeropuertos) {
            if (aeropuerto.getCodigo().compareTo(code) == 0) {
                return aeropuerto;
            }
        }
        return null;
    }
    private void airportMenu(Aeropuerto airport) {
        int option = 0;
        int ans = 0;
        String codigoVuelo = "";
        Vuelo vueloAux = null;
        do {
            System.out.println(
                    "\tAereopuerto " + airport.getNombre() + " menu\n"
                    + "1.- Agendar nuevo vuelo.\n"
                    + "2.- Vuelos pendientes.\n"
                    + "3.- Iniciar vuelo pendiente.\n"
                    + "4.- Vuelos finalizados.\n"
                    + "5.- Cancelar vuelo.\n"
                    + "6.- Vuelos cancelados.\n"
                    + "7.- Administrar vuelo.\n"
                    + "8.- Lugar mas visitado.\n"
                    + "9.- Regresar."
            );
            System.out.print("Opcion: ");
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida!!\n");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            switch (option) {
                case 1:
                    if (crearVuelo(airport)) {
                        System.out.println("Vuelo agregado!");
                    } else {
                        System.out.println("Error al ingresar aeropuerto!");
                    }
                    break;
                case 2:
                    if (airport.getNumeroVuelosPendidentes() == 0) {
                        System.out.println("No hay vuelos pendientes\n");
                        break;
                    }
                    airport.mostrarVuelos();
                    System.out.println("\n");
                    break;
                case 3:
                    if (airport.getNumeroVuelosPendidentes() == 0) {
                        System.out.println("No hay vuelos pendientes\n");
                        break;
                    }
                    System.out.println("Que vuelo iniciara?");
                    airport.mostrarVuelos();
                    System.out.print("Opcion: ");
                    try {
                        ans = scanner.nextInt();
                        if (ans > 0 && ans <= airport.getNumeroVuelosPendidentes()) {
                            airport.iniciarVuelo(ans-1);
                        } else {
                            System.out.println("Opcion no valida!!\n");
                            break;
                        }
                        System.out.println("Vuelo iniciado!\n");
                    } catch (Exception e) {
                        System.out.println("Error al ingresar numero de vuelo!\n");
                    }
                    break;
                case 4:
                    if (airport.getNumeroVuelosFinalizados() == 0) {
                        System.out.println("Aun no hay vuelos finalizados!\n");
                        break;
                    }
                    airport.mostrarVuelosFinalizados();
                    System.out.println("\n");
                    break;
                case 5:
                    if (airport.getNumeroVuelosPendidentes() == 0) {
                        System.out.println("No hay vuelos pendientes\n");
                        break;
                    }
                    System.out.println("Que vuelo cancelara?");
                    airport.mostrarVuelos();
                    System.out.print("Opcion: ");
                    try {
                        ans = scanner.nextInt();
                        if (ans > 0 && ans <= airport.getNumeroVuelosPendidentes()) {
                            airport.cancelarVuelo(ans-1);
                        } else {
                            System.out.println("Opcion incorrecta!\n");
                            break;
                        }
                        System.out.println("Vuelo cancelado!\n");
                    } catch (Exception e) {
                        System.out.println("Error al ingresar numero de vuelo!\n");
                    }
                    break;
                case 6:
                    if (airport.getNumeroVuelosCancelados() == 0) {
                        System.out.println("Aun no hay vuelos cancelados!\n");
                        break;
                    }
                    airport.mostrarVuelosCancelados();
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.print("Ingrese el codigo del vuelo: ");
                    codigoVuelo = scanner.nextLine();
                    vueloAux = airport.findVuelo(codigoVuelo);
                    if (vueloAux != null) {
                        menuVuelo(vueloAux);
                    } else {
                        System.out.println("Vuelo con codigo: " + codigoVuelo + " no registrado!\n");
                    }
                    break;
                case 8:
                    if (airport.getNumeroVuelosFinalizados() == 0) {
                        System.out.println("Aun no se han realizado vuelos!\n");
                        break;
                    }
                    System.out.println("Lugar mas visitado: " + airport.getLugarMasVisitado() + "\n");
                    break;
                case 9:
                    System.out.println("saliendo!");
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (option != 9);
    }

    private boolean crearVuelo(Aeropuerto airport) {
        int option = 0;
        boolean esNacional = false;
        String vueloCodigo = "";
        Vuelo nuevoVuelo = new Vuelo();
        System.out.print("Ingrese el codigo del vuelo: ");
        vueloCodigo = scanner.nextLine();
        if (airport.findVuelo(vueloCodigo) == null) {
            nuevoVuelo.setCodigo(vueloCodigo);
        } else {
            System.out.println("Vuelo con codigo " + vueloCodigo + " ya existe!\n");
            return false;
        }
        nuevoVuelo.setOrigen(airport.getPais() + "-" +airport.getCiudad());
        System.out.print("Ingrese el destino del vuelo: ");
        nuevoVuelo.setDestino(scanner.nextLine());
        System.out.print("Ingrese la fecha del vuelo: ");
        nuevoVuelo.setFecha(scanner.nextLine());
        System.out.println("El vuelo es Nacional?");
        do {
            System.out.println(
                    "1.- Verdadero.\n"
                            + "2.- Falso."
            );
            System.out.print("Opcion: ");
            try {
                option = scanner.nextInt();
                esNacional = option == 1;
                if (option != 1 && option != 2) {
                    System.out.println("Opcion no valida!");
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida!");
                scanner.nextLine();
            }
        } while (option != 1 && option != 2);
        nuevoVuelo.setEsNacional(esNacional);
        airport.addVuelo(nuevoVuelo);
        return true;
    }

    private void menuVuelo(Vuelo vuelo) {
        int option = 0;
        int asiento = 0;
        String comodidad = "";
        PasajeroRegular pasajeroRegularTemp = null;
        PasajeroVip pasajeroVIPTmp = null;
        do {
            System.out.println(
                    "\t vuelo: " + vuelo.getCodigo() + " - menu\n"
                    + "1.- Agregar pasajero VIP\n"
                    + "2.- Eliminar Pasajero VIP\n"
                    + "3.- Agregar pasajero.\n"
                    + "4.- Eliminar Pasajero.\n"
                    + "5.- Mostrar todos los pasajeros.\n"
                    + "6.- Regresar."
            );
            System.out.print("Opcion: ");
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            switch (option) {
                case 1:
                    pasajeroVIPTmp = crearPasajeroVIP();
                    if (pasajeroVIPTmp == null) {
                        System.out.println("Error al ingresar pasajero!");
                        break;
                    }
                    if (!vuelo.existePasajeroVIP(pasajeroVIPTmp)) {
                        System.out.print("Ingrese el asiento del pasajero: ");
                        do {
                            asiento = scanner.nextInt();
                            if (vuelo.asientoEstaOcupado(asiento)) {
                                System.out.println("Asiento esta ocupado!");
                            }
                        } while (vuelo.asientoEstaOcupado(asiento));
                        scanner.nextLine();
                        pasajeroVIPTmp.setNoAsiento(asiento);
                        System.out.println("Ingrese las comodidades del pasajero (stop para parar): ");
                        do {
                            System.out.println("Comodidad: ");
                            comodidad = scanner.nextLine();
                            if (comodidad.compareTo("stop") != 0) {
                                pasajeroVIPTmp.addComodidad(comodidad);
                            }
                        } while (comodidad.compareTo("stop") != 0);
                    } else {
                        System.out.println("Pasajero con pasaporte " + pasajeroVIPTmp.getNoPasaporte() + " ya esta registrado!\n");
                        break;
                    }
                    vuelo.addPasajero(pasajeroVIPTmp);
                    System.out.println("Pasajero agregado al vuelo!");
                    break;
                case 2:
                    if (vuelo.getNumeroPasajerosVIP() == 0) {
                        System.out.println("Aun no hay pasajeros VIP!\n");
                        break;
                    }
                    System.out.println("Pasajeros VIP:");
                    vuelo.mostrarPasajerosVIP();
                    System.out.print("Opcion: ");
                    try {
                        option = scanner.nextInt();
                        if (option > 0 && option <= vuelo.getNumeroPasajerosVIP()) {
                            vuelo.eliminarPasajeroVIP(option-1);
                            option = 0;
                            System.out.println("Pasajero eliminado!\n");
                        } else {
                            System.out.println("Opcion no valida!\n");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Opcion no valida!!!\n");
                    }
                    break;
                case 3:
                    pasajeroRegularTemp =  crearPasajeroRegular();
                    if (pasajeroRegularTemp == null) {
                        System.out.println("Error al ingresar pasajero!");
                        break;
                    }
                    if (!vuelo.existePasajeroRegular(pasajeroRegularTemp)) {
                        System.out.print("Ingrese el asiento del pasajero: ");
                        do {
                            asiento = scanner.nextInt();
                            if (vuelo.asientoEstaOcupado(asiento)) {
                                System.out.println("Asiento esta ocupado!");
                            }
                        } while (vuelo.asientoEstaOcupado(asiento));
                        pasajeroRegularTemp.setNoAsiento(asiento);
                    } else {
                        System.out.println("Pasajero con pasaporte " + pasajeroVIPTmp.getNoPasaporte() + " ya esta registrado!\n");
                        break;
                    }
                    vuelo.addPasajero(pasajeroRegularTemp);
                    System.out.println("Pasajero agregado al vuelo!");
                    break;
                case 4:
                    if (vuelo.getNumeroPasajerosRegulares() == 0) {
                        System.out.println("Aun no hay pasajeros regulares!\n");
                        break;
                    }
                    System.out.println("Pasajeros:");
                    vuelo.mostrarPasajerosRegulares();
                    System.out.print("Opcion: ");
                        option = scanner.nextInt();
                        if (option > 0 && option <= vuelo.getNumeroPasajerosVIP()) {
                            vuelo.eliminarPasajeroRegular(option-1);
                            option = 0;
                            System.out.println("Pasajero eliminado!\n");
                        } else {
                            System.out.println("Opcion no valida!\n");
                            break;
                        }

                    break;
                case 5:
                    System.out.println("Pasajeros: ");
                    vuelo.mostrarTodosLosPasajeros();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida!\n");
                    break;
            }
        } while (option != 6);
    }

    private PasajeroVip crearPasajeroVIP() {
        int age = 0;
        System.out.print("Ingrese el nombre del pasajero: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la edad del pasajero: ");
        try {
            age = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Edad ingresada no es valida!\n");
            return null;
        }
        scanner.nextLine();
        System.out.print("Ingrese el numero del pasajero: ");
        String numeroPasajero = scanner.nextLine();
        System.out.print("Ingrese el correo del pasajero: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el numero de pasaporte: ");
        String noPasaporte = scanner.nextLine();
        return new PasajeroVip(name, noPasaporte, numeroPasajero, correo, age);
    }

    private PasajeroRegular crearPasajeroRegular() {
        int age = 0;
        System.out.print("Ingrese el nombre del pasajero: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la edad del pasajero: ");
        try {
            age = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Edad ingresada no es valida!\n");
            return null;
        }
        scanner.nextLine();
        System.out.print("Ingrese el numero del pasajero: ");
        String numeroPasajero = scanner.nextLine();
        System.out.print("Ingrese el correo del pasajero: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el numero de pasaporte: ");
        String noPasaporte = scanner.nextLine();
        return new PasajeroRegular(name, noPasaporte, numeroPasajero, correo, age);
    }

}
