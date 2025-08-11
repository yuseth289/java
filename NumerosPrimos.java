import java.util.Scanner;

public class NumerosPrimos {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1 = ingresarEntero("Ingresa un numero: ");
        boolean primo = esPrimo(num1);
        String mensaje = generarTexto(primo);
        mostrarTexto(mensaje);

        scanner.close();
    }
    public static int ingresarEntero(String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    public static boolean esPrimo(int num1){
        if (num1 <= 1) {
            return false;
        }

        for (int i = 2; i < num1; i++) {
            if (num1 % i == 0) {
                return false; 
            }
        }
        return true;
    }
    public static String generarTexto(boolean primo){
        if (primo) {
            return "Es primo.";
        } else {
            return "No es primo.";
        }
    }
    public static void mostrarTexto(String mensaje){
        System.out.println(mensaje);
    }

}
