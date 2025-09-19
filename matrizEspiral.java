import java.util.Scanner;

public class matrizEspiral {
    public static void main(String[] args) {
        leerMatriz();
    }

    private static void leerMatriz() {
        Scanner scanner = new Scanner(System.in);
        int filas = 3;
        int columnas = 3;
        int[][] matrix = new int[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz 3x3 fila por fila, separados por espacios:");

        for (int i = 0; i < filas; i++) {
            while (true) {
                System.out.print("Fila " + (i + 1) + ": ");
                String linea = scanner.nextLine();
                String[] partes = linea.trim().split("\\s+");

                if (partes.length != columnas) {
                    System.out.println("Debe ingresar exactamente " + columnas + " números.");
                    continue;
                }

                boolean filaValida = true;
                for (int j = 0; j < columnas; j++) {
                    if (!partes[j].matches("-?\\d+")) {
                        filaValida = false;
                        break;
                    }
                    matrix[i][j] = Integer.parseInt(partes[j]);
                }

                if (filaValida) break;
                System.out.println("Error: solo se permiten números enteros. Intente nuevamente.");
            }
        }

        int[] espiral = obtenerEspiral(matrix);
        System.out.println("La matriz en orden espiral es:");
        imprimir(espiral);
    }

    private static int[] obtenerEspiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int total = n * m;
        int[] resultado = new int[total];
        int index = 0;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) resultado[index++] = matrix[top][c];
            top++;

            for (int r = top; r <= bottom; r++) resultado[index++] = matrix[r][right];
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) resultado[index++] = matrix[bottom][c];
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) resultado[index++] = matrix[r][left];
                left++;
            }
        }

        return resultado;
    }

    private static void imprimir(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
