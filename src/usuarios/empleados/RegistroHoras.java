package usuarios.empleados;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistroHoras {
    private ArrayList<String> horasEntrada;
    private ArrayList<String> horasSalida;

    public RegistroHoras() {
        this.horasEntrada = new ArrayList<>();
        this.horasSalida = new ArrayList<>();
    }

    public void registrarEntrada() {
        String horaEntrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        horasEntrada.add(horaEntrada);
        System.out.println("Entrada registrada: " + horaEntrada);
    }

    public void registrarSalida() {
        if (horasEntrada.size() == horasSalida.size()) {
            System.out.println("No se puede registrar salida sin una entrada previa.");
            return;
        }

        String horaSalida = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        horasSalida.add(horaSalida);
        System.out.println("Salida registrada: " + horaSalida);
    }

    public void mostrarRegistro() {
        System.out.println("Registro de horas:");
        for (int i = 0; i < Math.max(horasEntrada.size(), horasSalida.size()); i++) {
            String entrada = i < horasEntrada.size() ? horasEntrada.get(i) : "No registrado";
            String salida = i < horasSalida.size() ? horasSalida.get(i) : "No registrado";
            System.out.println("Entrada " + (i + 1) + ": " + entrada + " | Salida " + (i + 1) + ": " + salida);
        }
    }
}
