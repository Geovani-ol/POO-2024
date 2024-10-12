package usuarios.administradores;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {
    public String rfc;
    public Double sueldo;
    public int antiguedad;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String direccion, String contrasenia, String rfc, Double sueldo, int antiguedad) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, direccion, contrasenia, Rol.ADMINISTRADOR);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }

    public String getRfc() {
        return rfc;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String mostrarDatos(){
        return String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Telefono: %s  |  Dirección: %s  |  RFC: %s  |  Sueldo: %f  |  Antiguedad: %d",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getDireccion(),
                getRfc(),
                getSueldo(),
                getAntiguedad());
    }
}
