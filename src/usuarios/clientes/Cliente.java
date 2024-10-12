package usuarios.clientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public String curp;

    public Cliente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String direccion, String contrasenia, String curp) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, direccion, contrasenia, Rol.CLIENTE);
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public String mostrarDatos(){
        return String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Telefono: %s  |  Dirección: %s  |  CURP: %s",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getDireccion(),
                getCurp());
    }
}
