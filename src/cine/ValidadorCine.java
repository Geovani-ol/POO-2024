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

            if(funcion.getSala().getNombre().equals(nombreSala) && horaInicio.isAfter(funcion.getHorarioInicio()) ){
                if (horaInicio.isBefore(funcion.getHorarioFin()) && horaFin.isAfter(funcion.getHorarioInicio())){

                    return false;
                }
            }
        }
        return true;
    }

}
