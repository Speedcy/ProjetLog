package Plague;

import java.awt.Color;
import java.util.Vector;

import Interface.Particule;
import Interface.Simulateur;

public class Config2 {
	
	private int t_step;
	private int taillefenetrex;
	private int taillefenetrey;
	private Simulateur simulateur;
	
	public Config2(int t_step, int taillefenetrex, int taillefenetrey) {
		this.t_step = t_step;
		this.taillefenetrex = taillefenetrex;
		this.taillefenetrey = taillefenetrey;
		this.simulateur = new Simulateur(t_step);
	}
	
	
		
	public void ajoutePersonne(int nbparticules) {
		// Particules de vitesse nulle
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(Math.random()*taillefenetrex/5-taillefenetrex/10);
			position.add(Math.random()*taillefenetrey/5-taillefenetrey/10);
			Boolean sante;
			
			if (Math.random()<0.9) {
				sante=true; }
			else {
				sante=false;
			}
			Personne p1 = new Personne(position, vitesse, sante);
			if (!sante) {
				p1.setColor(Color.red);
			}
			//System.out.println(signealeatoire);

			
			simulateur.addParticule(p1);
			
	
	//public void ajoutUnitaire(Vector<Double> position, Vector<Double> vitesse, double charge, double masse) {
		//ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
		//simulateur.addParticule(p);
	}
	
	//public void ajoutUnitaire(ParticuleChargee p) {
		//simulateur.addParticule(p);
	}

	public void setT_step(int t_step) {
		this.t_step = t_step;
	}



	public void setTaillefenetrex(int taillefenetrex) {
		this.taillefenetrex = taillefenetrex;
	}



	public void setTaillefenetrey(int taillefenetrey) {
		this.taillefenetrey = taillefenetrey;
	}



	public void setSimulateur(Simulateur simulateur) {
		this.simulateur = simulateur;
	}



	public int getTaillefenetrex() {
		return taillefenetrex;
	}

	public int getTaillefenetrey() {
		return taillefenetrey;
	}

	public Simulateur getSimulateur() {
		return simulateur;
	}

	public int getT_step() {
		return t_step;
	}
}