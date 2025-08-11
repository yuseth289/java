import java.util.Scanner;

public class Promedio {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double nota1 = ingresarRealD("Ingrese la nota 1: ");
        double nota2 = ingresarRealD("Ingrese la nota 2: ");
        double nota3 = ingresarRealD("Ingrese la nota 3: ");
        double promedio = calcularpromedio(nota1, nota2, nota3);
        String mensaje = generarTexto(promedio);
        mostrartexto(mensaje);

        scanner.close();
    }
    public static double ingresarRealD(String mensaje){
        System.out.print(mensaje);
        double valorReal = scanner.nextDouble();
        return valorReal;
    }
    public static double calcularpromedio(double nota1, double nota2, double nota3){
        return (nota1 + nota2 + nota3) / 3;
    }
    public static String generarTexto(double definitiva){
        return "La nota definitiva es:" + definitiva;
    }
    public static void mostrartexto(String mensaje){
        System.out.println(mensaje);
    }
}

