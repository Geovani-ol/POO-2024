package usuarios.empleados;

import usuarios.Usuario;
import usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.HashMap;

public class Empleado extends Usuario {
    public String rfc;
    public HashMap<String, RegistroHoras> registros;

    public Empleado(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String direccion, String contrasenia, String rfc, HashMap<String, RegistroHoras> registros) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, direccion, contrasenia, Rol.EMPLEADO);
        this.rfc = rfc;
        this.registros = new HashMap<>();
    }

    public String getRfc() {
        return rfc;
    }

    public HashMap<String, RegistroHoras> getRegistros() {
        return registros;
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

    public RegistroHoras obtenerHoras(String nombreEmpleado) {
        return registros.get(nombreEmpleado);
    }
}
