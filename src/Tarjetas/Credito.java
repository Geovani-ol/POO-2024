package Tarjetas;

import Tarjetas.Tarjeta;

public class Credito extends Tarjeta {
    boolean puedeSolicitarTarjetaCredito() {return false;}

    double limiteDeCredito = 100000.00;
    double montoMinimo = 30000.00;
    public double saldoCredito;

    public Credito() {
        super();
        this.saldoCredito = limiteDeCredito;
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(double saldoCredito) {
        this.saldoCredito = saldoCredito;
    }
}