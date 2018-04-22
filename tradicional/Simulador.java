package tradicional;


import java.util.Scanner;

public final class Simulador {
    private double instante;
    private int timer;
    private final ListaEventos lista;
    private final TrafficGenerator world;
    private int waitingTime;
    
    public Simulador( int timeSemaforo) {
        this.timer = 1000;
	instante = 0;
        this.waitingTime = 0;
        
        lista = new ListaEventos(this);
        
        this.world = new TrafficGenerator( timeSemaforo);
        Scanner sc = new Scanner(System.in);
        System.out.print("Estrada de cima: ");
        int number1 = sc.nextInt();
        System.out.print("Estrada de esquerda: ");
        int number2 = sc.nextInt();
        System.out.print("Estrada de baixo: ");
        int number3 = sc.nextInt();
        System.out.print("Estrada de direita: ");
        int number4 = sc.nextInt();
        
        this.world.addCars( number1, number2, number3, number4);
        for(Cruzamento cruzamento: this.world.cruzamento()){
            insereEvento( new Vertical ( this.instante, this, cruzamento));
        }
    }
    
    void waitingTime( int time){
        this.waitingTime = this.waitingTime + time;
    }

    void insereEvento (Evento e1){
        lista.insereEvento (e1);
    }

    void removeEvento(Evento e1){
        lista.remove(e1);
    }  

    private void print( TrafficGenerator world){
        int i = 0;
        for(Road road: world.roads()){
            System.out.println("Road " + i + ": " + road.numberCars());
            i++;
        }
        System.out.println();
    }
    
    public void executa (){
	Evento e1;
	while (this.timer > 0){
            this.timer--;
            e1 = (Evento)(lista.removeFirst()); 
            instante = e1.getInstante();
            e1.executa();
	}
        System.out.println("Tempo medio de espera " + this.waitingTime/ this.world.numberCars());
    }
    
    public double getInstante() {
        return instante;
    }
}