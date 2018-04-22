package tradicional;

import java.util.Scanner;

public class ShiftAppens {

    public static void main(String[] args) {
        System.out.print("Tempo de semaforo: ");
        Simulador simulador = new Simulador( (new Scanner(System.in).nextInt()));
        simulador.executa();
    }
    
}
