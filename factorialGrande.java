import java.util.Scanner;
public class factorialGrande {

    public static void main(String[] args) {
        leerMatriz();
    }

    private static void leerMatriz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para calcular su factorial: ");
        int numero = scanner.nextInt();
        String resultado = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }

    private static int multiplicar(int[] numero, int n, int longitud) {
        int acarreo = 0;
        for (int i = 0; i < longitud; i++) {
            int producto = numero[i] * n + acarreo;
            numero[i] = producto % 10;
            acarreo = producto / 10;
        }
        while (acarreo != 0) {
            numero[longitud] = acarreo % 10;
            acarreo /= 10;
            longitud++;
        }
        return longitud;
    }

    // Calcula factorial usando el arreglo de dígitos
    private static String calcularFactorial(int n) {
        int[] numero = new int[5000]; // suficiente espacio para almacenar factoriales grandes
        numero[0] = 1;
        int longitud = 1;

        for (int i = 2; i <= n; i++) {
            longitud = multiplicar(numero, i, longitud);
        }

        // Convertir el arreglo a cadena (en orden inverso)
        StringBuilder resultado = new StringBuilder();
        for (int i = longitud - 1; i >= 0; i--) {
            resultado.append(numero[i]);
        }

        return resultado.toString();
    }

    private static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
