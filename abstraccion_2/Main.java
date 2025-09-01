package abstraccion_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige un animal: 1 para Gato, 2 para Perro");
        int opcion = scanner.nextInt();

        Sonido animal;

        switch (opcion) {
            case 1:
                animal = new Gato();
                break;
            case 2:
                animal = new Perro();
                break;
            default:
                System.out.println("Opción no válida.");
                scanner.close();
                return;
        }

        System.out.println("El sonido del animal es: " + animal.reproducirSonido());

        if (animal instanceof Color) {
            Color animalColor = (Color) animal;
            System.out.println("El color del animal es: " + animalColor.getColor());
        }

        scanner.close();
    }
}
