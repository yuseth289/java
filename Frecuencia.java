import java.util.Scanner;

public class Frecuencia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pares = 0, impares = 0;

        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            int num = scan.nextInt();
            if (num % 2 == 0) pares++;
            else impares++;
        }

        System.out.println("Cantidad de pares: " + pares);
        System.out.println("Cantidad de impares: " + impares);
        scan.close();
    }
}