package Interface;

import java.awt.Graphics2D;
import java.util.Vector;

public class Milieu {
	private Forme forme;
	
	public Milieu(){
		// Si pas de milieu à gérer
	}
	
	public Milieu(Forme forme){
		this.forme=forme;
	}

	@Override
	public String toString() {
		return "Milieu []";
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}
	public Vector<Double> calculAcceleration(Particule p) {
		Vector<Double> res= new Vector<Double>(2);
		res.add(0.0);
		res.add(0.0);
		return res;
	}
	
	public void draw(Graphics2D g2d, int w, int h) {
		forme.draw(g2d, w, h);
	}

}


