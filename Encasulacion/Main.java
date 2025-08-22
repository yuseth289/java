package Encasulacion;

class Vehiculo {
   // Atributos privados (encapsulamiento)
    private String marca;
    private String modelo;
    private int velocidad;

    // Constructor
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    // Getters y Setters (acceso controlado)
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    protected void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo + " | Velocidad: " + velocidad + " km/h");
    }

    // Método acelerar (será sobrescrito por las subclases)
    public void acelerar() {
        velocidad += 5;
        System.out.println(marca + " " + modelo + " acelera a " + velocidad + " km/h");
    }
}

// Subclase Coche
class Coche extends Vehiculo {
    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        setVelocidad(getVelocidad() + 20); // los coches aceleran más rápido
        System.out.println(getMarca() + " " + getModelo() + " acelera (coche) a " + getVelocidad() + " km/h 🚗");
    }
}

// Subclase Moto
class Moto extends Vehiculo {
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        setVelocidad(getVelocidad() + 15); // las motos aceleran distinto
        System.out.println(getMarca() + " " + getModelo() + " acelera (moto) a " + getVelocidad() + " km/h 🏍️");
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crear objetos
        Vehiculo v1 = new Vehiculo("Genérico", "X");
        Vehiculo c1 = new Coche("Toyota", "Corolla");
        Vehiculo m1 = new Moto("Yamaha", "R3");

        // Guardar en un arreglo/lista de tipo Vehiculo
        Vehiculo[] listaVehiculos = { v1, c1, m1 };

        // Recorrer y usar polimorfismo
        for (Vehiculo v : listaVehiculos) {
            v.mostrarInfo();
            v.acelerar();
            System.out.println();
        }
    }
}
