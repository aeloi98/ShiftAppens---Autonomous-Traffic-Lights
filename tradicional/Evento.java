package tradicional;


public abstract class Evento {

    protected double instante; 
    protected Simulador s;

    Evento (double i, Simulador s){
	instante = i;
        this.s = s;
    }

    public boolean menor (Evento e1){
        return (instante < e1.instante);
    }

    abstract void executa ();

    public double getInstante() {
        return instante;
    }
}