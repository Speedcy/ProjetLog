package Interface;

import java.util.Vector;

public class Particule {
	private Vector<Double> position;
	private Vector<Double>	vitesse;
	
	public Particule(Vector<Double> p, Vector<Double> v){
		position=p;
		vitesse=v;
	}

	@Override
	public String toString() {
		return "Particule [position=" + position + ", vitesse=" + vitesse + "]";
	}

}
