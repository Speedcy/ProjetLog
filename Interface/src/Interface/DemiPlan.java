package Interface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Vector;

public class DemiPlan extends Forme{
	@Override
	public String toString() {
		return "DemiPlan [point=" + point + ", vecteur=" + vecteur + "]";
	}

	private Vector<Double> point;
	private Vector<Double> vecteur;
	
	public DemiPlan(Vector<Double> point,Vector<Double> vecteur) {
		super();
		this.point=point;
		this.vecteur=vecteur;
		// TODO Auto-generated constructor stub
	}

	public boolean estDedans(Particule p) {
		Vector<Double> placementParticule=Calculateur.dif(p.getPosition(),point);
		return Calculateur.produitscalaire(placementParticule,vecteur)>0;
	}
	
	public void draw(Graphics2D g2d,int w, int h) {
		//System.out.println("Dessin demi-plan");
		g2d.setPaint(Color.green);
		float alpha = 0.3f;
        AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alcom);
        int x_point = (int) Math.round(this.point.get(0));
        int y_point = (int) Math.round(this.point.get(1));
        int x_vect = (int) (Math.round(this.vecteur.get(0)*10*w));
        int y_vect = (int) (Math.round(this.vecteur.get(1)*10*h));
        int x_par = -y_vect;
        int y_par = x_vect;
		//int[] x = {x_point+x_par, x_point+x_par,x_point+x_vect,x_point+x_vect};
		//int[] y = {y_point+y_par, y_point-y_par, y_point+y_vect, y_point-y_vect};
        //int[] x = {w/2+x_point-10, w/2+x_point+10,w/2+x_point+10,w/2+x_point-10};
        //int[] y = {h/2+y_point-10, h/2+y_point-10, h/2+y_point+10, h/2+y_point+10};
        //System.out.println(x_point);
        //System.out.println(y_point);
        //System.out.println(x_par);
        //System.out.println(y_par);
        int[] x = {w/2-10+x_point+x_vect, w/2+10+x_point+x_vect,w/2+10+x_point+y_vect,w/2-10+x_point-y_vect};
        int[] y = {h/2-10-y_point-y_vect, h/2-10-y_point-y_vect, h/2+10-y_point+x_vect, h/2+10-y_point-x_vect};
		g2d.fillPolygon(x, y, 4);
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2d.setComposite(alcom);
	}

}
