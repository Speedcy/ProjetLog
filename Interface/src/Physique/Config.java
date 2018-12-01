package Physique;

import java.util.Vector;

import Interface.Simulateur;

public class Config {
	
	private int t_step;
	private int taillefenetrex;
	private int taillefenetrey;
	private Simulateur simulateur;
	
	public Config(int t_step, int taillefenetrex, int taillefenetrey) {
		this.t_step = t_step;
		this.taillefenetrex = taillefenetrex;
		this.taillefenetrey = taillefenetrey;
		this.simulateur = new Simulateur(t_step);
	}
	
	public void ajoutParticules(int nbparticules, double charge, double masse) {
		// Particules de vitesse nulle
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(taillefenetrex*5/12 + Math.random()*taillefenetrex*2/12);
			position.add(taillefenetrey*5/12 + Math.random()*taillefenetrey*2/12);
			ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
			simulateur.addParticule(p);
		}
	}
	
	public void ajoutUnitaire(Vector<Double> position, Vector<Double> vitesse, double charge, double masse) {
		ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
		simulateur.addParticule(p);
	}
	
	public void ajoutUnitaire(ParticuleChargee p) {
		simulateur.addParticule(p);
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
