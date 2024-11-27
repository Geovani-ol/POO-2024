package usuarios.cliente;

import usuarios.Usuario;
import usuarios.utils.Rol;

public class Cliente extends Usuario {
    public Cliente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.CLIENTE);
    }

}
