package shiftappens;

public class Road{
    private final TraficL semaforo;
    private int numberCars;
    

    public Road (){
        this.semaforo = new TraficL();
        this.numberCars = 0;
    }
    
    public void changeTrafficL (String s){
        this.semaforo.changeTrafficL(s);
    }

    public boolean color(){
        return semaforo.color().equals("green");
    }

    public int numberCars(){
        return this.numberCars;
    }

    //vamos alterar o numero de carros na faixa.
    //e os carros tem de ser transferidos de/para a faixa
    public void changeNumberCars( int change){
        this.numberCars = this.numberCars + change;
        if(this.numberCars < 0){
            this.numberCars = 0;
        }
    }
}
