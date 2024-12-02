package Tarjetas;
import java.time.LocalDateTime;

public class Tarjeta {
    public String titular;
    public int numeroTarjeta;
    public LocalDateTime fechaCreacion;
    public double saldo;
    public int cvv;
    public int clabeInterbancaria;
    public LocalDateTime fechaVencimiento;

    public Tarjeta() {
    }

    public Tarjeta(String titular) {
        this.titular = titular;
    }

    public Tarjeta(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //getters
    public String getTitular() {
        return titular;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public int getCvv() {
        return cvv;
    }

    public int getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    //setters
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumero(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setClabeInterbancaria(int clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    //metodos

    public String mostrarDatosTarjeta() {
        return String.format(" Titular:  s% | Numero Tarjeta: s% | Fecha Creacion: s% | CVV: s% | Clabe Interbancaria: s% | Fecha de Vencimiento: s%  ",this.getTitular(), this.getNumeroTarjeta(), this.getFechaCreacion(), this.getCvv(), this.getClabeInterbancaria(), this.getFechaVencimiento());

    }
}
