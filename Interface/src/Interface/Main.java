package Interface;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Physique.TaskForPC;
import Physique.Config;
import Physique.ParticuleChargee;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		

		// Test sur le temps
		
		double masse = 9.1*Math.pow(10, -31);
		double charge = -1.6*Math.pow(10,-19);
		
		
		Config config = new Config(50, 500, 500);
		//config.ajoutParticules(5000, charge, masse); // ajout de particules à vitesse initiale nulle
		
		Milieu milieu= new Milieu();
		config.getSimulateur().addMilieu(milieu);

		
		/*
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(150 + Math.random()*100);
			position.add(150 + Math.random()*100);
			ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
			simulateur.addParticule(p);
		}*/
		
		 
		// Création Particule, Milieu, Simulateur

		/*
		 * Simulateur simulateur = new Simulateur(); Vector<Double> position =new
		 * Vector<Double>(2); position.add(50.0); position.add(50.0);
		 * System.out.println(position); Vector<Double> vitesse =new Vector<Double>(2);
		 * vitesse.add(2.0); vitesse.add(0.0); System.out.println(vitesse); Particule
		 * particule = new Particule(position,vitesse); System.out.println(particule);
		 * simulateur.addParticule(particule); Milieu milieu= new Milieu();
		 * simulateur.addMilieu(milieu); System.out.println(milieu);
		 * System.out.println(simulateur);
		 * System.out.println(simulateur.getListeparticules());
		 */

		// Affichage

		
		 EventQueue.invokeLater(new Runnable() {
		 
		 @Override public void run() { 
			 Fenetre fenetre = new Fenetre(config.getSimulateur(),config.getTaillefenetrex(),config.getTaillefenetrey());
			 fenetre.setVisible(true);
			 // start sim (fenetre)
			 startSimulation(config.getSimulateur(), fenetre, config.getT_step());
		 }
		 });
		 
		 

	}
	
	public static void startSimulation(Simulateur simulateur, Fenetre fenetre, int t_step){
		TimerTask timerTask = new TaskForPC(simulateur, fenetre);
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, t_step);
		System.out.println("Lancement execution");
	}
	
	// Gestion du Timer
	/*
	 TimerTask timerTask = new TaskForPC(simulateur);
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, t_step);
		System.out.println("Lancement execution");

		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();

		System.out.println("Abandon execution");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/

}
