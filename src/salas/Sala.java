package salas;

import peliculas.Funciones;

public class Sala {
    private String nombre;
    private char[][] asientos;
    private int filas;
    private int columnas;

    public Sala(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        asientos = new char[filas][columnas];
        inicializarAsientos();
    }

    public String getNombre() {
        return nombre;
    }

    public void inicializarAsientos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = 'O';
            }
        }
    }

    public void mostrarAsientos() {
        System.out.print("   ");
        for (int i = 0; i < columnas; i++) {
            System.out.print("  " + (i + 1) + " ");
        }
        System.out.println();

        System.out.print("   ");
        for (int i = 0; i < columnas; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < columnas; j++) {
                System.out.print("| " + asientos[i][j] + " ");
            }
            System.out.println("|");

            System.out.print("   ");
            for (int j = 0; j < columnas; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    public boolean reservarAsiento(char filaLetra, int columna) {
        int fila = filaLetra - 'A';

        if (fila < 0 || fila >= filas || columna <= 0 || columna > columnas) {
            System.out.println("Asiento no " + filaLetra + columna + " existente");
            return false;
        }

        if (asientos[fila][columna - 1] == 'O') {
            asientos[fila][columna - 1] = 'X';
            System.out.println("Asiento " + filaLetra + columna + " reservado exitosamente");
            return true;
        } else {
            System.out.println("El asiento " + filaLetra + columna +" ya está ocupado");
            return false;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
