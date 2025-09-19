import java.util.Scanner;
public class palindromoNumerico {
    public static void main(String[] args) {
        leerNumero();
    }

    private static void leerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        boolean esPalindromo = esPalindromo(numero);
        mostrarResultado(esPalindromo);
    }

    private static boolean esPalindromo(int n) {
        int original = n;
        int invertido = 0;
        while (n > 0) {
            int digito = n % 10;
            invertido = invertido * 10 + digito;
            n /= 10;
        }
        return original == invertido;
    }

    private static void mostrarResultado(boolean esPalindromo) {
        System.out.println(esPalindromo);
    }
}
