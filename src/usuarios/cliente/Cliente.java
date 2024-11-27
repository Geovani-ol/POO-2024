package usuarios.cliente;

import Tarjetas.Credito;
import Tarjetas.Debito;
import usuarios.Usuario;
import usuarios.utils.Rol;
public class Cliente extends Usuario {
    private Debito tarjetaDebito;
    private Credito tarjetaCredito;


    public Cliente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, Debito tarjetaDebito, Credito tarjetaCredito) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.CLIENTE);
        this.tarjetaDebito = null;
        this.tarjetaCredito = null;
    }
    //metodo mostrar datos
}
