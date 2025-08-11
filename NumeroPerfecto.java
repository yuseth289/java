import java.util.Scanner;

public class NumeroPerfecto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int num = scan.nextInt();
        int suma = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }

        System.out.println(num + (suma == num ? " es perfecto." : " no es perfecto."));
        scan.close();
    }
}