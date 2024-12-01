package Tarjetas;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Tarjeta {
    public String titular;
    public int numero;
    public LocalDateTime fechaCreacion;
    public int cvv;
    public int cableInterbancaria;
    public LocalDateTime fechaVencimiento;

    public Tarjeta(String titular,
                   int numero,
                   LocalDateTime fechaCreacion,
                   int cvv,
                   int clabeInterbancaria,
                   LocalDateTime fechaVencimiento) {
    }

    //getters

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
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

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String realizarCompras(){
        return titular;


    public Date calcularFechaVencimiento() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 5);
        return cal.getTime();
        }
    }
}
