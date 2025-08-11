import java.util.Scanner;

public class InvertirNumero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int num = scan.nextInt();
        int invertido = 0;

        while (num != 0) {
            invertido = invertido * 10 + num % 10;
            num /= 10;
        }

        System.out.println("Número invertido: " + invertido);
        scan.close();
    }
}