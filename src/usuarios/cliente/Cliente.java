package usuarios.cliente;

import usuarios.Usuario;
import usuarios.utils.Rol;

public class Cliente extends Usuario {
    private String numeroCuenta;

    public Cliente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, Rol rol, String numeroCuenta) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, rol);
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
