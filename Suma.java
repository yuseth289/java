import java.util.Scanner;

public class Suma {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1 = ingresarEntero("Ingresa un numero😊: ");
        int num2 = ingresarEntero("Ingrese un otro numero😊: ");
        int suma = calcularsuma(num1, num2);
        String mensaje = generarTexto(suma);
        mostrarTexto(mensaje);

        scanner.close();
    }
    public static int ingresarEntero(String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    public static int calcularsuma(int num1, int num2){
        return num1 + num2;
    }
    public static String generarTexto(int suma){
        return "La suma de los numero es: " + suma;
    }
     public static void mostrarTexto(String mensaje){
        System.out.println(mensaje);
    }
}
