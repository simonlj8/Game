import javax.swing.*;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Simon
 * TODO: Make menu so player can choose speed of the ball.
 * 		* Add a Higscore
 * 		* Fix bug: If ball touches the very corner of racket, the points raise with 3-7 ??	
 * 		* Highscore just write name, not points.
 * 		* Add a JOptionPane to show highscores
 */
public class Game extends JPanel {
	Ball ball = new Ball(this);
	Racket racket = new Racket(this);
	Font scoreFont = new Font("SansSerif", Font.BOLD, 30);
	
	public Game() {
		addKeyListener(new KeyListener() {
			//String keyString = "";
			
			public void keyTyped(KeyEvent e) {
				// Not used				
			}			
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				racket.KeyReleased(e);
			}			
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				racket.keyPressed(e);
			}
		}
	);
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
		frame.setTitle("Simple game made in Java");
		frame.setResizable(false);
		frame.setVisible(true);
		//frame.setAlwaysOnTop(true);
		game.welcomMessage();
		
		/*ArrayList<Image> imageList = new ArrayList<Image>();
	     imageList.add(image);
	     setIconImages(imageList);*/

		
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(3);
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
		g2d.setFont(scoreFont);
		g2d.drawString("Score: " + ball.getScore(), 15, 30);
	}
	
	
	public void score() {
		// JOptionPane.showInputDialog(this, "Your Name?", "Your Name?", JOptionPane.QUESTION_MESSAGE);		
		// String text = JOptionPane.showInputDialog(this, "Your Name?", "Your Name?", JOptionPane.QUESTION_MESSAGE);
		String text = JOptionPane.showInputDialog(this, "Game over!\n" + "You got: " + ball.getScore() + " Points", "Your name for HighScore!");
		try { 
			FileWriter writer = new FileWriter("Score.txt", true);			
			writer.write("\n" + text + " " + ball.getScore() );         
			writer.close();
			      
		}
         catch (IOException e) {
	            e.printStackTrace();
	        }
		System.exit(ABORT);
	}
	
	
	public void gameOver() {	
         JOptionPane.showMessageDialog(this, "Game over! \nClick Ok to close game", "Game over", JOptionPane.YES_NO_CANCEL_OPTION);
 		 System.exit(ABORT);
		 } 
		
	
	
	
	public void welcomMessage() {
		JOptionPane.showMessageDialog(this, "How to play \nUse LEFT and RIGHT key to controll the racket \nIf the you miss the ball, it's Game over \nClick OK to start game!", "How to?", JOptionPane.YES_NO_CANCEL_OPTION);
	}
}
