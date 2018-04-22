package tradicional;
        


public class Car{
    private final int[] position;
    private final int[] destiny;
    
    public Car( int x, int y, int finalX, int finalY){
        this.position = new int[]{ x, y};
        this.destiny  = new int[]{ finalX, finalY};
    }
    
    public void update( int x, int y){
        this.position[0] += x;
        this.position[1] += y;
    }
    
    public boolean reachDestiny(){
        return (this.position[0] == this.destiny[0] && this.position[1] == this.destiny[1]);
    }
    
    public int[] getPosition(){
        return this.position;
    }
    
    public int[] getDestiny(){
        return this.destiny;
    }
}
