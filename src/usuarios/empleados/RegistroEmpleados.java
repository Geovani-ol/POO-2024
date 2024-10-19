package usuarios.empleados;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroEmpleados {
    public LocalDateTime entrada;
    public LocalDateTime salida;

    public RegistroEmpleados(LocalDateTime entrada, LocalDateTime salida) {
        this.entrada = entrada;
        this.salida = salida;
    }


    public LocalDateTime getEntrada() {
        return entrada;
    }
    public LocalDateTime getSalida() {
        return salida;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Entrada: " + (entrada != null ? entrada.format(formatter) : "N/A") +
                ", Salida: " + (salida != null ? salida.format(formatter) : "N/A");
    }
}