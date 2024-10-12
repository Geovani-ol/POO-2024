package usuarios.empleados;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Empleado extends Usuario {
    public String rfc;

    public Empleado(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String direccion, String contrasenia, String rfc) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, direccion, contrasenia, Rol.EMPLEADO);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public String mostrarDatos(){
        return String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Telefono: %s  |  Dirección: %s  |  RFC: %s",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getDireccion(),
                getRfc());
    }
}
