import java.util.Scanner;

public class ContarDigitos {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1 = ingresarEntero("Ingresa un numero: ");
        int cantidad = contarDigitos(num1);
        String mensaje = generarTexto(cantidad);
        mostrarTexto(mensaje);

        scanner.close();
    }
    public static int ingresarEntero(String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    public static int contarDigitos(int num1){
        int contador = 0; 
        if (num1 == 0){
            return 1;
        }
        while (num1 != 0) {
            num1 = num1 /10;
            contador++;
        }
        return contador;
    }
    public static String generarTexto(int cantidad){
        return "El número tiene " + cantidad + " dígito(s).";
    }
    public static void mostrarTexto(String mensaje){
        System.out.println(mensaje);
    }

}
