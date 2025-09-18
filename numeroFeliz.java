public class numeroFeliz {

    public static void main(String[] args) {
        System.out.println(esFeliz(19)); // → true
        System.out.println(esFeliz(2));  // → false
    }

    public static boolean esFeliz(int n) {
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
}
