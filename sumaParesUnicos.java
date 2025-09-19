import java.util.Arrays;
import java.util.Scanner;
public class sumaParesUnicos {
    public static void main(String[] args) {
        leerNumeros();
    }

    private static void leerNumeros() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese números enteros separados por espacios: ");
        String[] entradas = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(entradas).mapToInt(Integer::parseInt).toArray();
        System.out.print("Ingrese el número objetivo: ");
        int objetivo = scanner.nextInt();
        boolean existe = existeSuma(nums, objetivo);
        imprimirResultado(existe);
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
}