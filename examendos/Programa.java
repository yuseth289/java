package examendos;

public class Programa extends Inventor{
    private String software;

    public Programa(String nombre, Integer edad, int nivelDeCratividad, String software){
        super(nombre, edad, nivelDeCratividad);
        this.software = software;
    }
    
    @Override
    public void presentar(){
        System.out.println("El participante " + getNombre() + " presenta un software ingenioso: " + software);
    }

    
}

