package usuarios.cliente;

import Tarjetas.Credito;
import Tarjetas.Debito;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Cliente extends Usuario {
    private String numeroCuenta;
    private Debito tarjetaDebito;
    private Credito tarjetaCredito;

    public Cliente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, Debito tarjetaDebito, Credito tarjetaCredito, String numeroCuenta) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.CLIENTE);
        this.tarjetaDebito = null;
        this.tarjetaCredito = null;
        this.numeroCuenta = numeroCuenta;
    }
    //metodo mostrar datos


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void setTarjetaDebito(Debito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }
}
