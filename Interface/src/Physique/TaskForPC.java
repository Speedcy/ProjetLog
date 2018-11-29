package Physique;

import java.util.Date;
import java.util.TimerTask;

import Interface.Fenetre;
import Interface.Simulateur;

public class TaskForPC extends TimerTask {
	// Mettre a jour la position et la vitesse
	private Simulateur s;
	private Fenetre f;
	
	public TaskForPC(Simulateur sim, Fenetre fenetre) {
		s = sim;
		f = fenetre;
	}

	@Override
	public void run() {
		System.out.println("Debut execution tache " + new Date());

		try {

			s.step(); // Mise à jour des positions et vitesses
			f.update(); // Mise à jour de l'affichage
			// Faire doDrawing
			// fenetre.update(); ou fenetre.surface.update()
			Thread.sleep(s.getT_step());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin execution tache " + new Date());
	}
}
