import java.util.Arrays;

public class subcadenaSinRepeticiones {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(longitudSubcadena(s1)); // → 3
        System.out.println(longitudSubcadena(s2)); // → 1
        System.out.println(longitudSubcadena(s3)); // → 3
    }

    public static int longitudSubcadena(String s) {
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
}
