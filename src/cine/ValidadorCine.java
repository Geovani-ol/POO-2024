package cine;

import peliculas.Funciones;
import peliculas.Pelicula;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class ValidadorCine {

    public boolean validarDisponibilidadSala(LocalTime horaInicio, LocalTime horaFin, String nombreSala, ArrayList<Funciones> listaFunciones){
        for(Funciones funcion : listaFunciones){

            if(funcion.getSala().getNombre() == nombreSala && horaInicio.isAfter(funcion.getHorarioInicio()) ){
                if (horaInicio.isBefore(funcion.getHorarioFin()) && horaFin.isAfter(funcion.getHorarioInicio())){

                    return false;
                }
            }
        }
        return true;
    }

    /**Cine cine = new Cine();
    Random random = new Random();
    ArrayList<Funciones> listaFunciones = cine.listaFunciones;
    ArrayList<Pelicula> peliculasReproducidas = cine.peliculasReproducidas;
    ArrayList<Pelicula> listaPeliculas = cine.listaPeliculas;

    public boolean validarPeliculaCorrecta(int peliculaDeseada) {

        int posicion = random.nextInt(0,listaPeliculas.size()-1);
        String id = listaPeliculas.get(posicion).getId();
        Pelicula pelicula = peliculasReproducidas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if (pelicula == null) {
            return false;
        }
        return true;
    }*/

}
