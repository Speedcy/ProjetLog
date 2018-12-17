package Interface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Vector;

import Physique.ParticuleChargee;

public class Particule {
	private Vector<Double> position;
	private Vector<Double>	vitesse;
	private Vector<Double> vitessepre;
	private Color color = Color.blue;
	
	public Particule(Vector<Double> p, Vector<Double> v){
		position=p;
		vitesse=v;
		vitessepre=new Vector<Double>(2);
		vitessepre.add(0.0);
		vitessepre.add(0.0);
	}

	public Vector<Double> getVitessepre() {
		return vitessepre;
	}

	public void setVitessepre(Vector<Double> vitessepre) {
		this.vitessepre = vitessepre;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Particule [position=" + position + ", vitesse=" + vitesse + "]";
	}
	
	public Vector<Double> getPosition() {
		return position;
	}

	public Vector<Double> getVitesse() {
		return vitesse;
	}
	
	public void setPosition(Vector<Double> position) {
		this.position = position;
	}

	public void setVitesse(Vector<Double> vitesse) {
		this.vitesse = vitesse;
	}

	public Vector<Double> calculAcceleration(Particule p) {
		System.out.println("Attention : appel à la méthode calculAcceleration de la classe Particule");
		Vector<Double> vecteur =new Vector<Double>(4);
		vecteur.add(0.0);
		vecteur.add(0.0);
		vecteur.add(0.0);
		vecteur.add(0.0);
		return vecteur;
	}
	
	public void draw(Graphics2D g2d, int w, int h) {
		g2d.setPaint(color);
		int x = (int) Math.round(position.get(0)); // arrondi à un entier (pixel)
		int y = (int) Math.round(position.get(1));
		g2d.fillOval(w/2+x, h/2-y, 5, 5);
	}

}
