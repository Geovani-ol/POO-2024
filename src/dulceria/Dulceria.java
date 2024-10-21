package dulceria;

public class Dulceria {
    private String nombre;
    private double precio;
    private String tamanio;
    private String descripcion;

    public Dulceria(String nombre, double precio, String tamanio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String toString() {
        return nombre + " (" + tamanio + ") - $" + precio + " - " + descripcion;
    }
}
