package dulceria;

import java.util.ArrayList;

public class Ticket {
    public ArrayList<Dulceria> productosEnCarrito = new ArrayList<>();
    private double total;


    // Agregar un producto al carrito
    public void agregarProducto(Dulceria producto) {
        this.productosEnCarrito.add(producto);
        this.total += producto.getPrecio();
    }

    // Mostrar los productos en el carrito y el total
    public void mostrarTicket(Double precioAsientoT) {
        if (productosEnCarrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("\n -- Ticket --\n");
            for (Dulceria producto : productosEnCarrito) {
                System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio());
            }
            System.out.println("\n------------------------------------\n");
            System.out.println("SubTotal: $" + total);
            System.out.println("Asientos: $" + precioAsientoT);
            System.out.println("\n------------------------------------\n");
            System.out.println("Total: $" + (total + precioAsientoT));
        }
    }

    // Obtener el total del carrito
    public double getTotal() {
        return total;
    }
}
