package dulceria;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public List<Dulceria> productosEnCarrito;
    private double total;

    public Ticket() {
        productosEnCarrito = new ArrayList<>();
        total = 0;
    }

    // Agregar un producto al carrito
    public void agregarProducto(Dulceria producto) {
        productosEnCarrito.add(producto);
        total += producto.getPrecio();
    }

    // Mostrar los productos en el carrito y el total
    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        for (Dulceria producto : productosEnCarrito) {
            System.out.println(producto);
        }
        System.out.println("Total: $" + total);
    }

    // Obtener el total del carrito
    public double getTotal() {
        return total;
    }
}
