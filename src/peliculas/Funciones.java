package peliculas;

import salas.Sala;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Funciones {
    private Pelicula pelicula;
    private Sala sala;
    private LocalTime horario;

    public Funciones(Pelicula pelicula, Sala sala, LocalTime horario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
    }

    // Getters and setters...
}