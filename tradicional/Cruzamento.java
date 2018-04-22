package tradicional;




public class Cruzamento {
    private final Road[] inputRoads;      //estradas que entram
    private int time;
    private final int timeSemaforo;

    public Cruzamento ( Road[] inputRoads, int time){
        this.inputRoads = new Road[ inputRoads.length];
        System.arraycopy(inputRoads, 0, this.inputRoads, 0, inputRoads.length);
        this.timeSemaforo = time;
    }

    public void vertical (){
        if(inputRoads[1] != null){
            inputRoads[1].changeTrafficL( "red");
        }

        if(inputRoads[3] != null){
            inputRoads[3].changeTrafficL( "red");
        }

        if(inputRoads[0] != null){
            inputRoads[0].changeTrafficL( "green");
        }

        if(inputRoads[2] != null){
            inputRoads[2].changeTrafficL( "green");
        }
    }

    public void horizontal (){
        if(inputRoads[1] != null){
            inputRoads[1].changeTrafficL( "green");
        }

        if(inputRoads[3] != null){
            inputRoads[3].changeTrafficL( "green");
        }

        if(inputRoads[0] != null){
            inputRoads[0].changeTrafficL( "red");
        }

        if(inputRoads[2] != null){
            inputRoads[2].changeTrafficL( "red");
        }   
    }

    //tempo ideal para escoamento de carros
    public void calculateBestCombination( Road[] inputRoads){
        int going = 0;
        int waiting = 0;
        int max = 0;
        for (Road inputRoad : inputRoads) {
            if (inputRoad.color()) {
                going = going + inputRoad.numberCars();
                if(max < inputRoad.numberCars())
                    max = inputRoad.numberCars();
            } else {
                waiting = waiting + inputRoad.numberCars();
            }
        }

        if(going == 0){
            this.time = 0;
        }
        else if(waiting == 0){
            this.time = going + 2;
        }
        else{
            this.time = this.timeSemaforo + 2;
        }
    }
    

    public void move(){
        calculateBestCombination( inputRoads);

        for (Road inputRoad : inputRoads) {
            if (inputRoad != null) {
                //se o semáforo estiver verde, evacuamos os carros para outra estrada.
                if (inputRoad.color()) {
                    if(this.time != 0)
                        inputRoad.changeNumberCars( -this.time + 2);
                }
            }
        }
    }

    public int time() {
        return this.time;
    }
    
    public int numberCars(){
        int sum = 0;
        for(Road inputRoad: inputRoads){
            sum = sum + inputRoad.numberCars();
        }
        return sum;
    }
}
