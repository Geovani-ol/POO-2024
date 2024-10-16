package boletos;

import java.time.LocalDateTime;

public class Boleto {
   // esta pendiente poner de tipo pelivula la pelicula
    public String pelicula;


    public LocalDateTime horario;

    // poner de tipo sala la sala
    public String sala;
    public String asiento;
    public double precio;

    public Boleto(String pelicula, LocalDateTime horario, String sala, String asiento, double precio) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala = sala;
        this.asiento = asiento;
        this.precio = precio;
    }

    public String getPelicula() {
        return pelicula;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }

    public String getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }

   // public String mostrarBoleto() {}
}
