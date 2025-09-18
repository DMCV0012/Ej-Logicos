import java.util.Scanner;
public class factorialGrande {

    // Multiplica el número representado por el arreglo de dígitos por un entero
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
    public static String calcularFactorial(int n) {
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

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese un número para calcular su factorial: ");
        int n = lector.nextInt();

        String factorial = calcularFactorial(n);
        System.out.println(n + "! = " + factorial);

        lector.close();
    }
}
