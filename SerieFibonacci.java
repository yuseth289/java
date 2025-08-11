import java.util.Scanner;

public class SerieFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("¿Cuántos términos desea mostrar? ");
        int N = scan.nextInt();

        int a = 0, b = 1;
        System.out.println("Serie Fibonacci:");
        for (int i = 0; i < N; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
        scan.close();
    }
}