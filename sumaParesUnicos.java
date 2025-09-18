import java.util.Arrays;
import java.util.Scanner;
public class sumaParesUnicos {
    private static int[] leerNumeros(Scanner lector) {
        System.out.print("Ingrese el tamaño del vector: ");
        int n = lector.nextInt();
        int[] nums = new int[n];
        System.out.println("Ingrese los " + n + " números del vector:");
        for (int i = 0; i < n; i++) {
            nums[i] = lector.nextInt();
        }
        return nums;
    }

    private static boolean existeSuma(int[] nums, int objetivo) {
        Arrays.sort(nums);
        int izquierda = 0;
        int derecha = nums.length - 1;
        while (izquierda < derecha) {
            int suma = nums[izquierda] + nums[derecha];
            if (suma == objetivo) {
                return true;
            } else if (suma < objetivo) {
                izquierda++;
            } else {
                derecha--;
            }
        }
        return false;
    }

    private static void imprimirResultado(boolean existe) {
        System.out.println(existe);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int[] nums = leerNumeros(lector);
        System.out.print("Ingrese el número objetivo (target): ");
        int objetivo = lector.nextInt();
        boolean resultado = existeSuma(nums, objetivo);
        imprimirResultado(resultado);
    }
}