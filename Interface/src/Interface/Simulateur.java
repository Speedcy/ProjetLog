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
		// Execution d'une etape de la simulation : mise à jour des positions et vitesses
		//System.out.println("Processus lancé");
		
		int n = listeparticules.size();
		int N =milieux.size();
		
		ArrayList<Double> accelerationx = new ArrayList<Double>(n); // Tableau de longueur n que l'on va remplir pour qu'il contienne les accelerations de chaque particules
		ArrayList<Double> accelerationy = new ArrayList<Double>(n);
		
		for (int i = 0; i < n; i++) { // Initialisation des vecteurs accélération
			Particule p_i = listeparticules.get(i);
			accelerationx.add(0.0);
			accelerationy.add(0.0);
			System.out.println("la particule"+i);
			double accMx=0.0;
			double accMy=0.0;
			for(Milieu m: milieux) {
			// pour chaque millieu on accélere les particules
				
				Vector<Double> accM= m.calculAcceleration(p_i);
				accMx=accMx+accM.get(0);
				accMy=accMy+accM.get(1);
			}
			
			accelerationx.set(i,accMx);
			accelerationy.set(i, accMy);
			//System.out.println("accx = "+accMx);
			//System.out.println("accy = "+accMy);
			
		}
		
		for (int i = 0; i < n; i++) {
			Particule p_i = listeparticules.get(i);
			//System.out.println(" Boucle 1 p_i = "+p_i);
			//System.out.println("accy de la particule = "+i+accelerationy.get(i));
			Vector<Double> previousposition = new Vector<Double>(2);
			previousposition = p_i.getPosition();
			Vector<Double> previousvitesse = new Vector<Double>(2);
			previousvitesse = p_i.getVitesse();
			double newpositionx = previousposition.get(0) + previousvitesse.get(0)*t_step/100;
			double newpositiony = previousposition.get(1) + previousvitesse.get(1)*t_step/100;
			//System.out.println("vitesse en + " + previousvitesse.get(1)*t_step/100 );
			Vector<Double> newposition = new Vector<Double>(2);
			newposition.add(newpositionx);
			newposition.add(newpositiony);
			//System.out.println(newpositiony );
			
			System.out.println("particule"+i+"Nouvelle position =" + newposition);
			
			p_i.setPosition(newposition); // MISE A JOUR DE LA POSITION

			for (int j = i+1; j < n; j++) {
				//System.out.println("Valeur indice j =" + j);
				Particule p_j = listeparticules.get(j);
				//System.out.println("Boucle 2 p_j = "+p_j);
				
				
				Vector<Double> acc = new Vector<Double>(4);
				acc = p_i.calculAcceleration(p_j); // calcul des accélérations intermédiaires entre les particules i et j
				System.out.println("");
				System.out.println(acc);
				accelerationx.set(i,accelerationx.get(i)+acc.get(0)); // On ajoute l'accélération de la particule i par rapport à la particule j
				accelerationy.set(i,accelerationy.get(i)+acc.get(1));
				accelerationx.set(j,accelerationx.get(j)+acc.get(2)); 
				accelerationy.set(j,accelerationy.get(j)+acc.get(3));
				System.out.println("accelerationx " +i+j+" = "+accelerationx);
				System.out.println("accelerationy " +i+j+" = "+accelerationy);
			}
			
			double newvitessex = previousvitesse.get(0) + accelerationx.get(i)*t_step/100;
			double newvitessey = previousvitesse.get(1) + accelerationy.get(i)*t_step/100;
			
			Vector<Double> newvitesse = new Vector<Double>(2);
			newvitesse.add(newvitessex);
			newvitesse.add(newvitessey);
			
			//System.out.println("Nouvelle vitesse particule" + i + " = " + newvitesse);
			
			p_i.setVitesse(newvitesse); // MISE A JOUR DE LA VITESSE
		}
	}

}
