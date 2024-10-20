package peliculas;

import salas.Sala;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Funciones {
    public int id;
    public Pelicula pelicula;
    public Sala sala;
    public LocalTime horarioInicio;
    public LocalTime horarioFin;


    public Funciones(int id, Pelicula pelicula, Sala sala, LocalTime horarioInicio, LocalTime horarioFin) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public String mostrarDatos() {
        return String.format("ID: %d   |   Pelicula: %s  |   %s  |  horario Inicio: %s  |  horario Fin: %s",
                getId(),
                pelicula.getTitulo(),
                sala.getNombre(),
                horarioInicio.toString(),
                horarioFin.toString());
    }

    // Getters...
    public int getId() {
        return id;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public Sala getSala() {
        return sala;
    }
    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }
    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFin(LocalTime horarioFin) {
        this.horarioFin = horarioFin;
    }
}