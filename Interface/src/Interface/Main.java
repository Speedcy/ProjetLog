package Interface;

import java.util.Vector;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
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
		
		EventQueue.invokeLater(new Runnable() {

		    @Override
		    public void run() {
		        Fenetre ex = new Fenetre(simulateur);
		        ex.setVisible(true);
		    }
		});
		

	}

}
