import java.util.Scanner;
public class numeroFeliz {
    public static void main(String[] args) {
        leerNumero();
    }

    private static void leerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        boolean esFeliz = esFeliz(numero);
        mostrarResultado(esFeliz);
    }

    private static boolean esFeliz(int n) {
        int lento = n;
        int rapido = sumaCuadrados(n);

        while (rapido != 1 && lento != rapido) {
            lento = sumaCuadrados(lento);
            rapido = sumaCuadrados(sumaCuadrados(rapido));
        }

        return rapido == 1;
    }

    private static int sumaCuadrados(int n) {
        int suma = 0;
        while (n > 0) {
            int digito = n % 10;
            suma += digito * digito;
            n /= 10;
        }
        return suma;
    }

    private static void mostrarResultado(boolean esFeliz) {
        System.out.println(esFeliz); // imprime true o false
    }
}
