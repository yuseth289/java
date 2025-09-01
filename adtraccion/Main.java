package adtraccion;

public class Main {
    public static void main(String[] args){
        Figura circulo = new Circulo(5D);
        Figura cuadrado = new Cuadrado(4D);

        System.out.println("El area del circulo es: " + circulo.calcularArea());
        System.out.println("El area del cuadrado es: " + cuadrado.calcularArea());
    }
}
