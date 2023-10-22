
package ChatBot;

public class Cliente {
    //Atributos
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;

    private String direccion;

    // Constructor con argumentos
    public Cliente(String nombre, String apellido, String dni, String fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    // Constructor sin argumentos
    public Cliente() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.fechaNacimiento = "";
        this.direccion = "";
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() { return direccion; }
}
