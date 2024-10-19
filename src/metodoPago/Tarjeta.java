package metodoPago;

import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;

import java.time.YearMonth;

public class Tarjeta {
    private String titular;
    private String numeroTarjeta;
    private YearMonth fechaVencimiento;
    private String cvv;
    private String tipoTarjeta;

    public Tarjeta(Cliente clienteEnSesion, String numeroTarjeta, YearMonth fechaVencimiento, String cvv, String tipoTarjeta) {
        this.titular = clienteEnSesion.getNombre() + " " + clienteEnSesion.getApellidos();
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public YearMonth getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String mostrarInformacion() {
        return String.format("Titular:  %s  |  Numero de Tarjeta: %s  |  Fecha de Vencimiento: %02d/%d  |  CVV: %s  |  Tipo de Tarjeta: %s" ,
                getTitular(),
                getNumeroTarjeta(),
                getFechaVencimiento().getMonthValue(),
                getFechaVencimiento().getYear() % 100,
                getCvv(),
                getTipoTarjeta());
    }
}
