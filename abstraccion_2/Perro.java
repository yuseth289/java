package abstraccion_2;

public class Perro extends Sonido implements Color {
    private String ladrido;

    public Perro(){
        this.ladrido = "wao";
    }

    public Perro(String ladrido){
        this.ladrido = ladrido;
    }

    @Override
    public String reproducirSonido(){
        return ladrido;
    }

    @Override
    public String getColor() {
        return "marrón";
    }
}
