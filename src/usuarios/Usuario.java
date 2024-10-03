package usuarios;

public class Usuario {
    public String id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    public String telefono;

    public Usuario(String id, String nombre, String apellidos, String fechaNacimiento, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
}
