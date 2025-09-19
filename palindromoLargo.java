import java.util.Scanner;
public class palindromoLargo{
    public static void main(String args[]){
        leerTexto();
    }
    
    private static void leerTexto(){
        Scanner leerTexto = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto: ");
        String s = leerTexto.nextLine();
        String resultado = subCadenaPalindroma(s);
        imprimirResultado(resultado);
    }
    
    private static String subCadenaPalindroma(String s){
        if (s==null || s.length() == 0) return " ";
        String longitud = "";
        for (int i = 0; i < s.length(); i++) {
            // Palíndromo impar
            String temporal = expandirDesdeCentro(s, i, i);
            if (temporal.length() > longitud.length()) longitud = temporal;
            // Palíndromo par
            temporal = expandirDesdeCentro(s, i, i + 1);
            if (temporal.length() > longitud.length()) longitud = temporal;
        }
        return longitud;
    }
    
    private static String expandirDesdeCentro(String s, int izquierda, int derecha){
        while(izquierda >= 0 && derecha < s.length() && s.charAt(izquierda) == s.charAt(derecha)){
            izquierda--;
            derecha++;
        }
        return s.substring(izquierda+1, derecha);
    }
    
    private static void imprimirResultado(String resultado){
        System.out.println(resultado);
    }
}