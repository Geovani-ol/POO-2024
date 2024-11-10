import java.util.ArrayList;

class HabitacionNoDisponibleException extends Exception {
    public HabitacionNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}

class NumeroDeNochesInvalidoException extends Exception {
    public NumeroDeNochesInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Habitacion {
    private String tipoHabitacion;
    private double precioPorNoche;
    private boolean disponibilidad;

    public Habitacion(String tipoHabitacion, double precioPorNoche, boolean disponibilidad) {
        this.tipoHabitacion = tipoHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.disponibilidad = disponibilidad;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void mostrarDetalles() {
        System.out.printf("""
                        Tipo de habitacion: %s
                        Precio por noche: %s\s
                        Disponibilidad: %s%n""",
                getTipoHabitacion(),
                getPrecioPorNoche(),
                (isDisponibilidad() ? "Disponible" : "No Disponible"));
    }

    public void reservar(int noches) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException {
        if (!isDisponibilidad()) {
            throw new HabitacionNoDisponibleException("La hobitacion " + getTipoHabitacion() + " no esta disponible");
        }
        if (noches <= 0) {
            throw new NumeroDeNochesInvalidoException("El número de noches debe ser mayor a 0");
        }
        setDisponibilidad(false);
    }
}
