package tradicional;

public class Horizontal extends Evento {
    private final Cruzamento cruzamento;
    
    public Horizontal (double i, Simulador s, Cruzamento cruzamento){
	    super (i, s);
	    this.cruzamento = cruzamento;
    }

    @Override
    public void executa (){
        this.cruzamento.horizontal();
        this.cruzamento.move();
        this.s.waitingTime( this.cruzamento.time() * this.cruzamento.numberCars());
	s.insereEvento(new Vertical(s.getInstante() + this.cruzamento.time(), s, this.cruzamento));
    }
}