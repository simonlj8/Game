import javax.swing.*;
import java.awt.*;
/**
 * @author Simon
 *
 */
public class Game extends JPanel {
	Ball ball = new Ball(this);
	
	private void move() {
		ball.moveBall();
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
		
	}
}
