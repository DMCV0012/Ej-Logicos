import java.util.Scanner;
public class numeroArmstrong {
    public static void main(String[] args) {
        leerNumero();
    }

    private static void leerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        boolean esArmstrong = esArmstrong(numero);
        mostrarResultado(esArmstrong);
    }

    private static boolean esArmstrong(int n) {
        int original = n;
        int digitos = contarDigitos(n);
        int suma = 0;

        while (n > 0) {
            int digito = n % 10;
            suma += Math.pow(digito, digitos);
            n /= 10;
        }

        return suma == original;
    }

    private static int contarDigitos(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    private static void mostrarResultado(boolean esArmstrong) {
        System.out.println(esArmstrong);
    }
}