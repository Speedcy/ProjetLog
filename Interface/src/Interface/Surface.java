package Interface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		int w = getWidth();
		int h = getHeight();

		//System.out.println(sim.getListeparticules());
		
		
		for (Milieu m : sim.getMilieux()) {
			m.draw(g2d, w, h);
		}

		for (Particule p : sim.getListeparticules()) {
			p.draw(g2d, w, h);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); // est appel� � chaque event (WindowEvent e)
	}
	
	public void update() {
		repaint();
	}
}
