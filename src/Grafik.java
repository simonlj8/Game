import javax.swing.*;
import java.awt.*;
/**
 * @author Simon
 *
 */
public class Grafik extends JPanel {
	
	/**
	 * 
	 * 
	 */
	
	private int WIDTH = 100;
	private int HEIGHT = 100;
	private int d = 50; //diameter
	private int x = 0;
	private int y = 0;
	
	private int moveX = 1;
	private int moveY = 1;
	
	private void moveBall() {
		if(x + moveX <= 0)
			moveX = 1;
		if(x + moveX > getWidth() -d )
			moveX = -1;
		if(y + moveY < 0)
			moveY = 1;
		if(y + moveY > getHeight() -d )
			moveY = -1;
		x += moveX;
		y += moveY;
	}
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {		
		JFrame frame = new JFrame();
		Grafik grafik = new Grafik();
		
		frame.setSize(700, 800); // x, y
		frame.setLocation(900, 300);
		frame.setDefaultCloseOperation(3);
		frame.add(grafik);
		frame.setTitle("Simons Spel!");
		frame.setResizable(false);
		frame.setVisible(true);
		
		while(true) {
			grafik.moveBall();
			grafik.repaint();
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
		g2d.fillOval(x, y, d, d);
		/*g.setColor(Color.black);
		g.fillRect(0, 0, 800, 900);
		g.setColor(Color.red);
		g.drawRect(70, 100, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(160, 200, WIDTH, HEIGHT);
		g.setColor(Color.blue);
		g.drawOval(30, 250, WIDTH, d);
		g.setColor(Color.ORANGE);
		g.fillOval(400, 520, d, d);
	}*/
	}
}
