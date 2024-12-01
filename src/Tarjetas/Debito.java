package Tarjetas;

import java.time.LocalDateTime;
import java.util.Date;

public class Debito extends Tarjeta {
     private double saldoDebito;
    Debito debito;
    public Debito (double saldoDebito){
        super();
        this.saldoDebito = saldoDebito;
    }
    public Debito(String titular, int numero, LocalDateTime fechaCreacion, int cvv, int clabeInterbancaria, LocalDateTime fechaVencimiento) {
        super(titular, numero, fechaCreacion, cvv, clabeInterbancaria, fechaVencimiento);
    }

    public double getSaldoDebito() {
        return saldoDebito;
    }
     public void setSaldoDebito(double saldoDebito) {
        this.saldoDebito = saldoDebito;
     }

     public double verificarSaldo() {
         return saldoDebito;
     }
     public void realizarRetiro(double cantidad) {
         if (cantidad <= saldoDebito) {
             saldoDebito -= cantidad;
         }
         public void realizarDeposito (double cantidadDeposito) {
             saldoDebito += cantidadDeposito;
         }
     }
 }