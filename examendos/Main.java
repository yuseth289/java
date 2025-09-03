package examendos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Inventor> inventores = new ArrayList<>();

        Inventor yuseth = new Programa("Yuseth", 19, 5, "Sistema de Reservas de Restaurante");
        Inventor velasco = new Quimico("Velasco", 18, 5, "Reacción del Ácido Sulfúrico");
        Inventor lisandro = new Maquina("Lisandro", 18, 5, "Escoba Electrónica");

        inventores.add(yuseth);
        inventores.add(velasco);
        inventores.add(lisandro);

        yuseth.ganarPuntos();
        System.err.println();
        velasco.ganarPuntos();
        System.out.println();

        yuseth.presentar();
        System.out.println();
        velasco.presentar();
        System.out.println();
        lisandro.presentar();
    }
}
