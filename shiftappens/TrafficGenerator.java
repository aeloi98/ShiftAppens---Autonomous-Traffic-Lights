package shiftappens;

public class TrafficGenerator {
    private final Road[] roads;
    private final Cruzamento[] cruzamentos;
    private int numberCars;
    
    public TrafficGenerator(){
        this.numberCars = 0;
        Road road1 = new Road();
        Road road2 = new Road();
        Road road3 = new Road();
        Road road4 = new Road();
        
        
        this.roads = new Road[]{ road1, road2, road3, road4};
        
        Cruzamento cruzamento1 = new Cruzamento( roads);
        cruzamentos = new Cruzamento[]{ cruzamento1};
    }

    public void addCars(int number1, int number2, int number3, int number4){
        this.numberCars = this.numberCars + number1 + number2 + number3 + number4;
        this.roads[0].changeNumberCars( number1);
        this.roads[1].changeNumberCars( number2);
        this.roads[2].changeNumberCars( number3);
        this.roads[3].changeNumberCars( number4);
    }
    
    public Cruzamento[] cruzamento(){
        return this.cruzamentos;
    }
    
    public Road[] roads(){
        return this.roads;
    }

    public int numberCars() {
        return this.numberCars;
    }
}
