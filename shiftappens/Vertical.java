package shiftappens;

public class Vertical extends Evento {
    protected Cruzamento cruzamento;
    
    public Vertical (double i, Simulador s, Cruzamento cruzamento){
	    super (i, s);
	    this.cruzamento = cruzamento;
    }

    @Override
    public void executa (){
        this.cruzamento.vertical();
        this.cruzamento.move();
        this.s.waitingTime( this.cruzamento.time() * this.cruzamento.numberCars());
	s.insereEvento(new Horizontal(s.getInstante() + this.cruzamento.time(), s, this.cruzamento));
    }
}