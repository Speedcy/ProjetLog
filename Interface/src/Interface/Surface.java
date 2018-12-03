package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {
	private final int DELAY = 150;
	private Timer timer;
	private Simulateur sim;

	public Surface(Simulateur simulateur) {

		initTimer();
		sim = simulateur;
	}

	private void initTimer() {

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public Timer getTimer() {

		return timer;
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(Color.pink);

		int w = getWidth();
		int h = getHeight();

		//System.out.println(sim.getListeparticules());

		for (Particule p : sim.getListeparticules()) {
			g2d.setPaint(p.getColor());
			Vector<Double> position = p.getPosition();
			int x = (int) Math.round(position.get(0)); // arrondi à un entier (pixel)
			int y = (int) Math.round(position.get(1));
			g2d.fillOval(w/2+x, h/2-y, 5, 5);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); // est appelé à chaque event (WindowEvent e)
	}
	
	public void update() {
		repaint();
	}
}
