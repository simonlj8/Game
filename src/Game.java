import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author Simon
 *
 */
public class Game extends JPanel {
	Ball ball = new Ball(this);
	Racket racket = new Racket(this);
	
	public Game() {
		addKeyListener(new KeyListener() {
			
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				racket.KeyReleased(e);
			}
			
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				racket.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.moveBall();
		racket.move();
	}
	/**
	 * 
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {		
		JFrame frame = new JFrame();
		Game game = new Game();
		
		frame.setSize(700, 800); // x, y
		frame.setLocation(900, 300);
		frame.setDefaultCloseOperation(3);
		frame.add(game);
		frame.setTitle("Simons Spel!");
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		

	
	public void paint(Graphics g) {		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		racket.paint(g2d);
		
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game over!", "Game over", JOptionPane.YES_NO_OPTION);;
		System.exit(ABORT);
	}
}
