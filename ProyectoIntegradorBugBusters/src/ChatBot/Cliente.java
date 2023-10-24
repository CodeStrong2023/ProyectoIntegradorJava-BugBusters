
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
        this.telefono = telefono;
        this.correo = correo;
    }

    // Constructor sin argumentos
    public Cliente() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.fechaNacimiento = "";
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
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

    public String getDireccion() { return direccion; }

    public String getTelefono() {
        returntelefono;
    }

    public String getCorreo) { return correo; }


    //Setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

