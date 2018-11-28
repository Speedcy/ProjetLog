package Interface;

import java.util.ArrayList;
import java.util.Vector;

public class Simulateur {
	private Vector<Particule> listeparticules = new Vector<Particule>();
	private Vector<Milieu> milieux = new Vector<Milieu>();
	private int t_step = 100; // intervalle de temps entre deux calculs de la simulation (en ms)

	public Simulateur(int t) {
		t_step = t;
	}

	public Vector<Particule> getListeparticules() {
		return listeparticules;
	}

	public void addParticule(Particule particule) {
		listeparticules.add(particule);
	}

	public void addMilieu(Milieu milieu) {
		milieux.add(milieu);
	}

	public int getT_step() {
		return t_step;
	}

	@Override
	public String toString() {
		return "Simulateur [listeparticules=" + listeparticules + ", milieux=" + milieux + "]";
	}
	
	public void step() {
		// Execution d'une etape de la simulation : mise � jour des positions et vitesses
		System.out.println("Processus lanc�");
		
		int n = listeparticules.size();
		
		ArrayList<Double> accelerationx = new ArrayList<Double>(n); // Tableau de longueur n que l'on va remplir pour qu'il contienne les accelerations de chaque particules
		ArrayList<Double> accelerationy = new ArrayList<Double>(n);
		
		for (int i = 0; i < n; i++) { // Initialisation des vecteurs acc�l�ration
			accelerationx.add(0.0);
			accelerationy.add(0.0);
		}
		
		System.out.println("accelerationx = "+accelerationx);
		
		
		for (int i = 0; i < n; i++) {
			Particule p_i = listeparticules.get(i);
			System.out.println("p_i = "+p_i);
			
			Vector<Double> previousposition = new Vector<Double>(2);
			previousposition = p_i.getPosition();
			Vector<Double> previousvitesse = new Vector<Double>(2);
			previousvitesse = p_i.getVitesse();
			double newpositionx = previousposition.get(0) + previousvitesse.get(0)*t_step/1000;
			double newpositiony = previousposition.get(1) + previousvitesse.get(1)*t_step/1000;
			
			Vector<Double> newposition = new Vector<Double>(2);
			newposition.add(newpositionx);
			newposition.add(newpositiony);
			
			System.out.println("Nouvelle position =" + newposition);
			
			p_i.setPosition(newposition); // MISE A JOUR DE LA POSITION

			for (int j = i+1; j < n; i++) {
				Particule p_j = listeparticules.get(j);
				System.out.println("p_j = "+p_j);
				
				
				Vector<Double> acc = new Vector<Double>(4);
				acc = p_i.calculAcceleration(p_j); // calcul des acc�l�rations interm�diaires entre les particules i et j
				System.out.println(acc);
				accelerationx.set(i,accelerationx.get(i)+acc.get(0)); // On ajoute l'acc�l�ration de la particule i par rapport � la particule j
				accelerationy.set(i,accelerationy.get(i)+acc.get(1));
				accelerationx.set(j,accelerationx.get(j)+acc.get(2)); 
				accelerationy.set(j,accelerationy.get(j)+acc.get(3));
			}
			
			double newvitessex = previousvitesse.get(0) + accelerationx.get(0)*t_step/1000;
			double newvitessey = previousvitesse.get(1) + accelerationy.get(1)*t_step/1000;
			
			Vector<Double> newvitesse = new Vector<Double>(2);
			newvitesse.add(newvitessex);
			newvitesse.add(newvitessey);
			
			System.out.println("Nouvelle vitesse" + newvitesse);
			
			p_i.setVitesse(newvitesse); // MISE A JOUR DE LA VITESSE
		}
	}

}
