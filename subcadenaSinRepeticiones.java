import java.util.Arrays;
import java.util.Scanner;
public class subcadenaSinRepeticiones {
    public static void main(String[] args) {
        leerCadena();
    }

    private static void leerCadena() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una cadena: ");
        String cadena = scanner.nextLine();
        int longitud = longitudSubcadena(cadena);
        mostrarResultado(cadena, longitud);
    }

    private static int longitudSubcadena(String s) {
        // arreglo para guardar la última posición de cada carácter
        int[] ultimaPos = new int[256]; 
        Arrays.fill(ultimaPos, -1);
        int izq = 0, maxLen = 0;
        for (int der = 0; der < s.length(); der++) {
            char c = s.charAt(der);
            // si el carácter ya apareció en la ventana, mover izq
            if (ultimaPos[c] >= izq) {
                izq = ultimaPos[c] + 1;
            }
            ultimaPos[c] = der; // actualizar última posición
            maxLen = Math.max(maxLen, der - izq + 1);
        }
        return maxLen;
    }

    private static void mostrarResultado(String cadena, int longitud) {
        System.out.println("La longitud de la subcadena sin repeticiones en \"" + cadena + "\" es: " + longitud);
    }
}
