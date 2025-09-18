public class matrizEspiral {

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] resultado = obtenerEspiral(matriz);

        imprimir(resultado); 
        // → 1 2 3 6 9 8 7 4 5
    }

    // Método principal que devuelve un arreglo con los elementos en espiral
    public static int[] obtenerEspiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int n = matrix.length;
        int m = matrix[0].length;
        int total = n * m;

        int[] resultado = new int[total];
        int index = 0;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (left <= right && top <= bottom) {
            index = recorrerFilaDerecha(matrix, top, left, right, resultado, index);
            top++;

            index = recorrerColumnaAbajo(matrix, right, top, bottom, resultado, index);
            right--;

            if (top <= bottom) {
                index = recorrerFilaIzquierda(matrix, bottom, right, left, resultado, index);
                bottom--;
            }

            if (left <= right) {
                index = recorrerColumnaArriba(matrix, left, bottom, top, resultado, index);
                left++;
            }
        }

        return resultado;
    }

    // Métodos auxiliares que devuelven el nuevo índice
    private static int recorrerFilaDerecha(int[][] matrix, int fila, int ini, int fin, int[] res, int idx) {
        for (int c = ini; c <= fin; c++) res[idx++] = matrix[fila][c];
        return idx;
    }

    private static int recorrerColumnaAbajo(int[][] matrix, int col, int ini, int fin, int[] res, int idx) {
        for (int r = ini; r <= fin; r++) res[idx++] = matrix[r][col];
        return idx;
    }

    private static int recorrerFilaIzquierda(int[][] matrix, int fila, int ini, int fin, int[] res, int idx) {
        for (int c = ini; c >= fin; c--) res[idx++] = matrix[fila][c];
        return idx;
    }

    private static int recorrerColumnaArriba(int[][] matrix, int col, int ini, int fin, int[] res, int idx) {
        for (int r = ini; r >= fin; r--) res[idx++] = matrix[r][col];
        return idx;
    }

    // Método para imprimir el arreglo
    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
