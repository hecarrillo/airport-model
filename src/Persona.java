//package TrabajoProgramacion.aereopuertoProyect.src;

public class Persona {
    private String nombre;
    private String noTelefono;
    private String correoElectronico;

    private final int edad;

    public Persona(int edad) {
        this(null, null, null, edad);
    }

    public Persona(String nombre, String noTelefono, String correoElectronico, int edad) {
        this.nombre = nombre;
        this.noTelefono = noTelefono;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getNoTelefono() {
        return noTelefono;
    }

    protected void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }

    protected String getCorreoElectronico() {
        return correoElectronico;
    }

    protected void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    protected int getEdad() {
        return edad;
    }

}
