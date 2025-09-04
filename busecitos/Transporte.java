package busecitos;

public abstract class Transporte implements Vehiculo {
    private String marca;
    private String modelo;
    private int velocidadMaxima;

    public Transporte(String marca, String modelo, int velocidadMaxima){
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public abstract void tipoCombustible();

    public void mostrarInformacion(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad maxima: " + velocidadMaxima + " km por hora");
    }
}
