import java.util.Arrays;

public class intervalosNoSuperpuestos {

    public static void main(String[] args) {
        int[][] intervalos = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };

        int resultado = borrarMinimo(intervalos);
        System.out.println("Salida: " + resultado); // → 1
    }

    public static int borrarMinimo(int[][] intervalos) {
        // Ordenar por el final del intervalo
        Arrays.sort(intervalos, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // al menos un intervalo se mantiene
        int fin = intervalos[0][1];

        for (int i = 1; i < intervalos.length; i++) {
            if (intervalos[i][0] >= fin) { 
                // no se solapan → tomamos el intervalo
                count++;
                fin = intervalos[i][1];
            }
        }

        // Intervalos a eliminar
        return intervalos.length - count;
    }
}
