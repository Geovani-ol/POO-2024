package cine;

import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;
import usuarios.empleados.Empleado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Cine {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    public ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    Random random = new Random();

    public Cine() {
        Administrador administrador = new Administrador("A-2024OLVD1107", "David", "Olvera", LocalDate.of(1990, 7, 11), "4432659874", "Arriaga", "G123456", 50000.0, 10, "G123456");
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }

    // Generar ID de los Usuarios   U - { Año actua } - { 3 Letras del apellido } - { 1 Letra del nombre } - { Número random }

    public String generarIdAdministrador(String nombreAdmin, String apellidosAdmin) {
        int anio = LocalDate.now().getYear();
        String apellidoTresletras = apellidosAdmin.substring(0, 3).toUpperCase();
        String nombreUnaLetra = nombreAdmin.substring(0, 1).toUpperCase();
        int numeroRandom = random.nextInt(100000 - 50) + 50;

        return String.format("A-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
    }

    public String generarIdCliente(String nombreCliente, String apellidosCliente) {
        int anio = LocalDate.now().getYear();
        String apellidoTresletras = apellidosCliente.substring(0, 3).toUpperCase();
        String nombreUnaLetra = nombreCliente.substring(0, 1).toUpperCase();
        int numeroRandom = random.nextInt(100000 - 50) + 50;

        return String.format("C-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
    }

    // Registro de Usuarios

    public void registrarAdministrador(Administrador administrador) {
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }

    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        this.listaUsuarios.add(cliente);
    }

    // Mpstrar Usuarios

    public void mostrarClientes() {
        System.out.println("\n-- Clientes de Cinépolis");
        for (Cliente cliente : this.listaClientes) {
            System.out.println(cliente.mostrarDatos());
        }
    }

    // Validaciones Externas

    public Usuario validarInisioSesion(String idUsuario, String contrasenia) {
        for (Usuario usuario : this.listaUsuarios) {
                if (usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }

        return null;
    }
}
