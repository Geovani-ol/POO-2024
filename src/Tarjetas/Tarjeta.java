package Tarjetas;
import java.time.LocalDateTime;

public class Tarjeta {
    public int numero;
    public LocalDateTime fechaCreacion;
    public double saldo;
    public int cvv;
    public int cableInterbancaria;
    public LocalDateTime fechaVencimiento;
    // constructor


    public Tarjeta(int numero) {

        this.numero = numero;
    }

    public Tarjeta(LocalDateTime fechaCreacion) {

        this.fechaCreacion = fechaCreacion;
    }

    public Tarjeta(double saldo)
    {
        this.saldo = saldo;
    }

    //getters
    public int getNumero() {

        return numero;
    }

    public LocalDateTime getFechaCreacion() {

        return fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getCvv() {

        return cvv;
    }
    public int getCableInterbancaria() {

        return cableInterbancaria;
    }

    public LocalDateTime getFechaVencimiento() {

        return fechaVencimiento;
    }

    //setters
    public void setNumero(int numero) {

        this.numero = numero;
    }
    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {

        this.fechaCreacion = fechaCreacion;
    }
    public void setCvv(int cvv) {

        this.cvv = cvv;
    }
    public void setCableInterbancaria(int cableInterbancaria) {

        this.cableInterbancaria = cableInterbancaria;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {

        this.fechaVencimiento = fechaVencimiento;
    }

    //metodos

    public Tarjeta() {

        this.saldo = saldo;
    }
    }
