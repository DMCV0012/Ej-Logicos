public class palindromoNumerico {

    public static void main(String[] args) {
        System.out.println(esPalindromo(121));   // true
        System.out.println(esPalindromo(123));   // false
        System.out.println(esPalindromo(1221));  // true
    }

    public static boolean esPalindromo(int n) {
        int original = n;
        int invertido = 0;

        while (n > 0) {
            int digito = n % 10;
            invertido = invertido * 10 + digito;
            n /= 10;
        }

        return original == invertido;
    }
}
