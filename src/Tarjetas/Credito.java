package Tarjetas;


public class Credito extends Tarjeta {
    private double limiteDeCredito;
    private double deudaCredito;

    public Credito(String titular, String numeroTarjeta) {
        super(titular, numeroTarjeta);
        this.limiteDeCredito = 100000.0;
        this.deudaCredito = 0;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public double getDeudaCredito() {
        return deudaCredito;
    }

    public void setDeudaCredito(double deudaCredito) {
        this.deudaCredito = deudaCredito;
    }

    public void limiteDeCredito(double gasto) {
        setLimiteDeCredito(limiteDeCredito - gasto);
        setDeudaCredito(deudaCredito + gasto);
    }

    @Override
    public String mostrarDatosTarjeta() {
        return super.mostrarDatosTarjeta() + String.format(" | Limite de crédito: %s | Deuda: %s", getLimiteDeCredito(), getDeudaCredito());
    }
}