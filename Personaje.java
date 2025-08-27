public class Personaje {
    private String nombre;
    private String fruta;
    private Boolean bueno;
    private Integer recompensa;
    private Integer vida;
    private Integer ataque;

    public Personaje(String nombre, String fruta, Boolean bueno, Integer recompensa, Integer vida, Integer ataque) {
        this.nombre = nombre;
        this.fruta = fruta;
        this.bueno = bueno;
        this.recompensa = recompensa;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNombre() { return nombre; }
    public Integer getVida() { return vida; }
    public Integer getAtaque() { return ataque; }

    public void setVida(Integer vida) { this.vida = vida; }
    public void setAtaque(Integer ataque) { this.ataque = ataque; }

    public void mostrarPersonaje() {
        System.out.println("El nombre es: " + nombre);
        System.out.println("La fruta es: " + fruta);
        System.out.println("Es bueno: " + bueno);
        System.out.println("La recompensa es de: " + recompensa);
        System.out.println("La vida es: " + vida);
        System.out.println("El ataque es: " + ataque);
    }

    public void pelea(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + ataque + " de daño.");
        enemigo.vida -= this.ataque;
        System.out.println("La vida de " + enemigo.nombre + " ahora es " + enemigo.vida);
    }

    public void cura(Personaje aliado) {
        System.out.println(nombre + " cura a " + aliado.nombre + " sumando " + vida + " puntos de vida.");
        aliado.vida += this.vida;
        System.out.println("La vida de " + aliado.nombre + " ahora es " + aliado.vida);
    }

    public void proteje(Personaje aliado, Personaje enemigo) {
        System.out.println(nombre + " se interpone y protege a " + aliado.nombre + " del ataque de " + enemigo.nombre);
        this.vida -= enemigo.ataque;
        System.out.println(nombre + " ahora tiene " + this.vida + " de vida.");
    }

    public void transformar() {
        System.out.println(nombre + " intenta transformarse... pero no ocurre nada especial.");
    }

    static class Powerup extends Personaje {
        private int vidaExtra;
        private int ataqueExtra;

        public Powerup(String nombre, String fruta, boolean bueno, int recompensa, int vida, int ataque) {
            super(nombre, fruta, bueno, recompensa, vida, ataque);
            this.vidaExtra = 200;
            this.ataqueExtra = 100;
        }

        @Override
        public void transformar() {
            setVida(getVida() + vidaExtra);
            setAtaque(getAtaque() + ataqueExtra);

            System.out.println(getNombre() + " ha adquirido un PowerUp");
            System.out.println("Su vida ha incrementado +" + vidaExtra + " (ahora tiene " + getVida() + ")");
            System.out.println("Su ataque ha incrementado +" + ataqueExtra + " (ahora tiene " + getAtaque() + ")");
        }
    }


    public static void main(String[] args) {
        Personaje luffy = new Personaje("Luffy", "Gomu no mi", true,15000000 , 500, 400);
        Personaje kurogige = new Personaje("Kurogige", "Yami Yami no mi", true,35000000, 500, 400);
        Personaje chopper = new Personaje("Chopper", "Hito Hito no mi", true,100, 500, 300);
        Personaje Law = new Personaje("Law", "Ope Ope no mi", true,1000, 400, 240);
        
        Personaje luffyPower = new Powerup("Luffy", "Gomu no mi", true, 30000000, 500, 400);

        luffy.pelea(kurogige);
        chopper.cura(luffy);
        Law.proteje(chopper,kurogige);
        Law.transformar();

        luffyPower.transformar(); 
    
    }
}
