package cine;

import peliculas.Funciones;

import java.time.LocalTime;
import java.util.ArrayList;

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
