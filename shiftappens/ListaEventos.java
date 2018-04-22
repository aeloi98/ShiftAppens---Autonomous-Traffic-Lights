package shiftappens;

import java.util.*;

public class ListaEventos extends LinkedList<Evento> {
    private final Simulador s; 
    
    ListaEventos (Simulador s){
        this.s = s;
    }

    public void insereEvento (Evento e1){
	int i = 0;
        while (i < size() && ((Evento)get(i)).menor(e1)) i++;
        add(i, e1);
    }
}