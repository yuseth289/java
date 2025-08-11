public class Personaje {
    String nombre;
    String poder;
    Boolean arma;
    Boolean bueno;
    Integer vida;
    Integer ataque;

    public Personaje(String nombre, String poder, Boolean arma, Boolean bueno, Integer vida, Integer ataque) {
        this.nombre = nombre;
        this.poder = poder;
        this.arma = arma;
        this.bueno = bueno;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void mostrarPersonaje(){
        System.out.println("El nombre es: " + nombre);
        System.out.println("El poder es: " + poder);
        System.out.println("El arma es: " + arma);
        System.out.println("El bueno es: " + bueno);
        System.out.println("El vida es: " + vida);
        System.out.println("El ataque es: " + ataque);
    }

    public void pelea(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + ataque + " de daño.");
        enemigo.vida -= this.ataque;
        System.out.println("La vida de " + enemigo.nombre + " ahora es " + enemigo.vida);
    }

    public void cura(Personaje aliado) {
        System.out.println(nombre + " cura a " + aliado.nombre + " sumado puntos de " + vida);
        aliado.vida += this.vida;
        System.out.println("La vida de " + aliado.nombre + " ahora es " + aliado.vida);
    }

    public static void main(String[] args) {
        Personaje ironman = new Personaje("Ironman", "Plata", true, true, 100, 90);
        Personaje spiderman = new Personaje("Spiderman", "Sentido aracnido", true, true, 100, 80);
        Personaje doctorStrange = new Personaje("doctorStrange", "curar", true, true, 100, 100);

        ironman.mostrarPersonaje();
        System.out.println();
        spiderman.mostrarPersonaje();
        System.out.println();
        ironman.pelea(spiderman);
        System.out.println();
        doctorStrange.mostrarPersonaje();
        System.out.println();
        doctorStrange.cura(spiderman);

} 


}