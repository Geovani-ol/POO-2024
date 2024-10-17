package cine;

import peliculas.Cartelera;
import peliculas.Pelicula;
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
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    Random random = new Random();

    public Cine() {
        Administrador administrador = new Administrador("A-2024OLVD1107", "David", "Olvera", LocalDate.of(1990, 7, 11), "4432659874", "Arriaga", "G123456", 50000.0, 10, "G123456");
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);

        listaPeliculas.add(new Pelicula("P-INC148P", "Inception", "Ciencia Ficción", "148 min", "PG-13", "Un ladrón que puede entrar en los sueños de las personas debe realizar el golpe final."));
        listaPeliculas.add(new Pelicula("P-THE175R", "The Godfather", "Crimen/Drama", "175 min", "R", "El patriarca de una familia mafiosa trata de preservar su imperio criminal."));
        listaPeliculas.add(new Pelicula("P-TIT195P", "Titanic", "Romance/Drama", "195 min", "PG-13", "Una joven aristócrata se enamora de un pobre artista en el viaje del Titanic."));
        listaPeliculas.add(new Pelicula("P-AVE181P", "Avengers: Endgame", "Acción/Fantasía", "181 min", "PG-13", "Los Vengadores restantes deben encontrar una forma de derrotar a Thanos."));
        listaPeliculas.add(new Pelicula("P-THE152P", "The Dark Knight", "Acción/Crimen", "152 min", "PG-13", "Batman enfrenta a su mayor enemigo, el Joker."));
        listaPeliculas.add(new Pelicula("P-PUL154R", "Pulp Fiction", "Crimen/Drama", "154 min", "R", "Historias entrelazadas de criminales en Los Ángeles."));
        listaPeliculas.add(new Pelicula("P-INT169P", "Interstellar", "Ciencia Ficción", "169 min", "PG-13", "Un grupo de exploradores viaja en busca de un nuevo hogar para la humanidad."));
        listaPeliculas.add(new Pelicula("P-FOR142P", "Forrest Gump", "Drama/Comedia", "142 min", "PG-13", "Un hombre con capacidades limitadas atraviesa eventos históricos de EE. UU."));
        listaPeliculas.add(new Pelicula("P-THE136R", "The Matrix", "Ciencia Ficción/Acción", "136 min", "R", "Un programador de computadoras descubre que su realidad es una simulación creada por máquinas."));
        listaPeliculas.add(new Pelicula("P-GLA155R", "Gladiator", "Acción/Drama", "155 min", "R", "Un general romano caído en desgracia busca venganza contra el emperador."));
    }

    // Generar ID de los Usuarios   U - { Año actua } - { 3 Letras del apellido } - { 1 Letra del nombre } - { Número random }

    public String generarIdAdministrador(String nombreAdmin, String apellidosAdmin) {
        int anio = LocalDate.now().getYear();
        String apellidoTresletras = apellidosAdmin.substring(0, 3).toUpperCase();
        String nombreUnaLetra = nombreAdmin.substring(0, 1).toUpperCase();
        int numeroRandom = random.nextInt(100000 - 50) + 50;
        String id;
        do {
            id = String.format("A-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
            if(obtenerIdsAdministradores(id) != null){
                numeroRandom = random.nextInt(100000 - 50) + 50;
            } else {
                return id;
            }
        } while (true);
    }

    public String generarIdCliente(String nombreCliente, String apellidosCliente) {
        int anio = LocalDate.now().getYear();
        String apellidoTresletras = apellidosCliente.substring(0, 3).toUpperCase();
        String nombreUnaLetra = nombreCliente.substring(0, 1).toUpperCase();
        int numeroRandom = random.nextInt(100000 - 50) + 50;
        String id;
        do {
            id = String.format("C-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
            if(obtenerIdsClientes(id) != null){
                numeroRandom = random.nextInt(100000 - 50) + 50;
            } else {
                return id;
            }
        } while (true);
    }

    // Generar Id de la Peliculas  P - {Primeras 3 letras del titulo}
    public String generarIdPelicula(String tituloPelicula, String duracionPelicula, String clasificacion) {
        String primerasTresLetras = tituloPelicula.length() >= 3 ? tituloPelicula.substring(0, 3).toUpperCase() : tituloPelicula.toUpperCase();
        String numerosDuracion = duracionPelicula.replaceAll("[^0-9]", "");
        String letraClasificacion = clasificacion.substring(0, 1).toUpperCase();

        return String.format("P-%s%s%s", primerasTresLetras, numerosDuracion, letraClasificacion);
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

    // Registrar Pelicula
    public void registrarPelicula(Pelicula pelicula){
        this.listaPeliculas.add(pelicula);
    }

    // Mpstrar Usuarios

    public void mostrarClientes() {
        System.out.println("\n-- Clientes de Cinépolis");
        for (Cliente cliente : this.listaClientes) {
            System.out.println(cliente.mostrarDatos());
        }
    }

    // Mostrar Cartelera
    public void mostrarCartelera(){
        System.out.println("\n--- Cartelera de Peliculas ---\n");

        int columnas = 3;
        Cartelera cartelera = new Cartelera(listaPeliculas, columnas);
        cartelera.mostrarCartelera();

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

//    metodo para obtener pelicula por id
    public Pelicula obtenerPeliculaPorId(String idPelicula) {
        return this.listaPeliculas.stream().filter(pelicula -> pelicula.getId().equals(idPelicula)).findFirst().orElse(null);
    }
    // metodo para generar ticket
    /**public void ticket(Cliente cliente, Pelicula pelicula) {
        LocalDate fecha = LocalDate.now();
//        leer sala
//        leer edad
        int edad = fecha.getYear() - cliente.getFechaNacimiento().getYear();
        String nombrePelicula = pelicula.getTitulo();

    }*/
    public Cliente obtenerIdsClientes(String idCliente) {
        return this.listaClientes.stream().filter(c -> c.getId().equals(idCliente)).findFirst().orElse(null);
    }
    public Administrador obtenerIdsAdministradores(String idAdministrador) {
        return this.listaAdministradores.stream().filter(a -> a.getId().equals(idAdministrador)).findFirst().orElse(null);
    }
}
