package usuarios;

public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String curp;
    private String rfc;
    private String direccion;
    private String sucursal;
    private String contrasenia;

    public Usuario(int id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.rfc = rfc;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public String getRfc() {
        return rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
