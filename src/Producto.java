class ProductoInvalidoException extends Exception {
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class CantidadInvalidaException extends Exception {
    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException {
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) throws ProductoInvalidoException {
        if (nombre == null) {
            throw new ProductoInvalidoException("El nombre no puede se nulo");
        }
        if (nombre.isEmpty()) {
            throw new ProductoInvalidoException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio no puede se menor o igual a cero");
        }
        this.precio = precio;
    }

    public void setCantidad(int cantidad) throws CantidadInvalidaException {
        if (cantidad < 0) {
            throw new CantidadInvalidaException("La cantidad no puede se negativa");
        }
        this.cantidad = cantidad;
    }

    public double CalcularValorTotal(double precio, int cantidad) {
        return precio * cantidad;
    }

    public String MostrarDetalles() {
        return String.format("""
                Producto: %s\s
                Precio: %s\s
                Cantidad: %d\s
                Valor Total: %s""",
                getNombre(),
                getPrecio(),
                getCantidad(),
                CalcularValorTotal(getPrecio(), getCantidad()));
    }


}
