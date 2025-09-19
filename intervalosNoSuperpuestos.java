import java.util.Arrays;
import java.util.Scanner;

public class intervalosNoSuperpuestos {

    public static void main(String[] args) {
        leerMatriz();
    }

    private static void leerMatriz() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Validar número de intervalos
        while (true) {
            System.out.print("Ingrese el numero de intervalos: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
                else System.out.println("El numero de intervalos debe ser mayor que 0.");
            } else {
                System.out.println("Debe ingresar un numero entero válido.");
                scanner.next(); // descartar entrada inválida
            }
        }

        int[][] intervalos = new int[n][2];
        scanner.nextLine(); // limpiar buffer

        // Validar ingreso de cada intervalo
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Intervalo " + (i + 1) + " (inicio y fin separados por espacio): ");
                String linea = scanner.nextLine();
                String[] partes = linea.trim().split("\\s+");
                if (partes.length != 2) {
                    System.out.println("Debe ingresar exactamente 2 números.");
                    continue;
                }
                boolean validos = true;
                for (int j = 0; j < 2; j++) {
                    if (!partes[j].matches("-?\\d+")) {
                        validos = false;
                        break;
                    }
                    intervalos[i][j] = Integer.parseInt(partes[j]);
                }
                if (validos) break;
                System.out.println("Error: solo se permiten numeros enteros. Intente nuevamente.");
            }
        }

        int resultado = borrarMinimo(intervalos);
        imprimir(new int[]{resultado});
    }

    private static int borrarMinimo(int[][] intervalos) {
        // Ordenar por el final del intervalo
        Arrays.sort(intervalos, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // al menos un intervalo se mantiene
        int fin = intervalos[0][1];

        for (int i = 1; i < intervalos.length; i++) {
            if (intervalos[i][0] >= fin) {
                count++;
                fin = intervalos[i][1];
            }
        }

        // Intervalos a eliminar
        return intervalos.length - count;
    }

    private static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
