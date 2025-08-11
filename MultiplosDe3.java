import java.util.Scanner;

public class MultiplosDe3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el valor de N: ");
        int N = scan.nextInt();

        System.out.println("Múltiplos de 3 entre 1 y " + N + ":");
        for (int i = 3; i <= N; i += 3) {
            System.out.print(i + " ");
        }
        System.out.println();
        scan.close();
    }
}