package Interface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Vector;

import Physique.ParticuleChargee;

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
	
	public void draw(Graphics2D g2d) {
		g2d.setPaint(Color.green);
		float alpha = 0.1f;
        AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alcom);
		int[] x = {0,100,100,0};
		int[] y = {0, 0, 100, 100};
		g2d.fillPolygon(x, y, 4);
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2d.setComposite(alcom);
	}

}


