package cine;

import dulceria.Dulceria;
import dulceria.Ticket;
import menu.MenuAdmin;
import metodoPago.MetodoPago;
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
import java.util.*;

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
        public int cantidadFunciones;
        Random random = new Random();

        public Cine() {
            Administrador administrador = new Administrador("A-2024OLVD1107", "David", "Olvera", LocalDate.of(1990, 7, 11), "4432659874", "Arriaga", "G123456", 50000.0, 10, "G123456");
            this.listaAdministradores.add(administrador);
            this.listaUsuarios.add(administrador);

            listaPeliculas.add(new Pelicula("P-INC148P", "Inception", "Ciencia Ficción", "148", "PG-13", "Un ladrón que puede entrar en los sueños de las personas debe realizar el golpe final."));
            listaPeliculas.add(new Pelicula("P-THE175R", "The Godfather", "Crimen/Drama", "175", "R", "El patriarca de una familia mafiosa trata de preservar su imperio criminal."));
            listaPeliculas.add(new Pelicula("P-TIT195P", "Titanic", "Romance/Drama", "195", "PG-13", "Una joven aristócrata se enamora de un pobre artista en el viaje del Titanic."));
            listaPeliculas.add(new Pelicula("P-AVE181P", "Avengers: Endgame", "Acción/Fantasía", "181", "PG-13", "Los Vengadores restantes deben encontrar una forma de derrotar a Thanos."));
            listaPeliculas.add(new Pelicula("P-THE152P", "The Dark Knight", "Acción/Crimen", "152", "PG-13", "Batman enfrenta a su mayor enemigo, el Joker."));
            listaPeliculas.add(new Pelicula("P-PUL154R", "Pulp Fiction", "Crimen/Drama", "154", "R", "Historias entrelazadas de criminales en Los Ángeles."));
            listaPeliculas.add(new Pelicula("P-INT169P", "Interstellar", "Ciencia Ficción", "169", "PG-13", "Un grupo de exploradores viaja en busca de un nuevo hogar para la humanidad."));
            listaPeliculas.add(new Pelicula("P-FOR142P", "Forrest Gump", "Drama/Comedia", "142", "PG-13", "Un hombre con capacidades limitadas atraviesa eventos históricos de EE. UU."));
            listaPeliculas.add(new Pelicula("P-THE136R", "The Matrix", "Ciencia Ficción/Acción", "136", "R", "Un programador de computadoras descubre que su realidad es una simulación creada por máquinas."));
            listaPeliculas.add(new Pelicula("P-GLA155R", "Gladiator", "Acción/Drama", "155", "R", "Un general romano caído en desgracia busca venganza contra el emperador."));
            listaPeliculas.add(new Pelicula("P-STA121P", "Star Wars: A New Hope", "Ciencia Ficción", "121", "PG", "Luke Skywalker se une a la Alianza Rebelde para derrotar al Imperio."));
            listaPeliculas.add(new Pelicula("P-THE178P", "The Lord of the Rings: The Fellowship of the Ring", "Fantasía", "178", "PG-13", "Un joven hobbit emprende un peligroso viaje para destruir un anillo maldito."));
            listaPeliculas.add(new Pelicula("P-SHA142P", "Shawshank Redemption", "Drama", "142", "R", "Un hombre condenado injustamente a prisión trama su escape durante años."));
            listaPeliculas.add(new Pelicula("P-TOY081P", "Toy Story", "Animación/Aventura", "81", "G", "Un juguete cowboy compite por el afecto de su dueño con un nuevo juguete espacial."));
            listaPeliculas.add(new Pelicula("P-AVA162P", "Avatar", "Ciencia Ficción", "162", "PG-13", "Un marine discapacitado se infiltra en una raza alienígena para extraer un recurso valioso."));
            listaPeliculas.add(new Pelicula("P-JUR127P", "Jurassic Park", "Aventura/Ciencia Ficción", "127", "PG-13", "Un parque temático con dinosaurios clonados se convierte en una trampa mortal."));
            listaPeliculas.add(new Pelicula("P-LIO118P", "The Lion King", "Animación/Drama", "117", "G", "Un león joven debe reclamar su lugar como rey después de la muerte de su padre."));
            listaPeliculas.add(new Pelicula("P-FIG127P", "Fight Club", "Drama", "127", "R", "Un oficinista insomne se une a un carismático vendedor de jabón para formar un club de lucha subterráneo."));
            listaPeliculas.add(new Pelicula("P-SIX107P", "The Sixth Sense", "Suspenso/Terror", "107", "PG-13", "Un niño que puede ver fantasmas busca la ayuda de un psicólogo infantil."));
            listaPeliculas.add(new Pelicula("P-TER137R", "Terminator 2: Judgment Day", "Acción/Ciencia Ficción", "137", "R", "Un cyborg es enviado para proteger al futuro líder de la resistencia humana."));
            listaPeliculas.add(new Pelicula("P-ING153R", "Inglourious Basterds", "Acción/Drama", "153", "R", "Un grupo de soldados judíos americanos planea asesinar a líderes nazis durante la Segunda Guerra Mundial."));
            listaPeliculas.add(new Pelicula("P-SCH195R", "Schindler's List", "Drama/Bélico", "195", "R", "La historia de un empresario alemán que salvó a más de mil judíos del Holocausto."));
            listaPeliculas.add(new Pelicula("P-REA132R", "The Revenant", "Aventura/Drama", "132", "R", "Un hombre de la frontera es dejado por muerto y busca venganza contra quienes lo traicionaron."));
            listaPeliculas.add(new Pelicula("P-ALI117R", "Alien", "Terror/Ciencia Ficción", "117", "R", "La tripulación de una nave espacial se enfrenta a una criatura mortal a bordo."));
            listaPeliculas.add(new Pelicula("P-GRA091P", "Gravity", "Ciencia Ficción/Drama", "91", "PG-13", "Dos astronautas quedan varados en el espacio después de que su transbordador es destruido."));
            listaPeliculas.add(new Pelicula("P-MAR124P", "The Martian", "Ciencia Ficción", "124", "PG-13", "Un astronauta es abandonado en Marte y debe usar su ingenio para sobrevivir."));
            listaPeliculas.add(new Pelicula("P-GRE130P", "Green Book", "Biografía/Drama", "130", "PG-13", "Un pianista afroamericano y su chofer blanco forman una inesperada amistad en la América segregada."));


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
            listaPalomitas.add(new Dulceria("Palomitas Takis", 95, "Medianas", "116gr"));
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

            listaPalomitas.add(new Dulceria("Doritos Nacho", 90, "Chicos", "Acompañados de queso cheddar"));
            listaPalomitas.add(new Dulceria("Doritos Nacho", 105, "Grandes", "Acompañados de queso cheddar"));
            listaPalomitas.add(new Dulceria("Nachos clasicos", 75, "Chicos", "Acompañados de queso cheddar"));
            listaPalomitas.add(new Dulceria("Nachos clasicos", 90, "Grandes", "Acompañados de queso cheddar"));

            listaBebidas.add(new Dulceria("CocaCola", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("CocaCola", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("CocaCola", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("CocaCola", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("CocaCola Light", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("CocaCola Light", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("CocaCola Light", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("CocaCola Light", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("CocaCola Sin Azúcar", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("CocaCola Sin Azúcar", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("CocaCola Sin Azúcar", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("CocaCola Sin Azúcar", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("Sprite Sin Azúcar", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("Sprite Sin Azúcar", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("Sprite Sin Azúcar", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("Sprite Sin Azúcar", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("Sidral Mundet Sin Azúcar", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("Fuze Tea Sin Azúcar", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("Fanta Sin Azúcar", 76, "Chico", "."));
            listaBebidas.add(new Dulceria("Fanta Sin Azúcar", 81, "Mediano", "."));
            listaBebidas.add(new Dulceria("Fanta Sin Azúcar", 84, "Grande", "."));
            listaBebidas.add(new Dulceria("Fanta Sin Azúcar", 88, "Jumbo", "."));
            listaBebidas.add(new Dulceria("ICEE Cereza", 100, "Grande", "."));
            listaBebidas.add(new Dulceria("ICEE Mora Azul", 100, "Grande", "."));

            listaCombos.add(new Dulceria("Combo Cuates", 265, "Para llevar", "1 palomitas para llevar (285 gr) y 2 refrescos jumbo (1.2 ltr)."));
            listaCombos.add(new Dulceria("Combo Nachos", 251, "Para llevar", "1 palomitas para llevar (285 gr), 1 refresco jumbo (1.2 ltr), y 1 nachos clásicos chicos (120 gr)."));
            listaCombos.add(new Dulceria("Combo Ciel", 164, "Para llevar", "1 palomitas para llevar (285 gr) y 2 aguas Ciel® de 1 L."));
            listaCombos.add(new Dulceria("Combo Clasico", 246, "Para llevar", "1 palomitas para llevar (285 gr), 1 refresco jumbo (1.2 ltr) y 1 hot dog."));
            listaCombos.add(new Dulceria("Combo Micha", 335, "Para llevar", "1 palomitas para llevar (285 gr), 2 refrescos jumbo (1.2 ltr) y 1 helado micha."));

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
                if (obtenerIdsAdministradores(id) != null) {
                    numeroRandom = random.nextInt(100000 - 50) + 50;
                } else {
                    return id;
                }
            } while (true);
        }

        public String generarIdEmpleados(String nombreEmpleado, String apellidosEmpleado) {
            int anio = LocalDate.now().getYear();
            String apellidoTresletras = apellidosEmpleado.substring(0, 3).toUpperCase();
            String nombreUnaLetra = nombreEmpleado.substring(0, 1).toUpperCase();
            int numeroRandom = random.nextInt(100000 - 50) + 50;
            return String.format("E-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
        }

        public String generarIdCliente(String nombreCliente, String apellidosCliente) {
            int anio = LocalDate.now().getYear();
            String apellidoTresletras = apellidosCliente.substring(0, 3).toUpperCase();
            String nombreUnaLetra = nombreCliente.substring(0, 1).toUpperCase();
            int numeroRandom = random.nextInt(100000 - 50) + 50;
            String id;
            do {
                id = String.format("C-%d%s%s%d", anio, apellidoTresletras, nombreUnaLetra, numeroRandom);
                if (obtenerIdsClientes(id) != null) {
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

        public void registrarEmpleado(Empleado empleado) {
            this.listaEmpleados.add(empleado);
            this.listaUsuarios.add(empleado);
        }

        public void registrarPelicula(Pelicula pelicula) {
            this.listaPeliculas.add(pelicula);
        }

        public void registrarSala(Sala sala) {
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

        public void mostrarEmpleados() {
            System.out.println("\n-- Empleados de Cinépolis");
            for (Empleado empleado : this.listaEmpleados) {
                System.out.println(empleado.mostrarDatos());
            }
        }

        // Mostrar Cartelera Y Asientos de Sala
        public void mostrarCartelera() {
            System.out.println("\n--- Cartelera de Peliculas ---\n");

            int columnas = 3;
            Cartelera cartelera = new Cartelera(this, listaPeliculas, columnas);
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
                    String columnaStr = asiento.substring(1);

                    int columna = 0;
                    try {
                        columna = Integer.parseInt(columnaStr);
                    } catch (NumberFormatException e) {
                        System.out.println("El valor ingresado para la columna es inválido. Ingrese un número válido para la columna.");
                        return;
                    }

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

        public Cliente obtenerIdsClientes(String idCliente) {
            return this.listaClientes.stream().filter(c -> c.getId().equals(idCliente)).findFirst().orElse(null);
        }

        public Administrador obtenerIdsAdministradores(String idAdministrador) {
            return this.listaAdministradores.stream().filter(a -> a.getId().equals(idAdministrador)).findFirst().orElse(null);
        }

        public void funciones(int idFuncion) {
            int Hora = random.nextInt(8, 20);
            int Minutos = random.nextInt(0, 59);
            LocalTime horaActual = LocalTime.of(Hora, Minutos, 0);

            if (horaActual.isAfter(LocalTime.of(8, 0)) && horaActual.isBefore(LocalTime.of(23, 0))) {
                // generar funciones
                Pelicula pelicula = null;
                while (pelicula == null) {
                    pelicula = this.listaPeliculas.get(random.nextInt(0, listaPeliculas.size() - 1));
                    if (peliculasReproducidas.contains(pelicula)) {
                        pelicula = null;
                    }
                }
                Sala sala = null;
                do {
                    sala = listaSalas.get(random.nextInt(0, listaSalas.size() - 1));
                    LocalTime horaFin = LocalTime.of(Hora, Minutos, 0).plusMinutes(Integer.parseInt(pelicula.getDuracion()));
                    validador.validarDisponibilidadSala(horaActual, horaFin, sala.getNombre(), listaFunciones);
                } while (false);
                Funciones funcion = new Funciones(idFuncion, pelicula, sala, horaActual, horaActual.plusMinutes(Integer.parseInt(pelicula.getDuracion())));
                this.listaFunciones.add(funcion);
            } else {
                peliculasReproducidas.removeAll(peliculasReproducidas);
            }
        }

        // metodo mostrar datos de funciones
        public void mostrarFunciones() {
            System.out.println("\n--- Funciones de Disponibles ---\n");
            for (Funciones funcion : this.listaFunciones) {
                System.out.println(funcion.mostrarDatos());
            }
        }

        public Funciones obtenerFuncionPorId(int id) {
            return this.listaFunciones.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        }

        public String mostrarFuncionPorId(int id) {
            Funciones funcion = obtenerFuncionPorId(id);
            if (funcion != null) {
                return funcion.mostrarDatos();
            }
            return "Funcion no encontrada";
        }

        public void comprarBoleto(Cliente cliente) {
            Scanner scanner = new Scanner(System.in);
            MetodoPago metodoPago = new MetodoPago();
            this.listaFunciones.removeAll(this.listaFunciones);
            for (int i = 1; i <= 5; i++) {
                this.funciones(i);
            }
            this.mostrarFunciones();

            System.out.println("\nIntroduce el Codigo de la función que deseas:");
            int idFuncion = scanner.nextInt();
            Funciones funcionSeleccionada = obtenerFuncionPorId(idFuncion);

            if (funcionSeleccionada != null) {
                boolean descuento = cliente.mesCumpleanios();
                System.out.println("Has seleccionado: " + funcionSeleccionada.getPelicula().getTitulo());
                mostrarAsientosDeSala(funcionSeleccionada.getSala().getNombre());

                System.out.println("¿Cuántos asientos quieres reservar?");
                int numeroAsientos = 0;
                try {
                    numeroAsientos = scanner.nextInt();
                    if (numeroAsientos <= 0) {
                        System.out.println("El número de asientos debe ser mayor a cero.");
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un número válido.");
                    return;
                } finally {
                    scanner.nextLine();
                }

                System.out.println("\n- ¿Qué tipos de asientos quieres reservar? -\n");
                System.out.println("1.- REGULAR - $100");
                System.out.println("2.- PREMIUM - $200");
                System.out.println("3.- VIP - $400");
                System.out.println("Selecciona el Tipo de Asiento:");
                int opcion = scanner.nextInt();
                String tipoAsiento = "";
                Double precioAsiento = 0.0, precioAsientoT = 0.0;
                switch (opcion) {
                    case 1:
                        tipoAsiento = "REGULAR";
                        precioAsiento = 100.0;
                        if (descuento) {
                            precioAsientoT = precioAsiento * 0.75;
                            precioAsientoT = precioAsientoT * numeroAsientos;
                        } else {
                            precioAsientoT = precioAsiento * numeroAsientos;
                        }
                        break;
                    case 2:
                        tipoAsiento = "PREMIUM";
                        precioAsiento = 200.0;
                        if (descuento) {
                            precioAsientoT = precioAsiento * 0.6;
                            precioAsientoT = precioAsientoT * numeroAsientos;
                        } else {
                            precioAsientoT = precioAsiento * numeroAsientos;
                        }
                        break;
                    case 3:
                        tipoAsiento = "VIP";
                        precioAsiento = 400.0;
                        if (descuento) {
                            precioAsientoT = precioAsiento * 0.35;
                            precioAsientoT = precioAsientoT * numeroAsientos;
                        } else {
                            precioAsientoT = precioAsiento * numeroAsientos;
                        }
                        break;
                    default:
                        System.out.println("Opción no válida");
                        return;
                }

                scanner.nextLine();
                String[] asientos = new String[numeroAsientos];
                for (int i = 0; i < asientos.length; i++) {
                    System.out.println("Selecciona un asiento:");
                    asientos[i] = scanner.nextLine();
                }

                reservarAsientos(funcionSeleccionada.getSala().getNombre(), asientos);
                mostrarAsientosDeSala(funcionSeleccionada.getSala().getNombre());

                System.out.println("\n-- Boleto --\n");
                System.out.println("Película: " + funcionSeleccionada.getPelicula().getTitulo());
                System.out.println(funcionSeleccionada.getSala().getNombre());
                System.out.println("Precio por asiento: " + precioAsiento + " / Precio total: " + (precioAsiento * numeroAsientos));
                System.out.println("Asientos reservados: " + Arrays.toString(asientos));
                System.out.println("Tipo de asiento: " + tipoAsiento);
                System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());
                System.out.println("Hora: " + funcionSeleccionada.getHorarioInicio());
                System.out.println("Duración: " + funcionSeleccionada.getPelicula().getDuracion() + " minutos");
                System.out.println("Descuento aplicable: " + descuento);

                System.out.println("\n Desea comprar en Dulceria");
                System.out.println("1.- Si, Quiero comprar en Dulceria");
                System.out.println("2.- No, Estoy bien haci");
                System.out.print("Selecciona una opción: ");
                int op = scanner.nextInt();

                if (op == 1) {
                    this.dulceria(precioAsientoT);
                }

                metodoPago.procesarPago(cliente);
            } else {
                System.out.println("Función no encontrada.");
            }
        }

        public void dulceria(Double precioAsientoT) {
            Scanner scanner = new Scanner(System.in);
            Ticket ticket = new Ticket();
            while (true) {
                System.out.println("\n--    Dulceria    --\n");
                System.out.println("1.- Palomitas y nachos");
                System.out.println("2.- Bebidas");
                System.out.println("3.- Combos");
                System.out.println("4.- Regresar");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        do {
                            // Mostrar el menú de productos
                            System.out.println("\n-- Dulcería --");
                            System.out.println("Seleccione lo que desea comprar:");
                            for (int i = 0; i < this.listaPalomitas.size(); i++) {
                                System.out.println((i + 1) + ". " + this.listaPalomitas.get(i).getNombre() +
                                        " - Precio: " + this.listaPalomitas.get(i).getPrecio());
                            }
                            System.out.println("0. Finalizar compra");

                            opcion = scanner.nextInt();

                            if (opcion > 0 && opcion <= this.listaPalomitas.size()) {

                                Dulceria productoSeleccionado = this.listaPalomitas.get(opcion - 1);

                                ticket.agregarProducto(productoSeleccionado);
                                System.out.println(productoSeleccionado.getNombre() + " ha sido agregado al carrito.");
                            } else if (opcion != 0) {
                                System.out.println("Opción no válida. Intente de nuevo.");
                            }


                        } while (opcion != 0);
                        break;
                    case 2:
                        do {
                            System.out.println("\n-- Dulcería --");
                            System.out.println("Seleccione lo que desea comprar:");
                            for (int i = 0; i < this.listaBebidas.size(); i++) {
                                System.out.println((i + 1) + ". " + this.listaBebidas.get(i).getNombre() +
                                        " - Precio: " + this.listaBebidas.get(i).getPrecio());
                            }
                            System.out.println("0. Finalizar compra");

                            opcion = scanner.nextInt();

                            // Si la opción es válida (dentro del rango)
                            if (opcion > 0 && opcion <= this.listaBebidas.size()) {
                                // Restar 1 a la opción para acceder al índice correcto
                                Dulceria productoSeleccionado = this.listaBebidas.get(opcion - 1);

                                // Agregar el producto al carrito
                                ticket.agregarProducto(productoSeleccionado);
                                System.out.println(productoSeleccionado.getNombre() + " ha sido agregado al carrito.");
                            } else if (opcion != 0) {
                                System.out.println("Opción no válida. Intente de nuevo.");
                            }

                        } while (opcion != 0);
                        break;
                    case 3:
                        do {
                            // Mostrar el menú de productos
                            System.out.println("\n-- Dulcería --");
                            System.out.println("Seleccione lo que desea comprar:");
                            for (int i = 0; i < this.listaCombos.size(); i++) {
                                System.out.println((i + 1) + ". " + this.listaCombos.get(i).getNombre() +
                                        " - Precio: " + this.listaCombos.get(i).getPrecio());
                            }
                            System.out.println("0. Finalizar compra");

                            opcion = scanner.nextInt();

                            if (opcion > 0 && opcion <= this.listaCombos.size()) {
                                Dulceria productoSeleccionado = this.listaCombos.get(opcion - 1);

                                ticket.agregarProducto(productoSeleccionado);
                                System.out.println(productoSeleccionado.getNombre() + " ha sido agregado al carrito.");
                            } else if (opcion != 0) {
                                System.out.println("Opción no válida. Intente de nuevo.");
                            }

                        } while (opcion != 0);
                        break;
                    case 4:
                        ticket.mostrarTicket(precioAsientoT);
                        return;
                }

            }
        }

        public void generarFunciones() {
            this.listaFunciones.removeAll(this.listaFunciones);
            for (int i = 1; i <= getCantidadFunciones(); i++) {
                this.funciones(i);
            }
        }

        public Cliente obtenerClientePorId(String id) {
            return this.listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        }

        public void setcantidadFunciones(int cantidadFunciones) {
            this.cantidadFunciones = cantidadFunciones;
        }

        public int getCantidadFunciones() {
            return cantidadFunciones;
        }
    
}
