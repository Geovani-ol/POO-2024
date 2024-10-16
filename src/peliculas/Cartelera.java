package peliculas;

import java.util.ArrayList;

public class Cartelera {
    private String[][] matrizCartelera;
    private final int tamanoCelda = 20; // Tamaño fijo para cada celda

    // Constructor que toma el array de películas y el número de columnas deseadas
    public Cartelera(ArrayList<Pelicula> peliculas, int columnas) {
        int filas = (int) Math.ceil((double) peliculas.size() / columnas);
        this.matrizCartelera = new String[filas][columnas];
        llenarCartelera(peliculas);
    }

    // Método para llenar la matriz con los atributos de las películas
    private void llenarCartelera(ArrayList<Pelicula> peliculas) {
        int contador = 0;
        for (int i = 0; i < matrizCartelera.length; i++) {
            for (int j = 0; j < matrizCartelera[i].length; j++) {
                if (contador < peliculas.size()) {
                    Pelicula pelicula = peliculas.get(contador);
                    String contenidoCelda = ajustarTamano(pelicula.getTitulo(), tamanoCelda) + " " +
                            ajustarTamano(pelicula.getDuracion(), tamanoCelda) + " " +
                            ajustarTamano(pelicula.getGenero(), tamanoCelda) + " " +
                            ajustarTamano(pelicula.getClasificacion(), tamanoCelda);
                    matrizCartelera[i][j] = contenidoCelda;
                    contador++;
                } else {
                    matrizCartelera[i][j] = ajustarTamano("", tamanoCelda);
                }
            }
        }
    }

    // Método para ajustar el tamaño de cada celda
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

    // Método para mostrar la cartelera en formato cuadriculado
    public void mostrarCartelera() {
        for (int i = 0; i < matrizCartelera.length; i++) {
            for (int j = 0; j < matrizCartelera[i].length; j++) {
                System.out.print("| " + matrizCartelera[i][j] + " ");
            }
            System.out.println("|");
            System.out.println(new String(new char[matrizCartelera[i].length * (tamanoCelda * matrizCartelera[i].length)]).replace("\0", "-"));
        }
    }
}
