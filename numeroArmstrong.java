public class numeroArmstrong {

    public static void main(String[] args) {
        System.out.println(esArmstrong(153));   // true
        System.out.println(esArmstrong(9474));  // true
        System.out.println(esArmstrong(123));   // false
    }

    public static boolean esArmstrong(int n) {
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
}
