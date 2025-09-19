import java.util.Scanner;

public class numeroIslas {
    public static void main(String[] args) {
        leerEntrada();
    }

    private static void leerEntrada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int cols = scanner.nextInt();
        int[][] grid = new int[filas][cols];

        System.out.println("Ingrese la matriz 3x3 (0s y 1s) fila por fila, separados por espacios:");

        for (int i = 0; i < filas; i++) {
            while (true) {
                System.out.print("Fila " + (i + 1) + ": ");
                String linea = scanner.nextLine().trim();
                String[] partes = linea.split("\\s+");

                if (partes.length != cols) {
                    System.out.println("Debe ingresar exactamente " + cols + " números.");
                    continue;
                }

                boolean filaValida = true;
                for (int j = 0; j < cols; j++) {
                    if (!partes[j].matches("[01]")) {
                        filaValida = false;
                        break;
                    }
                    grid[i][j] = Integer.parseInt(partes[j]);
                }

                if (filaValida) break;
                System.out.println("Error: solo se permiten 0 o 1. Intente nuevamente.");
            }
        }

        int numeroIslas = contarIslas(grid);
        mostrarResultado(numeroIslas);
    }

    private static int contarIslas(int[][] grid) {
        int filas = grid.length;
        int cols = grid[0].length;
        int contador = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    contador++;
                    dfs(grid, i, j);
                }
            }
        }
        return contador;
    }

    private static void dfs(int[][] grid, int i, int j) {
        int filas = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 || i >= filas || j >= cols || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private static void mostrarResultado(int numeroIslas) {
        System.out.println("Numero de islas: " + numeroIslas);
    }
}
