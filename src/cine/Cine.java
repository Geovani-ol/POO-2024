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
        this.listaUsuarios.add(administrador);
        this.listaAdministradores.add(administrador);
    }

    // Registro de Usuarios
    public void registrarAdministradores(Administrador administrador) {
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }

    // Generar ID de los Usuarios
    public String generarIdAdministrador(String nombreAdmiin, String apellidosAdmin) {
        int anio = LocalDate.now().getYear();
        String apellidoTresletras = apellidosAdmin.substring(0, 3);
        String nombreUnaLetra = nombreAdmiin.substring(0, 1);
        int numeroRandom = random.nextInt(100000 - 50) + 50;

        return String.format("A-%d%s%s%d", anio, apellidosAdmin, nombreAdmiin, numeroRandom);
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
