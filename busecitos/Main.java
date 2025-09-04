package busecitos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner vehicle = new Scanner(System.in);

        System.out.println("Selecciona el tipo de vehiculo que quiere registrar (carro,moto o bicicleta): ");
        String tipo = vehicle.nextLine().toLowerCase();

        System.out.print("Ingresa la marca: ");
        String marca = vehicle.nextLine();

        System.out.print("Ingresa el modelo: ");
        String modelo = vehicle.nextLine();

        System.out.print("Ingresa la velocidad maxima: ");
        int velocidadMaxima = vehicle.nextInt();

        Transporte vehiculo;

        switch (tipo) {
            case "carro":
                vehiculo = new Carro(marca, modelo, velocidadMaxima);
                break;
            case "moto":
                vehiculo = new Moto(marca, modelo, velocidadMaxima);
                break;
            case "bicicleta":
                vehiculo = new Bicicleta(marca, modelo, velocidadMaxima);
                break;
            default:
                System.out.println("Tipo de vehiculo no valido");
                vehicle.close();
                return;
        }

        vehiculo.arrancar();
        vehiculo.detener();
        vehiculo.tipoCombustible();
        vehiculo.mostrarInformacion();

        vehicle.close();
    }
}
    

