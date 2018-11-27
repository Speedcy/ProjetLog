package Interface;

import java.util.Vector;

import Physique.ParticuleChargee;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		// Création ParticuleChargee
		
		Vector<Double> position1 =new Vector<Double>(2);
		position1.add(50.0);
		position1.add(50.0);
		Vector<Double> position2 =new Vector<Double>(2);
		position2.add(41.0);
		position2.add(40.0);
		Vector<Double> vitesse =new Vector<Double>(2);
		vitesse.add(2.0);
		vitesse.add(0.0);
		ParticuleChargee p1 = new ParticuleChargee(position1,vitesse, 1.6*Math.pow(10, -19),9.1*Math.pow(10, -1));
		ParticuleChargee p2 = new ParticuleChargee(position2,vitesse, 1.6*Math.pow(10, -19),9.1*Math.pow(10, -1));
		
		Vector<Double> force =new Vector<Double>(2);
		force = p1.force(p2);
		System.out.println("Force" + force);
		
		Vector<Double> acc21 =new Vector<Double>(2);
		acc21 = p1.acceleration(p2, force);
		System.out.println("Acc2/1" + acc21);
		
		Vector<Double> acc12 =new Vector<Double>(2);
		acc12 = p2.acceleration(p1, force);
		System.out.println("Acc1/2" + acc12);
		
		
		Simulateur simulateur = new Simulateur();
		simulateur.addParticule(p1);
		simulateur.addParticule(p2);
		Milieu milieu= new Milieu();
		simulateur.addMilieu(milieu);
		
		
		// Création Particule, Milieu, Simulateur
		
		/*
		Simulateur simulateur = new Simulateur();
		Vector<Double> position =new Vector<Double>(2);
		position.add(50.0);
		position.add(50.0);
		System.out.println(position);
		Vector<Double> vitesse =new Vector<Double>(2);
		vitesse.add(2.0);
		vitesse.add(0.0);
		System.out.println(vitesse);		
		Particule particule = new Particule(position,vitesse);
		System.out.println(particule);
		simulateur.addParticule(particule);
		Milieu milieu= new Milieu();
		simulateur.addMilieu(milieu);
		System.out.println(milieu);
		System.out.println(simulateur);
		System.out.println(simulateur.getListeparticules());
		*/
		
		// Affichage
		
		EventQueue.invokeLater(new Runnable() {

		    @Override
		    public void run() {
		        Fenetre ex = new Fenetre(simulateur);
		        ex.setVisible(true);
		    }
		});
		
		

	}

}
