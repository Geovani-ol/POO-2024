package Tarjetas;

import java.time.LocalDateTime;

public class Debito extends Tarjeta {
    private double saldoDebito;
    public Debito(String titular, int numero, LocalDateTime fechaCreacion, int cvv, int clabeInterbancaria, LocalDateTime fechaVencimiento){
        super();
        this.saldoDebito = saldoDebito;
    }
    public double getSaldo() {return saldoDebito;}

    public void setSaldo(double saldo) {this.saldoDebito = saldo;}
}