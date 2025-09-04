package busecitos;

public class Bicicleta extends Transporte {

    public Bicicleta(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void arrancar() {
        System.out.println("La bicicleta se esta moviendo");
    }

    @Override
    public void detener() {
        System.out.println("La bicicleta se paro");
    }

    @Override
    public void tipoCombustible() {
        System.out.println("La bicicleta no usa combustible");
    }
}