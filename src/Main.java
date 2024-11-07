import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean nombreValido = false, precioValido = false, cantidadValida = false;
        Producto producto = null;


        System.out.println("\n=== CREAR NUEVO PRODUCTO ===");

        // Validación del nombre
        while (!nombreValido) {
            try {
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();

                producto = new Producto(nombre, 1, 1);
                nombreValido = true;
            } catch (ProductoInvalidoException e) {
                System.out.println("Error en el nombre: " + e.getMessage());
                System.out.println("Intente nuevamente");
            } catch (PrecioInvalidoException | CantidadInvalidaException e) {
                // No deberían ocurrir con los valores por defecto
            }
        }

        // Validación del precio
        while (!precioValido) {
            try {
                System.out.print("Ingrese el precio del producto: ");
                double precio = scanner.nextDouble();

                producto = new Producto(producto.getNombre(), precio, producto.getCantidad());
                precioValido = true;
            } catch (PrecioInvalidoException e) {
                System.out.println("Error en el precio: " + e.getMessage());
                System.out.println("Intente nuevamente");
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido");
                scanner.nextLine(); // Limpiar el buffer
            } catch (ProductoInvalidoException | CantidadInvalidaException e) {
                // No deberían ocurrir ya que el nombre y cantidad ya fueron validados
            }
        }

        // Validación de la cantidad
        while (!cantidadValida) {
            try {
                System.out.print("Ingrese la cantidad del producto: ");
                int cantidad = scanner.nextInt();

                producto = new Producto(producto.getNombre(), producto.getPrecio(), cantidad);
                cantidadValida = true;

            } catch (CantidadInvalidaException e) {
                System.out.println("Error en la cantidad: " + e.getMessage());
                System.out.println("Intente nuevamente");
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero");
                scanner.nextLine(); // Limpiar el buffer
            } catch (ProductoInvalidoException | PrecioInvalidoException e) {
                // No deberían ocurrir ya que el nombre y precio ya fueron validados
            }
        }

        System.out.println("\nProducto creado exitosamente!");
        System.out.println(producto.MostrarDetalles());
    }
}