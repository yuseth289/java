package abstraccion_2;

public class Gato extends Sonido implements Color {
    private String maullido;

    public Gato(){
        this.maullido = "miau";
    }

    public Gato(String maullido){
        this.maullido = maullido;
    }

    @Override
    public String reproducirSonido(){
        return maullido;
    }

    @Override
    public String getColor() {
        return "gris";
    }
}
