package Tarjetas;

public class Credito extends Tarjeta {
    double limiteDeCredito = 30000.00;

    public void limiteDeCredito() {
        System.out.println("El limite de Credito es: " + limiteDeCredito);
    }
}