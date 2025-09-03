package examendos;

public class Inventor {
    private String nombre;
    private int edad;
    private int nivelDeCreatividad;

    public Inventor(String nombre, int edad, int nivelDeCratividad){
        this.nombre = nombre;
        this.edad = edad;
        this.nivelDeCreatividad = nivelDeCratividad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public int getNivelDeCreatividad() {
        return nivelDeCreatividad;
    }

    public void ganarPuntos(){
        System.out.println( "El participante "+ nombre + " gana un punto");
        this.nivelDeCreatividad += 1 ;
    }

    public void presentar(){
        System.out.println("El participante " + nombre + " presenta su invento de forma única.");
    }



}


