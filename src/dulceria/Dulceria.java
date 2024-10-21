package dulceria;

public class Dulceria {
    private String nombre;
    private double precio;
    private String tamaño;
    private String descripcion;

    public Dulceria(String nombre, double precio, String tamaño, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = tamaño;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String toString() {
        return nombre + " (" + tamaño + ") - $" + precio + " - " + descripcion;
    }
}
