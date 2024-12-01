package Tarjetas;

import java.time.LocalDateTime;
import Tarjetas.Tarjeta;
import Tarjetas.Debito;

public class Credito extends Tarjeta {
    double limiteDeCredito = 100000.00;

    public Credito(String titular, int numero, LocalDateTime fechaCreacion, int cvv, int clabeInterbancaria, LocalDateTime fechaVencimiento) {
        super(titular, numero, fechaCreacion, cvv, clabeInterbancaria, fechaVencimiento);
    }

    public double getLimiteDeCredito() {

        return limiteDeCredito;
}
    public void limiteDeCredito(){
        this.limiteDeCredito = limiteDeCredito + limiteDeCredito;
    }
}