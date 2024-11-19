
/**
 * @authores 
 * David_Calle
 */
package manipulación.de.vector.y.matrices.en.java;

import java.util.Scanner;
public class ManipulaciónDeVectorYMatricesEnJava {

    public static void main(String[] args) {
        
        // Se solicita el tamaño del vector y de la matriz por teclado
        
        try ( // Se importo la libreria java.util.scanner y Scanner
                Scanner scanner = new Scanner(System.in)) {
            // Se solicita el tamaño del vector y de la matriz por teclado
            System.out.print("Ingrese el tamano del vector (numero de elementos): ");
            int n = scanner.nextInt();
            System.out.print("Ingrese el tamano de la matriz (NxN): ");
            int size = n; // Matriz cuadrada de tamaño NxN
            
            // Se crear el vector y la matriz
            int[] vector = new int[n];
            int[][] matriz1 = new int[size][size];
            
            // Llenamos el vector
            System.out.println("Ingrese los elementos del vector:");
            for (int i = 0; i < n; i++) {
                System.out.print("Elemento " + (i + 1) + ": ");
                vector[i] = scanner.nextInt();
            }
            
            // Llenamos la matriz
            System.out.println("Ingrese los elementos de la matriz:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    matriz1[i][j] = scanner.nextInt();
                }
            }
            
            // Buscamos los valores del vector en la matriz
            int countFound = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (vector[i] == matriz1[j][k]) {
                            System.out.println("Numero " + vector[i] + " Encontrado: Posicion en el vector " + i + ", posicion en la matriz " + j + "," + k);
                            countFound++;
                        }
                    }
                }
            }
            
            // Mostramos si se encontraron números
            if (countFound == 0) {
                System.out.println("Los numeros ingresados en el vector no existen en la matriz.");
            } else {
                System.out.println("Se encontraron " + countFound + " numeros del vector en la matriz.");
            }
            
            // Se solicitamos un número escalar
            System.out.print("Ingrese un numero escalar: ");
            int escalar = scanner.nextInt();
            
            // Creamos la matriz 2 multiplicando la matriz 1 por el escalar
            int[][] matriz2 = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matriz2[i][j] = matriz1[i][j] * escalar;
                }
            }
            
            // Creamos la matriz 3 sumando matriz 1 y matriz 2
            int[][] matriz3 = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
            
            // Mostramos el vector y las matrices
            System.out.println("Vector:");
            for (int value : vector) {
                System.out.print(value + " ");
            }
            System.out.println("\nMatriz 1:");
            imprimirMatriz(matriz1);
            System.out.println("Matriz 2:");
            imprimirMatriz(matriz2);
            System.out.println("Matriz 3:");
            imprimirMatriz(matriz3);
            
            // Validamos
            boolean todosPositivos = true;
            for (int value : vector) {
                if (value <= 0) {
                    todosPositivos = false;
                    break;
                }
            }
            
            int sumaMatriz1 = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sumaMatriz1 += matriz1[i][j];
                }
            }
            
            System.out.print("Ingrese un numero para comparar con la suma de la matriz 1: ");
            int numeroComparar = scanner.nextInt();
            
            // Mostramos los resultados de las validaciones
            if (todosPositivos) {
                System.out.println("Todos los numeros del vector son positivos.");
            } else {
                System.out.println("No todos los numeros del vector son positivos.");
            }
            
            if (sumaMatriz1 > numeroComparar) {
                System.out.println("La suma de los elementos de la matriz 1 es mayor que " + numeroComparar + ".");
            } else {
                System.out.println("La suma de los elementos de la matriz 1 no es mayor que " + numeroComparar + ".");
            }
        }
    }

    // Creamos el método para imprimir una matriz
    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
   
