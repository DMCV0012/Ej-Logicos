public class numeroIslas {

    public static void main(String[] args) {
        int[][] grid1 = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };

        int[][] grid2 = {
            {1,0,1},
            {0,1,0},
            {1,0,1}
        };

        System.out.println(contarIslas(grid1)); // → 3
        System.out.println(contarIslas(grid2)); // → 5
    }

    public static int contarIslas(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

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

        // condición de parada
        if (i < 0 || j < 0 || i >= filas || j >= cols || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0; // marcar como visitado

        // explorar las 4 direcciones
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
