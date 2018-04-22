package tradicional;



public class TraficL extends Thread{
    private boolean green;
    private boolean yellow;
    private boolean red;


    public TraficL (){
        green = false;
        red = false;
    }

    public void changeTrafficL (String s){
        switch (s) {
            case "green":
                redToGreen();
                break;
            case "red":
                greenToRed();
                break;
            default:
                System.out.println("Erro a dizer a cor - mudar semaforo");
                break;
        }
    }

    public String color(){
        if(green == true){
            return "green";
        }
        else if(red){
            return "red";
        }
        else{
            return "yellow";
        }
    }

    private void greenToRed (){
        green = false;
        red = true;
    }

    private void redToGreen (){
        red = false;
        green = true;
    }
}
