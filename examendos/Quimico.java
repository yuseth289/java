package examendos;

public class Quimico extends Inventor{
    private String experimento;

    public Quimico(String nombre, Integer edad, int nivelDeCratividad, String experimento){
        super(nombre, edad, nivelDeCratividad);
        this.experimento = experimento;
    }
    
    @Override
    public void presentar(){
        System.out.println("El participante " + getNombre() + " presenta el experimento químico: " + experimento);
    }

    
}
