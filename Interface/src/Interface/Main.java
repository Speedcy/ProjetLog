package Interface;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Physique.TaskForPC;

import Physique.ParticuleChargee;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		

		// Test sur le temps
		int t_step = 50;
		int nbparticules = 500;
		
		Simulateur simulateur = new Simulateur(t_step); 
		
		double masse = 9.1*Math.pow(10, -31);
		double charge = -1.6*Math.pow(10,-19);
		
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(150 + Math.random()*100);
			position.add(150 + Math.random()*100);
			ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
			simulateur.addParticule(p);
		}
 
		 /*ParticuleChargee p1 = new ParticuleChargee(position1,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, -31));
		 ParticuleChargee p2 = new ParticuleChargee(position2,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, -31));
		 
		 Vector<Double> force =new Vector<Double>(2); force = p1.force(p2);
		 System.out.println("ForceMain" + force);
		 
		 Vector<Double> acc21 =new Vector<Double>(2); acc21 = p1.acceleration(p2,
		 force); System.out.println("Acc2/1Main" + acc21);
		 
		 Vector<Double> acc12 =new Vector<Double>(2); acc12 = p2.acceleration(p1,
		 force); System.out.println("Acc1/2Main" + acc12);
		 
		 System.out.println("");*/

		 Milieu milieu= new Milieu();
		 simulateur.addMilieu(milieu);
		
		

		// Création ParticuleChargee

		/*
		int t_step = 100;
		 Vector<Double> position1 =new Vector<Double>(2); 
		 position1.add(50.0);
		 position1.add(50.0); 
		 Vector<Double> position2 =new Vector<Double>(2);
		 position2.add(41.0); 
		 position2.add(40.0); Vector<Double> vitesse =new Vector<Double>(2); 
		 vitesse.add(2.0); vitesse.add(0.0); ParticuleChargee p1 = new ParticuleChargee(position1,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, -1));
		 ParticuleChargee p2 = new ParticuleChargee(position2,vitesse, 1.6*Math.pow(10, -19),9.1*Math.pow(10,-1));
		 
		 Vector<Double> force =new Vector<Double>(2); force = p1.force(p2);
		 System.out.println("Force" + force);
		 
		 Vector<Double> acc21 =new Vector<Double>(2); acc21 = p1.acceleration(p2,
		 force); System.out.println("Acc2/1" + acc21);
		 
		 Vector<Double> acc12 =new Vector<Double>(2); acc12 = p2.acceleration(p1,
		 force); System.out.println("Acc1/2" + acc12);
		 
		 
		 Simulateur simulateur = new Simulateur(t_step); 
		 simulateur.addParticule(p1);
		 simulateur.addParticule(p2); Milieu milieu= new Milieu();
		 simulateur.addMilieu(milieu);
		 */
		 
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
			 Fenetre fenetre = new Fenetre(simulateur);
			 fenetre.setVisible(true);
			 // start sim (fenetre)
			 startSimulation(simulateur, fenetre, t_step);
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
