package hospital;

import consultas.Consulta;
import consultorios.Consultorio;

import java.util.ArrayList;

public class ValidadorHospital {

    // Consulltorio

    public boolean validarLugarConsultorio(int piso, int numeroConsultorio, ArrayList<Consultorio> listaConsultorios) {
        for (Consultorio consultorio : listaConsultorios) {
            if (consultorio.getPiso() == piso && consultorio.getNumeroConsultorio() == numeroConsultorio) {
                return false;
            }
        }

        return true;
    }

    // Consulta

    public boolean validarDisponibilidadEnFechaConsulta(String fecheDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fecheDeseada) && numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
                return false;
            }
        }

        return true;
    }

    public boolean validarDisponibilidadMedico(String fechaDeseada, String idMedico, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fechaDeseada) && consulta.getMedico().getId().equals(idMedico)) {
                return false;
            }
        }

        return true;
    }
}
