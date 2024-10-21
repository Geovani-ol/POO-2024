package peliculas;

import cine.Cine;

import java.util.ArrayList;

public class Cartelera {
    private String[][] matrizCartelera;
    private Pelicula[][] referenciaPeliculas;
    private final int tamanoCelda = 25, tamano = 10; // Tamaño fijo para cada celda
    Cine cine;

    // Constructor que toma el array de películas y el número de columnas deseadas
    public Cartelera(Cine cine, ArrayList<Pelicula> peliculas, int columnas) {
        this.cine = cine;
        int filas = (int) Math.ceil((double) peliculas.size() / columnas);
        this.matrizCartelera = new String[filas][columnas];
        this.referenciaPeliculas = new Pelicula[filas][columnas];
        llenarCartelera(peliculas);
    }

    private void llenarCartelera(ArrayList<Pelicula> peliculas) {
        int contador = 0;
        for (int i = 0; i < matrizCartelera.length; i++) {
            for (int j = 0; j < matrizCartelera[i].length; j++) {
                if (contador < peliculas.size()) {
                    Pelicula pelicula = peliculas.get(contador);
                    int k = i + 1, l = j + 1;
                    String celda = "P" + k + l;
                    String contenidoCelda = celda + " - " + ajustarTamano(pelicula.getTitulo(), tamanoCelda) + " " +
                            ajustarTamano(pelicula.getClasificacion(), tamano) + " " +
                            ajustarTamano(pelicula.getDuracion(), tamano);
                    matrizCartelera[i][j] = contenidoCelda;
                    referenciaPeliculas[i][j] = pelicula; // Guardamos la referencia de la película
                    contador++;
                } else {
                    matrizCartelera[i][j] = ajustarTamano("", tamanoCelda);
                }
            }
        }
    }

    private String ajustarTamano(String texto, int tamano) {
        if (texto.length() > tamano) {
            return texto.substring(0, tamano);
        }
        StringBuilder sb = new StringBuilder(texto);
        while (sb.length() < tamano) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public void mostrarCartelera() {
        System.out.println("Codigo - " + ajustarTamano("Pelicula", tamanoCelda - 2) + " " + ajustarTamano("Categoría", tamano) + " " + ajustarTamano("Duración", tamano + 2));
        System.out.println(new String(new char[(int) (matrizCartelera.length * (tamanoCelda / 1.33))]).replace("\0", "-"));
        for (String[] strings : matrizCartelera) {
            for (String string : strings) {
                System.out.print("| " + string + " ");
            }
            System.out.println("|");
            System.out.println(new String(new char[(int) (strings.length * (tamanoCelda * 2.26))]).replace("\0", "-"));
        }
    }
}
