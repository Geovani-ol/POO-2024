package cine;

import dulceria.Dulceria;
import peliculas.Cartelera;
import peliculas.Funciones;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;
import usuarios.empleados.Empleado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;


public class Cine {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    public ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public ArrayList<Sala> listaSalas = new ArrayList<>();
    public ArrayList<Funciones> listaFunciones = new ArrayList<>();
    public ArrayList<Dulceria> listaCombos = new ArrayList<>();
    public ArrayList<Dulceria> listaBebidas = new ArrayList<>();
    public ArrayList<Dulceria> listaPalomitas = new ArrayList<>();

    ArrayList<Pelicula> peliculasReproducidas = new ArrayList<>();
    ValidadorCine validador = new ValidadorCine();
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
        listaPeliculas.add(new Pelicula("P-STA121P", "Star Wars: A New Hope", "Ciencia Ficción", "121 min", "PG", "Luke Skywalker se une a la Alianza Rebelde para derrotar al Imperio."));
        listaPeliculas.add(new Pelicula("P-THE178P", "The Lord of the Rings: The Fellowship of the Ring", "Fantasía", "178 min", "PG-13", "Un joven hobbit emprende un peligroso viaje para destruir un anillo maldito."));
        listaPeliculas.add(new Pelicula("P-SHA142P", "Shawshank Redemption", "Drama", "142 min", "R", "Un hombre condenado injustamente a prisión trama su escape durante años."));
        listaPeliculas.add(new Pelicula("P-TOY081P", "Toy Story", "Animación/Aventura", "81 min", "G", "Un juguete cowboy compite por el afecto de su dueño con un nuevo juguete espacial."));
        listaPeliculas.add(new Pelicula("P-AVA162P", "Avatar", "Ciencia Ficción", "162 min", "PG-13", "Un marine discapacitado se infiltra en una raza alienígena para extraer un recurso valioso."));
        listaPeliculas.add(new Pelicula("P-JUR127P", "Jurassic Park", "Aventura/Ciencia Ficción", "127 min", "PG-13", "Un parque temático con dinosaurios clonados se convierte en una trampa mortal."));
        listaPeliculas.add(new Pelicula("P-LIO118P", "The Lion King", "Animación/Drama", "118 min", "G", "Un león joven debe reclamar su lugar como rey después de la muerte de su padre."));
        listaPeliculas.add(new Pelicula("P-FIG127P", "Fight Club", "Drama", "127 min", "R", "Un oficinista insomne se une a un carismático vendedor de jabón para formar un club de lucha subterráneo."));
        listaPeliculas.add(new Pelicula("P-SIX107P", "The Sixth Sense", "Suspenso/Terror", "107 min", "PG-13", "Un niño que puede ver fantasmas busca la ayuda de un psicólogo infantil."));
        listaPeliculas.add(new Pelicula("P-TER137R", "Terminator 2: Judgment Day", "Acción/Ciencia Ficción", "137 min", "R", "Un cyborg es enviado para proteger al futuro líder de la resistencia humana."));
        listaPeliculas.add(new Pelicula("P-ING153R", "Inglourious Basterds", "Acción/Drama", "153 min", "R", "Un grupo de soldados judíos americanos planea asesinar a líderes nazis durante la Segunda Guerra Mundial."));
        listaPeliculas.add(new Pelicula("P-SCH195R", "Schindler's List", "Drama/Bélico", "195 min", "R", "La historia de un empresario alemán que salvó a más de mil judíos del Holocausto."));
        listaPeliculas.add(new Pelicula("P-REA132R", "The Revenant", "Aventura/Drama", "132 min", "R", "Un hombre de la frontera es dejado por muerto y busca venganza contra quienes lo traicionaron."));
        listaPeliculas.add(new Pelicula("P-ALI117R", "Alien", "Terror/Ciencia Ficción", "117 min", "R", "La tripulación de una nave espacial se enfrenta a una criatura mortal a bordo."));
        listaPeliculas.add(new Pelicula("P-GRA091P", "Gravity", "Ciencia Ficción/Drama", "91 min", "PG-13", "Dos astronautas quedan varados en el espacio después de que su transbordador es destruido."));
        listaPeliculas.add(new Pelicula("P-MAR124P", "The Martian", "Ciencia Ficción", "124 min", "PG-13", "Un astronauta es abandonado en Marte y debe usar su ingenio para sobrevivir."));
        listaPeliculas.add(new Pelicula("P-GRE130P", "Green Book", "Biografía/Drama", "130 min", "PG-13", "Un pianista afroamericano y su chofer blanco forman una inesperada amistad en la América segregada."));


        listaSalas.add(new Sala("Sala 1", 5, 6));
        listaSalas.add(new Sala("Sala 2", 6, 7));
        listaSalas.add(new Sala("Sala 3", 7, 8));
        listaSalas.add(new Sala("Sala 4", 8, 9));
        listaSalas.add(new Sala("Sala 5", 9, 9));

        //listaEmpleados.add(new Empleado("G1ALV4R4DO","Juan Pablo", "Alvarado Rosales", LocalDate.of(2005,8,24),"4361228361", "Villas del Pedregal #111", "vivaSteelers24", "9J19D1JX0JI1D", registros));

        listaPalomitas.add(new Dulceria("Palomitas Mantequilla", 75, "Chicas", "65gr"));
        listaPalomitas.add(new Dulceria("Palomitas Caramelo", 85, "Chicas", "65gr"));
        listaPalomitas.add(new Dulceria("Palomitas Takis", 85, "Chicas", "65gr"));
        listaPalomitas.add(new Dulceria("Palomitas Cheetos Mix", 90, "Chicas", "65gr"));
        listaPalomitas.add(new Dulceria("Palomitas Doritos Nacho", 85, "Chicas", "65gr"));
        listaPalomitas.add(new Dulceria("Palomitas Mantequilla", 80, "Medianas", "116gr"));
        listaPalomitas.add(new Dulceria("Palomitas Caramelo", 95, "Medianas", "116gr"));
        listaPalomitas.add(new Dulceria("Palomitas Takis", 95,"Medianas", "116gr"));
        listaPalomitas.add(new Dulceria("Palomitas Cheetos Mix", 100, "Medianas", "116gr"));
        listaPalomitas.add(new Dulceria("Palomitas Doritos Nacho", 95, "Medianas", "116gr"));
        listaPalomitas.add(new Dulceria("Palomitas Mantequilla", 85, "Grandes", "155gr"));
        listaPalomitas.add(new Dulceria("Palomitas Caramelo", 100, "Grandes", "155gr"));
        listaPalomitas.add(new Dulceria("Palomitas Takis", 100, "Grandes", "155gr"));
        listaPalomitas.add(new Dulceria("Palomitas Cheetos Mix", 105, "Grandes", "155gr"));
        listaPalomitas.add(new Dulceria("Palomitas Doritos Nacho", 100, "Grandes", "155gr"));
        listaPalomitas.add(new Dulceria("Palomitas Mantequilla", 90, "Jumbo", "203gr"));
        listaPalomitas.add(new Dulceria("Palomitas Caramelo", 110, "Jumbo", "203gr"));
        listaPalomitas.add(new Dulceria("Palomitas Takis", 110, "Jumbo", "203gr"));
        listaPalomitas.add(new Dulceria("Palomitas Cheetos Mix", 115, "Jumbo", "203gr"));
        listaPalomitas.add(new Dulceria("Palomitas Doritos Nacho", 110, "Jumbo", "203gr"));
        listaPalomitas.add(new Dulceria("Palomitas Mantequilla", 100, "Para llevar", "285gr"));
        listaPalomitas.add(new Dulceria("Palomitas Caramelo", 120, "Para llevar", "285gr"));
        listaPalomitas.add(new Dulceria("Palomitas Takis", 120, "Para llevar", "285gr"));
        listaPalomitas.add(new Dulceria("Palomitas Cheetos Mix", 125, "Para llevar", "285gr"));
        listaPalomitas.add(new Dulceria("Palomitas Doritos Nacho", 120, "Para llevar", "285gr"));

        listaPalomitas.add(new Dulceria("Doritos Nacho",90,"Chicos","Acompañados de queso cheddar"));
        listaPalomitas.add(new Dulceria("Doritos Nacho",105,"Grandes","Acompañados de queso cheddar"));
        listaPalomitas.add(new Dulceria("Nachos clasicos",75,"Chicos","Acompañados de queso cheddar"));
        listaPalomitas.add(new Dulceria("Nachos clasicos",90,"Grandes","Acompañados de queso cheddar"));

        listaBebidas.add(new Dulceria("CocaCola",76,"Chico","."));
        listaBebidas.add(new Dulceria("CocaCola",81,"Mediano","."));
        listaBebidas.add(new Dulceria("CocaCola",84,"Grande","."));
        listaBebidas.add(new Dulceria("CocaCola",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("CocaCola Light",76,"Chico","."));
        listaBebidas.add(new Dulceria("CocaCola Light",81,"Mediano","."));
        listaBebidas.add(new Dulceria("CocaCola Light",84,"Grande","."));
        listaBebidas.add(new Dulceria("CocaCola Light",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("CocaCola Sin Azúcar",76,"Chico","."));
        listaBebidas.add(new Dulceria("CocaCola Sin Azúcar",81,"Mediano","."));
        listaBebidas.add(new Dulceria("CocaCola Sin Azúcar",84,"Grande","."));
        listaBebidas.add(new Dulceria("CocaCola Sin Azúcar",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("Sprite Sin Azúcar",76,"Chico","."));
        listaBebidas.add(new Dulceria("Sprite Sin Azúcar",81,"Mediano","."));
        listaBebidas.add(new Dulceria("Sprite Sin Azúcar",84,"Grande","."));
        listaBebidas.add(new Dulceria("Sprite Sin Azúcar",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar",76,"Chico","."));
        listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar",81,"Mediano","."));
        listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar",84,"Grande","."));
        listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar",76,"Chico","."));
        listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar",81,"Mediano","."));
        listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar",84,"Grande","."));
        listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("Fanta Sin Azúcar",76,"Chico","."));
        listaBebidas.add(new Dulceria("Fanta Sin Azúcar",81,"Mediano","."));
        listaBebidas.add(new Dulceria("Fanta Sin Azúcar",84,"Grande","."));
        listaBebidas.add(new Dulceria("Fanta Sin Azúcar",88,"Jumbo","."));
        listaBebidas.add(new Dulceria("ICEE Cereza",100,"Grande","."));
        listaBebidas.add(new Dulceria("ICEE Mora Azul",100,"Grande","."));

        listaCombos.add(new Dulceria("Combo Cuates",265,"Para llevar","1 palomitas para llevar (285 gr) y 2 refrescos jumbo (1.2 ltr)."));
        listaCombos.add(new Dulceria("Combo Nachos",251,"Para llevar","1 palomitas para llevar (285 gr), 1 refresco jumbo (1.2 ltr), y 1 nachos clásicos chicos (120 gr)."));
        listaCombos.add(new Dulceria("Combo Ciel",164,"Para llevar","1 palomitas para llevar (285 gr) y 2 aguas Ciel® de 1 L."));
        listaCombos.add(new Dulceria("Combo Clasico",246,"Para llevar","1 palomitas para llevar (285 gr), 1 refresco jumbo (1.2 ltr) y 1 hot dog."));
        listaCombos.add(new Dulceria("Combo Micha",335,"Para llevar","1 palomitas para llevar (285 gr), 2 refrescos jumbo (1.2 ltr) y 1 helado micha."));

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

    // Generar Id de la Peliculas  P - {Primeras 3 letras del titulo}{Min de duracion}{Primera letra de la clasificacion}

    public String generarIdPelicula(String tituloPelicula, String duracionPelicula, String clasificacion) {
        String primerasTresLetras = tituloPelicula.length() >= 3 ? tituloPelicula.substring(0, 3).toUpperCase() : tituloPelicula.toUpperCase();
        String numerosDuracion = duracionPelicula.replaceAll("[^0-9]", "");
        String letraClasificacion = clasificacion.substring(0, 1).toUpperCase();

        return String.format("P-%s%s%s", primerasTresLetras, numerosDuracion, letraClasificacion);
    }

    // Registros

    public void registrarAdministrador(Administrador administrador) {
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }

    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        this.listaUsuarios.add(cliente);
    }

    public void registrarPelicula(Pelicula pelicula){
        this.listaPeliculas.add(pelicula);
    }

    public void registrarSala(Sala sala){
        this.listaSalas.add(sala);
    }

    // Busqueda

    public Sala buscarSalaPorNombre(String nombre) {
        for (Sala sala : this.listaSalas) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                return sala;
            }
        }
        return null;
    }

    // Mpstrar Usuarios

    public void mostrarClientes() {
        System.out.println("\n-- Clientes de Cinépolis");
        for (Cliente cliente : this.listaClientes) {
            System.out.println(cliente.mostrarDatos());
        }
    }

    // Mostrar Cartelera Y Asientos de Sala
    public void mostrarCartelera(){
        System.out.println("\n--- Cartelera de Peliculas ---\n");

        int columnas = 3;
        Cartelera cartelera = new Cartelera(listaPeliculas, columnas);
        cartelera.mostrarCartelera();
    }

    public void mostrarAsientosDeSala(String nombreSala) {
        System.out.println("\n--- Asientos de Sala ---\n");

        Sala sala = buscarSalaPorNombre(nombreSala);
        if (sala != null) {
            sala.mostrarAsientos();
        } else {
            System.out.println("No se ha encontrado la sala");
        }
    }

    // Reserva de Asientos

    public void reservarAsientos(String nombreSala, String[] asientos) {
        Sala sala = buscarSalaPorNombre(nombreSala);
        if (sala != null) {
            for (String asiento : asientos) {
                char fila = asiento.charAt(0);
                int columna = Integer.parseInt(asiento.substring(1));

                sala.reservarAsiento(fila, columna);
            }
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



    public void funciones() {
        LocalTime horaActual = LocalTime.now();
        String idPelicula;

        if (horaActual.isAfter(LocalTime.of(8,0)) && horaActual.isBefore(LocalTime.of(23,0))) {
            // generar funciones
            Pelicula pelicula = null;
            while(pelicula == null){
                pelicula = this.listaPeliculas.get(random.nextInt(0,listaPeliculas.size()-1));
                if (peliculasReproducidas.contains(pelicula)) {
                    pelicula = null;
                }
            }
            LocalTime startTime = LocalTime.of(8, 0);
            LocalTime endTime = LocalTime.of(23, 0);
            int durationBetweenShows = 30; // 30 minutes between shows

            for (Pelicula pelicula1 : listaPeliculas) {
                Sala sala1 = listaSalas.get(random.nextInt(listaSalas.size()));
                Sala sala2;
                do {
                    sala2 = listaSalas.get(random.nextInt(listaSalas.size()));
                } while (sala1.equals(sala2));

                LocalTime showTime1 = startTime;
                LocalTime showTime2 = startTime.plusMinutes(durationBetweenShows);

                while (showTime1.isBefore(endTime) && showTime2.isBefore(endTime)) {
                    Funciones funcion1 = new Funciones(pelicula1, sala1, showTime1);
                    Funciones funcion2 = new Funciones(pelicula1, sala2, showTime2);

                    listaFunciones.add(funcion1);
                    listaFunciones.add(funcion2);

                    showTime1 = showTime1.plusMinutes( Integer.parseInt(pelicula1.getDuracion()) + durationBetweenShows);
                    showTime2 = showTime2.plusMinutes(Integer.parseInt(pelicula1.getDuracion()) + durationBetweenShows);
                }
            }



        } else {
            peliculasReproducidas.removeAll(peliculasReproducidas);
        }
    }

}
