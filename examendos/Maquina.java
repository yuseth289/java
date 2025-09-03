package examendos;

public class Maquina extends Inventor{
    private String maquina;

    public Maquina(String nombre, Integer edad, int nivelDeCratividad, String maquina){
        super(nombre, edad, nivelDeCratividad);
        this.maquina = maquina;
    }
    
    @Override
    public void presentar(){
        System.out.println("El participante " + getNombre() + " presenta la máquina mecánica: " + maquina);
    }

    
}


